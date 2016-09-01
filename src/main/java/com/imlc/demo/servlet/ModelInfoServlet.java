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
 * Servlet implementation class ModelInfoServlet
 */
@WebServlet("/ModelInfoServlet")
public class ModelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModelInfoServlet() {
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
				//2.调用Service中根据id查找样机的方法
				ModelService ms = new ModelService();
				Integer id=Integer.parseInt(id1);
				T_Model model = ms.findModelById(id);
				if (model == null) {
					request.setAttribute("msg", "找不到该样机!");
					request.getRequestDispatcher("/listModel.jsp").forward(request, response);
					return;
				}
				System.out.println(model.toString());
				//3.将查找到的样机信息存入request域中,请求转发到updateCust.jsp页面展示
				request.setAttribute("model", model);
				request.getRequestDispatcher("/updateModel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}