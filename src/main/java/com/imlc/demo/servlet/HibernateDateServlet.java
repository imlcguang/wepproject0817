package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.service.HibernateRecordService;

/**
 * Servlet implementation class HibernateDateServlet
 */
@WebServlet("/HibernateDateServlet")
public class HibernateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HibernateDateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int pageIndex = 1;
		int pageSize = 9;
		String strIndex = request.getParameter("pageIndex");
		if (strIndex == null) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(strIndex);// 将得到的页面数据转换成Integer保存到pageIndex中
		}

		List<T_BorrowRecord> recordResult = HibernateRecordService.getInstance().findRecord(pageIndex, pageSize);// 调用方法得到的数据封装到list
		
		request.getSession().setAttribute("pageIndex", pageIndex);// 将页面数据保存到session中
		request.getSession().setAttribute("pageList", recordResult);// 将list保存到session中
		request.getRequestDispatcher("hibernateRecord.jsp").forward(request, response);
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
