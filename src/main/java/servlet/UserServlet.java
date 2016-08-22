package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.T_User;

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
		String[] functionPopedom;

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
			functionPopedom = request.getParameterValues("FunctionPopedom");

			System.out.println(userSex);
			System.out.println(functionPopedom);

			if (functionPopedom == null)
				System.out.println("null");
			else {
				System.out.println("not null");
				for (int i = 0; i < functionPopedom.length; i++)
					System.out.println("functionPopedom:" + i + ":" + functionPopedom[i]);

			}

			u.setLoginName(loginName);
			u.setPassword(password);
			u.setUserName(userName);
			u.setUserSex(userSex);
			u.setFunctionPopedom(functionPopedom);

			request.getSession().setAttribute("regUser", u);
			// ��ת��ע��ɹ�ҳ��
		    request.getRequestDispatcher("/userinfo.jsp").forward(request,response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
