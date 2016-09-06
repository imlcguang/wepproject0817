package com.imlc.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;
import com.imlc.demo.service.BorrowRecordService;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnServlet() {
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
			// 1.获取要查询的客户id
			String id = request.getParameter("id");
			// 2.调用Service中根据id查找借机表的方法
			BorrowRecordService bs = new BorrowRecordService();
			T_BorrowRecord borrow = bs.findBorrowByID(id);
			System.out.println(borrow.toString());
			// 获取数据并封装
			String ReturnOperator = request.getParameter("ReturnOperator");
			T_User returnop = bs.findUserById(ReturnOperator);
			borrow.setReturnOperator(returnop);

			 /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 borrow.setReturnDatetime(df.format(new Date()));*/
			borrow.setReturnDatetime(new Date());

			System.out.println(borrow.toString());
			// 调用service中的return方法
			bs.returnRecord(borrow);
			// 3.请求转发到list.jsp页面展示
			request.getRequestDispatcher("/ListBorrowServlet").forward(request, response);
		} catch (MsgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/returnBorrow.jsp").forward(request, response);
			return;
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
