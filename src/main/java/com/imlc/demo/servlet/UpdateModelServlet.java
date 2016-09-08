package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.service.ModelService;

/**
 * Servlet implementation class UpdateModelServlet
 */
@WebServlet("/UpdateModelServlet")
public class UpdateModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateModelServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		try {
			//封装
			String modelName=request.getParameter("modelName");
			String modelVersion=request.getParameter("modelVersion");
			String modelDesc=request.getParameter("modelDesc");
			String id1=request.getParameter("id");
			Integer id = Integer.parseInt(id1);
			T_Model t=ModelService.getInstance().findModelById(id);
			t.setModelName(modelName);
			t.setModelVersion(modelVersion);
			t.setModelDesc(modelDesc);
			//调用service中的update方法
			ModelService.getInstance().updateModels(t);
			
			request.getRequestDispatcher("/ListModelServlet").forward(request, response);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
