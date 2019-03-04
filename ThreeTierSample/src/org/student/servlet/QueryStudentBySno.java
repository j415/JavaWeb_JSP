package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;


public class QueryStudentBySno extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 获取查找学生的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		
		StudentService studentservice = new StudentService();
		Student student = studentservice.queryStudentBySno(no);

		request.setAttribute("student", student);
		// 因为request中有数据，因此要需要请求转发的方式跳转(重定向会丢失request中的数据)
		//pageContext<request<session<application
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
		// 设置回复信息的编码格式
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(student.getSname()+"<br>");
		out.print(student.getSaddress()+"<br>");
		out.print(student.getSaddress()+"<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
