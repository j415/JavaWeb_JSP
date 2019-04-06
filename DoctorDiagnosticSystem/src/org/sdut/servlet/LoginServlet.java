package org.sdut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sdut.dao.LoginDao;
import org.sdut.entity.Login;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String selectes = request.getParameter("selector");
		Login login = new Login(name,pwd);
		
		int result = LoginDao.login(login, selectes);
		
		if (result>0) {
			if(selectes.equals("admin")) {
				request.getRequestDispatcher("welcomeadmin.jsp").forward(request, response);
			}else if(selectes.equals("doctor")) {
				request.getRequestDispatcher("welcomedoctor.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("welcomeuser.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("message", "ÕËÃÜ»òÕßÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼£¡<br>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
