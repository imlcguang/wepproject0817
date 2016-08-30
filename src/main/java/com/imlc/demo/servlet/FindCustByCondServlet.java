package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			T_Customer customer = new T_Customer();
			String CustomerName = request.getParameter("customerName");
			String RelationName = request.getParameter("relationName");
			String RelationPhone = request.getParameter("relationPhone");
			// 1.封装
			customer.setCustomerName(CustomerName);
			customer.setRelationName(RelationName);
			customer.setRelationPhone(RelationPhone);

			// 2.调用Service中模糊客户信息的方法
			CustomerService cs = new CustomerService();
			List<T_Customer> list = (List<T_Customer>) cs.findCustByCond(customer);
			if(list==null){
				throw new MsgException("找不到该客户!");
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listCust.jsp").forward(request, response);
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
