package org.lang.servelt;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init...");
		// 获取当前servlet的初始化参数
		String value = super.getInitParameter("servletparamname");
		System.out.println("当前Servlet的参数servletParamname的值是："+value);
		
		// 获取当前Web的初始化参数
		ServletContext servletContext = super.getServletContext();
		String globalvalue = servletContext.getInitParameter("globalParam");
		System.out.println("当前Web的参数globalvalue的值是："+globalvalue);
	}
	@Override
	public void destroy() {
		System.out.println("destroy...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet....");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("doPost....");
		this.doGet(req, resp);
	}

}
