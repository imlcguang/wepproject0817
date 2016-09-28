package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.ModelService;
import com.imlc.demo.service.UserService;
import com.imlc.demo.util.MD5Util;

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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
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
		Logger log = LoggerFactory.getLogger(LogbackDemo.class);  
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String loginName, password;
		// 获取
		loginName = request.getParameter("loginName");
		password = MD5Util.MD5(request.getParameter("userPWD"));
		
		// 查找
		T_User user = UserService.getInstance().isUser(loginName, password);

		if (user == null) {
			// 如果不正确则提示
			request.setAttribute("msg", "用户名密码不正确!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			log.info("执行用户登录，登录失败");
			return;
		} else {
			// 正确则登录用户后重定向回到主页
			request.getSession().setAttribute("regUser", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			log.info("执行用户登录，登录的用户为："+user);
		}

	}

}
