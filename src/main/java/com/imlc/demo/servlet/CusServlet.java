package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.BorrowRecordService;
import com.imlc.demo.service.CustomerService;

/**
 * Servlet implementation class CusServlet
 */
public class CusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CusServlet() {
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
			//BeanUtils.populate(customer, request.getParameterMap());
			customer.setCustomerName(CustomerName);
			customer.setRelationName(RelationName);
			customer.setRelationPhone(RelationPhone);
			customer.setAddress(Address);
			customer.setEmail(Email);
			customer.setRemark(Remark);
			
			System.out.println("address: "+customer.getAddress());
			
			// 验证填入的信息是否为空
			customer.checkValue();
			System.out.println(customer.toString());
			
			//判断客户名是否已存在，否则添加客户
			CustomerService.getInstance().registCustomer(customer);
			
			request.getSession().setAttribute("Customer", customer);
			//提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			log.info("执行添加客户操作");
		}catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/customer.jsp").forward(request, response);
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
