package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.ModelService;

/**
 * Servlet implementation class FindModelByModelName
 */
@WebServlet("/FindModelByModelName")
public class FindModelByModelName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindModelByModelName() {
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
		try {
			String ModelName = request.getParameter("ModelName");
			List<T_Model> listm = ModelService.getInstance().findByModelName(ModelName);
			//请求转发
			request.setAttribute("listm", listm);
			request.getRequestDispatcher("/listModel.jsp").forward(request, response);
			log.info("执行查询操作");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
