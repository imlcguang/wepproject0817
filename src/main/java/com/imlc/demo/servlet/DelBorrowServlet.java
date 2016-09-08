package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.service.BorrowRecordService;


/**
 * Servlet implementation class DelBorrowServlet
 */
@WebServlet("/DelBorrowServlet")
public class DelBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelBorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取要查询的id
		String id = request.getParameter("id");
		// 2.调用Service中根据id查找的方法
		T_BorrowRecord borrow=BorrowRecordService.getInstance().findBorrowByID(id);
		BorrowRecordService.getInstance().deleteBorrowRecord(borrow);
		//3.请求转发到列表页面
		request.getRequestDispatcher("/ListBorrowServlet").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
