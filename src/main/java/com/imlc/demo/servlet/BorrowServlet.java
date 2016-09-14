package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// 1 获取
			String CustomerID = request.getParameter("CustomerID");
			String SendDatetime = request.getParameter("SendDatetime");
			String BorrowPermitPerson = request.getParameter("BorrowPermitPerson");
			String BorrowOperator = request.getParameter("BorrowOperator");
			String PlanReturnDatetime = request.getParameter("PlanReturnDatetime");
			String ModelID = request.getParameter("ModelID");
			String BorrowNumber = request.getParameter("BorrowNumber");
			String BorrowCheckNo = request.getParameter("BorrowCheckNo");

			/*
			 * BeanUtils.populate(b, request.getParameterMap()); Map map
			 * =request.getParameterMap(); bs.borrowRecord(b);
			 */
			// 2封装
			if (CustomerID != null && (!"".equals(CustomerID))) {
				if(!CustomerID.matches("[0-9]{1,}")){
					throw new MsgException("id格式不正确!");
				}
				T_Customer customer = BorrowRecordService.getInstance().findCustById(CustomerID);
				b.setCustomerID(customer);
			}
			if (SendDatetime != null && (!"".equals(SendDatetime))) {
				b.setSendDatetime(SendDatetime);
			}
			// 检查是否存在，存在则返回，否则报错
			if (BorrowPermitPerson != null && (!"".equals(BorrowPermitPerson))) {
				if(!BorrowPermitPerson.matches("[0-9]{1,}")){
					throw new MsgException("id格式不正确!");
				}
				T_User userpermit = BorrowRecordService.getInstance().findUserById(BorrowPermitPerson);
				b.setBorrowPermitPerson(userpermit);
			}
			if (BorrowOperator != null && (!"".equals(BorrowOperator))) {
				if(!BorrowOperator.matches("[0-9]{1,}")){
					throw new MsgException("id格式不正确!");
				}
				T_User useroper = BorrowRecordService.getInstance().findUserById(BorrowOperator);
				b.setBorrowOperator(useroper);
			}
			// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			// b.setBorrowOperatDatetime(df.format(new Date()));
			b.setBorrowOperatDatetime(new Date());
			if (PlanReturnDatetime != null && (!"".equals(PlanReturnDatetime))) {
				if(!PlanReturnDatetime.matches("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)")){
					throw new MsgException("日期格式不正确!YYYY-MM-DD");
				}
				b.setPlanReturnDatetime(PlanReturnDatetime);
			}
			if (ModelID != null && (!"".equals(ModelID))) {
				if(!ModelID.matches("[0-9]{1,}")){
					throw new MsgException("id格式不正确!");
				}
				T_Model model = BorrowRecordService.getInstance().findModelById(ModelID);
				b.setModelID(model);
			}
			if (BorrowNumber != null && (!"".equals(BorrowNumber))) {
				if(!BorrowNumber.matches("[1-9]{1,}[0-9]{0,}")){
					throw new MsgException("借机数量格式不正确!");
				}
				b.setBorrowNumber(BorrowNumber);
			}
			if (BorrowCheckNo != null && (!"".equals(BorrowCheckNo))) {
				b.setBorrowCheckNo(BorrowCheckNo);
			}
			System.out.println(b.toString());
			// 3 检查是否为空
			b.checkValue();
			// 4调用service中的增加方法
			BorrowRecordService.getInstance().borrowRecord(b);
			System.out.println(b.toString());

			request.getSession().setAttribute("Borrow", b);
			// 5提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!2秒回到主页....");
			response.setHeader("refresh", "2;url=" + request.getContextPath() + "/index.jsp");
			log.info("执行添加借机信息操作");
		} catch (MsgException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/borrow.jsp").forward(request, response);
			return;

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
