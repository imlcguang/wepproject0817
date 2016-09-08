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
 * Servlet implementation class UpdateBorrowServlet
 */
@WebServlet("/UpdateBorrowServlet")
public class UpdateBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBorrowServlet() {
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
			// 1 获取
			String CustomerID = request.getParameter("CustomerID");
			String SendDatetime = request.getParameter("SendDatetime");
			String BorrowPermitPerson = request.getParameter("BorrowPermitPerson");
			String BorrowOperator = request.getParameter("BorrowOperator");
			String PlanReturnDatetime = request.getParameter("PlanReturnDatetime");
			String ModelID = request.getParameter("ModelID");
			String BorrowNumber = request.getParameter("BorrowNumber");
			String BorrowCheckNo = request.getParameter("BorrowCheckNo");
			String ReturnOperator = request.getParameter("ReturnOperator");

			// 1.获取要查询的客户id
			String id = request.getParameter("id");
			// 2.调用Service中根据id查找借机表的方法
			T_BorrowRecord b = BorrowRecordService.getInstance().findBorrowByID(id);
			// 2封装
			T_Customer customer = BorrowRecordService.getInstance().findCustById(CustomerID);
			b.setCustomerID(customer);

			b.setSendDatetime(SendDatetime);
			// 检查是否存在，存在则返回，否则报错
			T_User userpermit = BorrowRecordService.getInstance().findUserById(BorrowPermitPerson);
			T_User useroper = BorrowRecordService.getInstance().findUserById(BorrowOperator);
			b.setBorrowPermitPerson(userpermit);
			b.setBorrowOperator(useroper);
			b.setPlanReturnDatetime(PlanReturnDatetime);

			T_Model model = BorrowRecordService.getInstance().findModelById(ModelID);
			b.setModelID(model);

			b.setBorrowNumber(BorrowNumber);
			b.setBorrowCheckNo(BorrowCheckNo);

			T_User returnop = BorrowRecordService.getInstance().findUserById(ReturnOperator);
			b.setReturnOperator(returnop);
			System.out.println(b.toString());
			// 3 检查是否为空
			b.checkValue();
			// 4调用service中的修改方法
			BorrowRecordService.getInstance().updateBorrowRecord(b);
			System.out.println(b.toString());

			request.getSession().setAttribute("Borrow", b);
			// 3.重定向到客户列表页面
			request.getRequestDispatcher("/ListBorrowServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}/*catch (MsgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/updateBorrow.jsp").forward(request, response);
			return;
		}*/

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
