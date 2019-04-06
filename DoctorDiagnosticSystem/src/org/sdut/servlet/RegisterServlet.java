package org.sdut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sdut.entity.Register;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String confirmpwd = request.getParameter("confirmpwd");
		System.out.println(name+pwd+confirmpwd);
		
		Register register =new Register(name, pwd);
		
		
		// …Ë÷√œÏ”¶±‡¬Î
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
