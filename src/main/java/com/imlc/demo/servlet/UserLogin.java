package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.service.UserService;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String loginName, password;
		// 获取
		loginName = request.getParameter("loginName");
		password = request.getParameter("userPWD");
		// 查找
		T_User user = UserService.getInstance().isUser(loginName, password);

		if (user == null) {
			// 如果不正确则提示
			request.setAttribute("msg", "用户名密码不正确!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			// 正确则登录用户后重定向回到主页
			request.getSession().setAttribute("regUser", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

}
