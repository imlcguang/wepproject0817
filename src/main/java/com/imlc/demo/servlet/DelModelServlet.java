package com.imlc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.service.ModelService;

/**
 * Servlet implementation class DelModelServlet
 */
@WebServlet("/DelModelServlet")
public class DelModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelModelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取要查询的样机id
		String id1 = request.getParameter("id");
		//2.调用Service中根据id查找样机，删除样机信息的方法
		Integer id=Integer.parseInt(id1);
		T_Model model = ModelService.getInstance().findModelById(id);
		ModelService.getInstance().DeleteModels(model);
		//请求转发到样机列表页面
		request.getRequestDispatcher("/ListModelServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
