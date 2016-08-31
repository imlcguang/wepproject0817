package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.ForwardingFileObject;

import org.apache.taglibs.standard.lang.jstl.UnaryMinusOperator;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.service.UserService;

/**
 * Servlet implementation class FindUserByNameServlet
 */
@WebServlet("/FindUserByNameServlet")
public class FindUserByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			T_User user =new T_User();
			String userName=request.getParameter("userName");
			
			UserService us=new UserService();
			List<T_User> list=us.findUserByName(userName);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listUser.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}