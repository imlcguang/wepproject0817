package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.service.CustomerService;
import com.imlc.demo.service.UserService;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.获取要查询的id
		String id1 = request.getParameter("id");
		// 2.调用Service中根据id查找用户的方法
		UserService us=new UserService();
		Integer id = Integer.parseInt(id1);
		T_User user=us.findUserByID(id);
		
		if (user  == null) {
			request.setAttribute("msg", "找不到该客户!");
			request.getRequestDispatcher("/listUser.jsp").forward(request, response);
			return;
		}
		System.out.println(user.toString());
		// 3.将查找到的客户信息存入request域中,请求转发到updateCust.jsp页面展示
		request.setAttribute("user", user );
		request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
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