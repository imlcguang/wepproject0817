//用户注册
package com.imlc.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.UserService;
import com.imlc.demo.util.MD5Util;

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
		Logger log = LoggerFactory.getLogger(LogbackDemo.class);  
		T_User u = new T_User();
		String loginName, password, password2, userName, userSex;
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
			password = MD5Util.MD5(request.getParameter("Password"));
			password2 = MD5Util.MD5(request.getParameter("Password2"));
			userName = request.getParameter("UserName");
			userSex = request.getParameter("UserSex");
			functionPopedom1 = request.getParameterValues("FunctionPopedom");

			if ("".equals(functionPopedom1) || functionPopedom1 == null) {
				functionPopedom = "0000000";
			} 
			else {
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
			}
			// 封装 优化方法：BeanUtils.populate(user, request.getParameterMap());
			u.setLoginName(loginName);
			u.setPassword(password);
			u.setPassword2(password2);
			u.setUserName(userName);
			u.setUserSex(userSex);
			u.setFunctionPopedom(functionPopedom);
			// 验证填入的信息是否为空
			u.checkValue();
			UserService.getInstance().registUser(u);
			// 带数据过去,登录用户
			request.getSession().setAttribute("regUser", u);
			// 请求转发
			// request.getRequestDispatcher("/userinfo.jsp").forward(request,
			// response);
			// 提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!2秒回到主页....");
			response.setHeader("refresh", "2;url=" + request.getContextPath() + "/index.jsp");
			log.info("执行用户注册，添加的用户为："+u);
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/user.jsp").forward(request, response);
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
