package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.CustomerService;
import com.imlc.demo.service.ModelService;

/**
 * Servlet implementation class ListModelServlet
 */
@WebServlet(urlPatterns ={"/ListModelServlet"}, loadOnStartup = 0)

public class ListModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListModelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<T_Model> listm = ModelService.getInstance().findAllModel();
		ServletContext sc = this.getServletContext();
		sc.setAttribute("listm", listm);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(LogbackDemo.class);
		
		int pageIndex = 1;
		int pageSize = 10;
		// 总记录数
		int totalCount = ModelService.getInstance().countrecord();
		// 总页数
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		String strIndex = request.getParameter("pageIndex");
		if (strIndex == null) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(strIndex);// 将得到的页面数据转换成Integer保存到pageIndex中
		}
		List<T_Model> recordResult =  ModelService.getInstance().findAllModel(pageIndex, pageSize);// 调用方法得到的数据封装到list

		request.getSession().setAttribute("pageIndex", pageIndex);// 将页面数据保存到session中
		request.getSession().setAttribute("recordResult", recordResult);// 将list保存到session中
		request.getSession().setAttribute("totalCount", totalCount);
		request.getSession().setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("/listModel.jsp").forward(request, response);
		log.info("执行样机列表操作");
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
