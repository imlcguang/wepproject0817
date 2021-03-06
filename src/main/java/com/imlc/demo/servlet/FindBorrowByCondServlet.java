package com.imlc.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.BorrowRecordService;

/**
 * Servlet implementation class FindBorrowByCondServlet
 */
@WebServlet("/FindBorrowByCondServlet")
public class FindBorrowByCondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindBorrowByCondServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(LogbackDemo.class);  
		T_BorrowRecord b = new T_BorrowRecord();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// 1 获取
			String CustomerID = request.getParameter("CustomerID");
			String ModelID = request.getParameter("ModelID");
			String BorrowOperatDatetime = request.getParameter("BorrowOperatDatetime");
			String BorrowPermitPerson = request.getParameter("BorrowPermitPerson");
			String BorrowCheckNo = request.getParameter("BorrowCheckNo");
			String ReturnDatetime = request.getParameter("ReturnDatetime");
			String isreturn = request.getParameter("Return");
			int nulltmp=0;
			// 2封装
			if (CustomerID != null && (!"".equals(CustomerID))) {
				T_Customer customer = new T_Customer();
				Integer i = Integer.parseInt(CustomerID);
				customer.setCustomerID(i);
				b.setCustomerID(customer);
				nulltmp=1;
			}
		
			if (ModelID != null && (!"".equals(ModelID))) {
				T_Model model = new T_Model();
				Integer i2 = Integer.parseInt(ModelID);
				model.setModelID(i2);
				b.setModelID(model);
				nulltmp=1;
			}
			if (BorrowOperatDatetime != null && (!"".equals(BorrowOperatDatetime))) {
				if(!BorrowOperatDatetime.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")){
					throw new MsgException("操作日期格式不正确!YYYY-MM-DD");
				}
				Date date = sdf.parse(BorrowOperatDatetime);
				b.setBorrowOperatDatetime(date);
				nulltmp=1;
			}

			if (BorrowPermitPerson != null && (!"".equals(BorrowPermitPerson))) {
				T_User user = new T_User();
				Integer i2 = Integer.parseInt(BorrowPermitPerson);
				user.setUserID(i2);
				b.setBorrowPermitPerson(user);
				nulltmp=1;
			}
			if (BorrowCheckNo != null && (!"".equals(BorrowCheckNo))) {
				b.setBorrowCheckNo(BorrowCheckNo);
				nulltmp=1;
			}
			if (ReturnDatetime != null && (!"".equals(ReturnDatetime))) {
				if(!ReturnDatetime.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")){
					throw new MsgException("归还日期格式不正确!YYYY-MM-DD");
				}
				Date date2 = sdf.parse(ReturnDatetime);
				b.setReturnDatetime(date2);
				nulltmp=1;
			}
			
			if ( (!"any".equals(isreturn))) {
				nulltmp=1;
			}
			
			if(nulltmp==0)
			{
				request.getRequestDispatcher("/ListBorrowServlet").forward(request, response);
			}
			// 4调用service中的条件查询方法
			List<T_BorrowRecord> list = (List<T_BorrowRecord>) BorrowRecordService.getInstance().findBorrowByCond(b, isreturn);
			

			// 5提示注册成功3秒回到主页
			request.setAttribute("recordResult", list);
			request.getRequestDispatcher("/listBorrow.jsp").forward(request, response);
			log.info("执行查询操作");
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/listBorrow.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
