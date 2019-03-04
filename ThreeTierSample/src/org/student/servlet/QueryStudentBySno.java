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
		
		// ��ȡ����ѧ����ѧ��
		int no = Integer.parseInt(request.getParameter("sno"));
		
		StudentService studentservice = new StudentService();
		Student student = studentservice.queryStudentBySno(no);

		request.setAttribute("student", student);
		// ��Ϊrequest�������ݣ����Ҫ��Ҫ����ת���ķ�ʽ��ת(�ض���ᶪʧrequest�е�����)
		//pageContext<request<session<application
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
		// ���ûظ���Ϣ�ı����ʽ
		
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
