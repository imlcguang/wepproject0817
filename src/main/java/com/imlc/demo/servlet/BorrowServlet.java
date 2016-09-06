package com.imlc.demo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.service.BorrowRecordService;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		T_BorrowRecord b = new T_BorrowRecord();
		BorrowRecordService bs = new BorrowRecordService();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			//1 获取
			String CustomerID = request.getParameter("CustomerID");
			String SendDatetime = request.getParameter("SendDatetime");
			String BorrowPermitPerson = request.getParameter("BorrowPermitPerson");
			String BorrowOperator = request.getParameter("BorrowOperator");
			String PlanReturnDatetime = request.getParameter("PlanReturnDatetime");
			String ModelID = request.getParameter("ModelID");
			String BorrowNumber = request.getParameter("BorrowNumber");
			String BorrowCheckNo = request.getParameter("BorrowCheckNo");

			/*
			 * BeanUtils.populate(b, request.getParameterMap()); Map map
			 * =request.getParameterMap(); bs.borrowRecord(b);
			 */
			// 2封装
			T_Customer customer = bs.findCustById(CustomerID);
			b.setCustomerID(customer);

			b.setSendDatetime(SendDatetime);
			// 检查是否存在，存在则返回，否则报错
			T_User userpermit = bs.findUserById(BorrowPermitPerson);
			T_User useroper = bs.findUserById(BorrowOperator);
			b.setBorrowPermitPerson(userpermit);
			b.setBorrowOperator(useroper);
			
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//b.setBorrowOperatDatetime(df.format(new Date()));
			b.setBorrowOperatDatetime(new Date());
			b.setPlanReturnDatetime(PlanReturnDatetime);

			T_Model model = bs.findModelById(ModelID);
			b.setModelID(model);

			b.setBorrowNumber(BorrowNumber);
			b.setBorrowCheckNo(BorrowCheckNo);

			System.out.println(b.toString());
			//3 检查是否为空
			b.checkValue();
			// 4调用service中的增加方法
			bs.borrowRecord(b);
			System.out.println(b.toString());

			request.getSession().setAttribute("Borrow", b);
			// 5提示注册成功3秒回到主页
			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");

		} catch (MsgException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/borrow.jsp").forward(request, response);
			return;

		} catch (Exception e) {
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
