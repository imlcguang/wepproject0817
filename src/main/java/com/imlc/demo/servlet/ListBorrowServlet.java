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

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.logback.LogbackDemo;
import com.imlc.demo.service.BorrowRecordService;
import com.imlc.demo.service.HibernateRecordService;

/**
 * Servlet implementation class ListBorrowServlet
 */
public class ListBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(LogbackDemo.class); 
		response.setContentType("text/html");
		int pageIndex = 1;
		int pageSize = 10;
		//总记录数
		int totalCount =BorrowRecordService.getInstance().countrecord();
		// 总页数
		int totalPage=totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		
		
		String strIndex = request.getParameter("pageIndex");
		if (strIndex == null) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(strIndex);// 将得到的页面数据转换成Integer保存到pageIndex中
		}

		List<T_BorrowRecord> recordResult = BorrowRecordService.getInstance().findRecord(pageIndex, pageSize);// 调用方法得到的数据封装到list
		
		request.getSession().setAttribute("pageIndex", pageIndex);// 将页面数据保存到session中
		request.getSession().setAttribute("recordResult", recordResult);// 将list保存到session中
		request.getSession().setAttribute("totalCount", totalCount);
		request.getSession().setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("/listBorrow.jsp").forward(request, response);
		log.info("执行借机列表操作");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
