package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class CustInfoServlet
 */
@WebServlet("/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取要查询的客户id
		String id1 = request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		CustomerService cs = new CustomerService();
		Integer id=Integer.parseInt(id1);
		T_Customer cust = cs.findCustById(id);
		if (cust == null) {
			request.setAttribute("msg", "找不到该客户!");
			request.getRequestDispatcher("/listCust.jsp").forward(request, response);
			return;
		}
		System.out.println(cust.toString());
		//3.将查找到的客户信息存入request域中,请求转发到updateCust.jsp页面展示
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);

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
