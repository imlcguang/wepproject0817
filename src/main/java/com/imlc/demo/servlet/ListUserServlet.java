package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.CustomerService;
import com.imlc.demo.service.UserService;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<T_User> listu = UserService.getInstance().findAllUser();
		 ServletContext sc=this.getServletContext();  
		 sc.setAttribute("listu", listu);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(LogbackDemo.class); 
		List<T_User> listu = UserService.getInstance().findAllUser();
		 ServletContext sc=this.getServletContext();  
		 sc.setAttribute("listu", listu);
		request.getRequestDispatcher("/listUser.jsp").forward(request, response);
		log.info("执行用户列表操作");
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
