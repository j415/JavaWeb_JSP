package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentService;


public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 删除
		request.setCharacterEncoding("utf-8");
		// 接受前端传来的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		
		
		StudentService studentservice = new StudentService();
		boolean result =  studentservice.deleteStudent(no);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		if(result) {
			out.print("删除成功");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("删除失败");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
