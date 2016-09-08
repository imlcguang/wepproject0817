//用户注册
package com.imlc.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.service.UserService;

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
	 * 用户注册
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		T_User u = new T_User();
		String loginName, password,password2, userName, userSex;
		String[] functionPopedom1;
		String functionPopedom = "0";
		int temp = 0, num = 0;

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 检验验证码
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistr");
			if (valistr == null || valistr2 == null || !valistr.equals(valistr2)) {
				request.setAttribute("msg", "验证码不正确!");
				request.getRequestDispatcher("/user.jsp").forward(request, response);
				return;
			}

			// 获取表单数据
			loginName = request.getParameter("LoginName");
			password = request.getParameter("Password");
			password2 = request.getParameter("Password2");
			userName = request.getParameter("UserName");
			userSex = request.getParameter("UserSex");
			functionPopedom1 = request.getParameterValues("FunctionPopedom");

			// 如果没选会出现空指针异常，这个问题还没解决
			for (int i = 0; i < functionPopedom1.length; i++) {
				// 获得权限
				temp = 1 << Integer.parseInt(functionPopedom1[i]) - 1;
				num += temp;
			}

			// 权限转换成二进制
			functionPopedom = Integer.toBinaryString(num);
			// 权限补成七位权限
			while (functionPopedom.length() < 7)
				functionPopedom = "0" + functionPopedom;

			// 封装 优化方法：BeanUtils.populate(user, request.getParameterMap());
			u.setLoginName(loginName);
			u.setPassword(password);
			u.setPassword2(password2);
			u.setUserName(userName);
			u.setUserSex(userSex);
			u.setFunctionPopedom(functionPopedom);
			// 验证填入的信息是否为空
	
			u.checkValue();

			System.out.println(u.toString());

			
			UserService.getInstance().registUser(u);
			// 带数据过去,登录用户
			request.getSession().setAttribute("regUser", u);
			// 请求转发
			//request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
			//提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/user.jsp").forward(request, response);
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
