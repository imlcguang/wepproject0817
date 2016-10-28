package com.imlc.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.BorrowRecordService;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {
			// 1.获取要查询的客户id
			String id = request.getParameter("id");
			// 2.调用Service中根据id查找借机表的方法
			T_BorrowRecord borrow = BorrowRecordService.getInstance().findBorrowByID(id);
			// 获取数据并封装
			
			String ReturnOperator = request.getParameter("ReturnOperator");
			if(ReturnOperator==null || "".equals(ReturnOperator)){
				throw new MsgException("归还操作员不能为空!");
			}
			else{
			T_User returnop = BorrowRecordService.getInstance().findUserById(ReturnOperator);
			borrow.setReturnOperator(returnop);

			 /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 borrow.setReturnDatetime(df.format(new Date()));*/
			borrow.setReturnDatetime(new Date());

			// 调用service中的return方法
			BorrowRecordService.getInstance().returnRecord(borrow);
			}
			// 3.请求转发到list.jsp页面展示
			request.getRequestDispatcher("/ListBorrowServlet").forward(request, response);
			log.info("执行归还操作");
		} catch (MsgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/returnBorrow.jsp").forward(request, response);
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
