package org.lang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/WelcomeServlet",loadOnStartup=1,initParams= {@WebInitParam(name="servletparamname30",value="servletparamvalue30")})
public class WelcomeServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init30...");
		String servlet = super.getInitParameter("servletparamname30");
		System.out.println("当前servlet初始化参数servletparamname30的值："+servlet);
	}
	@Override
	public void destroy() {
		System.out.println("destroy3.0.....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet30...doGet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet30...doPost");
	}

}
