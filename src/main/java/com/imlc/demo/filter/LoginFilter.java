package com.imlc.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;
		HttpSession session = request.getSession();

		String noLoginPaths = config.getInitParameter("noLoginPaths");

		if(noLoginPaths!=null){
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				
				if(strArray[i]==null || "".equals(strArray[i]))continue;
				
				if(request.getRequestURI().indexOf(strArray[i])!=-1 ){
					chain.doFilter(request1, response1);
					return;
				}
			}
			
		}
		
		if (session.getAttribute("regUser") != null) {
			chain.doFilter(request1, response1);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
