package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class UpdateCustServlet
 */
@WebServlet("/UpdateCustServlet")
public class UpdateCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustServlet() {
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
		T_Customer customer = new T_Customer();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String CustomerName = request.getParameter("CustomerName");
			String RelationName = request.getParameter("RelationName");
			String RelationPhone = request.getParameter("RelationPhone");
			String Address = request.getParameter("Address");
			String Email = request.getParameter("Email");
			String Remark = request.getParameter("Remark");
			// 封装
			// BeanUtils.populate(customer, request.getParameterMap());
			customer.setCustomerName(CustomerName);
			customer.setRelationName(RelationName);
			customer.setRelationPhone(RelationPhone);
			customer.setAddress(Address);
			customer.setEmail(Email);
			customer.setRemark(Remark);

			// 1.获取要查询的客户id,转换为integer
			String id1 = request.getParameter("id");
			System.out.println("id=" + id1);
			Integer id = Integer.parseInt(id1);
			customer.setCustomerID(id);
			// 2.调用Service中修改客户信息的方法
			CustomerService cs = new CustomerService();
			cs.updateCustomers(customer);

			// 3.重定向到客户列表页面
			request.getRequestDispatcher("/ListCustServlet").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
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
