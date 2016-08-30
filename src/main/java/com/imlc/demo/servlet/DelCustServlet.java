package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class DelCustServlet
 */
@WebServlet("/DelCustServlet")
public class DelCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelCustServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取要查询的客户id
		String id1 = request.getParameter("id");
		// 2.调用Service中根据id查找客户的方法
		CustomerService cs = new CustomerService();
		Integer id = Integer.parseInt(id1);
		T_Customer cust = cs.findCustById(id);
		cs.DeleteCustomers(cust);
		//3.请求转发到客户列表页面
		request.getRequestDispatcher("/ListCustServlet").forward(request, response);
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
