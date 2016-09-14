package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.CustomerService;
import com.imlc.demo.service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
			// 1.获取要查询的客户id,转换为integer,得到对应ID的用户
			String id1 = request.getParameter("id");
			Integer id = Integer.parseInt(id1);
			T_User u = UserService.getInstance().findUserByID(id);

			String userName = request.getParameter("UserName");
			String userSex = request.getParameter("UserSex");
			String[] functionPopedom1 = request.getParameterValues("FunctionPopedom");
			String functionPopedom = "0";
			int temp = 0, num = 0;
			String password, password2;

			if ("".equals(functionPopedom1) || functionPopedom1 == null) {
				functionPopedom = "0000000";
			} else {
				for (int i = 0; i < functionPopedom1.length; i++) {
					// 获得权限
					temp = 1 << Integer.parseInt(functionPopedom1[i]) - 1;
					System.out.println(i+" : "+functionPopedom1[i]);
					num += temp;
				}

				// 权限转换成二进制
				functionPopedom = Integer.toBinaryString(num);
				// 权限补成七位权限
				while (functionPopedom.length() < 7)
					functionPopedom = "0" + functionPopedom;
			}
			System.out.println("functionPepodom:"+functionPopedom);
			// 封装
			u.setUserName(userName);
			u.setUserSex(userSex);
			u.setFunctionPopedom(functionPopedom);
			// 2.调用Service中修改客户信息的方法
			UserService.getInstance().updateUser(u);

			// 3.重定向到客户列表页面
			request.getRequestDispatcher("/ListUserServlet").forward(request, response);
			log.info("执行用户信息修改");
		} catch (Exception e) {
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
