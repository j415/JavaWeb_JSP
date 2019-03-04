package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;


public class QueryAllStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");


		
		StudentService studentservice = new StudentService();
		List<Student> students = studentservice.queryAllStudents();
		System.out.println(students);
		
		request.setAttribute("students", students);
		// ��Ϊrequest�������ݣ����Ҫ��Ҫ����ת���ķ�ʽ��ת(�ض���ᶪʧrequest�е�����)
		//pageContext<request<session<application
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
