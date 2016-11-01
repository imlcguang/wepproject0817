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

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class FindCustByCondServlet
 */
@WebServlet("/FindCustByCondServlet")
public class FindCustByCondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCustByCondServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			T_Customer customer = new T_Customer();
			String CustomerName = request.getParameter("customerName");
			String RelationName = request.getParameter("relationName");
			String RelationPhone = request.getParameter("relationPhone");
			int nulltmp = 0;

			// 1.封装
			customer.setCustomerName(CustomerName);
			customer.setRelationName(RelationName);
			customer.setRelationPhone(RelationPhone);

			if (CustomerName != null && (!"".equals(CustomerName)) || RelationName != null && (!"".equals(RelationName))
					|| RelationPhone != null && (!"".equals(RelationPhone))) {
				nulltmp = 1;
			}

			if (nulltmp == 1) {
				// 2.调用Service中模糊客户信息的方法
				List<T_Customer> listc = (List<T_Customer>) CustomerService.getInstance().findCustByCond(customer);
				if (listc == null) {
					throw new MsgException("找不到该客户!");
				}
				request.setAttribute("recordResult", listc);
				request.getRequestDispatcher("/listCust.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/ListCustServlet").forward(request, response);
			}

			log.info("执行查询操作");
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/listCust.jsp").forward(request, response);
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
