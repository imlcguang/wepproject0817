package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.service.BorrowRecordService;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class BorrowInfoServlet
 */
@WebServlet("/BorrowInfoServlet")
public class BorrowInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取要查询的id
		String id = request.getParameter("id");
		// 2.调用Service中根据id查找客户的方法
		BorrowRecordService bs = new BorrowRecordService();
		T_BorrowRecord borrow = bs.findBorrowByID(id);
		
		System.out.println(borrow.toString());
		// 3.将查找到的客户信息存入request域中,请求转发到updateCust.jsp页面展示
		request.setAttribute("borrow", borrow);
		request.getRequestDispatcher("/updateBorrow.jsp").forward(request, response);

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
