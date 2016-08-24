package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.dao.LoginDao;
import com.imlc.demo.entity.T_User;

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
		request.setCharacterEncoding("utf-8");
		T_User u = new T_User();
		// Integer userID;
		String loginName, password;

		/*
		 * String username,mypassword,gender,email,introduce,isAccept; Date
		 * birthday; String[] favorites; SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd");
		 */
		try {
			loginName = request.getParameter("userName");
			password = request.getParameter("userPWD");

			u.setLoginName(loginName);
			u.setPassword(password);
			System.out.println(loginName);
			System.out.println(password);
			LoginDao ld=new LoginDao();
			ld.findByLoginName(loginName);

			// request.getSession().setAttribute("regUser", u);
			// ��ת��ע��ɹ�ҳ��
			// request.getRequestDispatcher("/userinfo.jsp").forward(request,response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
