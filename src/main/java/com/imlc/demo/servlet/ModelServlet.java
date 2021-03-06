package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.ModelService;

/**
 * Servlet implementation class ModelServlet
 */
@WebServlet("/ModelServlet")
public class ModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModelServlet() {
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
		T_Model model = new T_Model();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String ModelName = request.getParameter("ModelName");
			String ModelVersion = request.getParameter("ModelVersion");
			String ModelDesc = request.getParameter("ModelDesc");
		

			// 封装
			//BeanUtils.populate(Model, request.getParameterMap());
			model.setModelName(ModelName);
			model.setModelVersion(ModelVersion);
			model.setModelDesc(ModelDesc);
		
			// 验证填入的信息是否为空
			model.checkValue();
			System.out.println(model.toString());
			
			//判断客户名是否已存在，否则添加客户
			ModelService.getInstance().registModel(model);
			
			request.getSession().setAttribute("Model", model);
			//提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			log.info("执行添加样机操作");
		}catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/model.jsp").forward(request, response);
			return;
		}catch (Exception e) {
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
