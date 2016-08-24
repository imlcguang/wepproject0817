package com.imlc.demo.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.dao.UserDao;
import com.imlc.demo.entity.T_User;

/**
 * Servlet implementation class RegServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
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
		request.setCharacterEncoding("utf-8");

		T_User u = new T_User();
		// Integer userID;
		String loginName, password, userName, userSex;
		String[] functionPopedom1;
		String functionPopedom = "0";
		int temp = 0, num = 0;

		/*
		 * String username,mypassword,gender,email,introduce,isAccept; Date
		 * birthday; String[] favorites; SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd");
		 */
		try {
			loginName = request.getParameter("LoginName");
			password = request.getParameter("Password");
			userName = request.getParameter("UserName");
			userSex = request.getParameter("UserSex");
			functionPopedom1 = request.getParameterValues("FunctionPopedom");

			 //System.out.println(userSex);
			// System.out.println(functionPopedom1);

			
				for (int i = 0; i < functionPopedom1.length; i++) {
					// 获得权限
					// System.out.println("functionPopedom1:" + i + ":" +
					// functionPopedom1[i]);
					temp = 1 << Integer.parseInt(functionPopedom1[i]) - 1;
					num += temp;
				

			}
			// 权限转换成二进制
			functionPopedom = Integer.toBinaryString(num);
			// 权限补成七位权限
			while (functionPopedom.length() < 7)
				functionPopedom = "0" + functionPopedom;

			//System.out.println("functionPopedom" + functionPopedom);
			
			u.setLoginName(loginName);
			u.setPassword(password);
			u.setUserName(userName);
			u.setUserSex(userSex);
			u.setFunctionPopedom(functionPopedom);
			
			System.out.println(u.toString());
			
			UserDao ud=new UserDao();
			ud.testSaveUser(u);

			request.getSession().setAttribute("regUser", u);
			// ��ת��ע��ɹ�ҳ��
			request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
