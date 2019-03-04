package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;


public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// ��ȡ���޸ĵ�ѧ����ѧ��
		int no = Integer.parseInt(request.getParameter("sno"));
		// ��ȡ�޸ĺ������
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		// ���޸ĺ�����ݷ�װ��һ��ʵ������
		Student student = new Student(name,age,address);
		StudentService studentservice = new StudentService();
		boolean result = studentservice.updateStudentBySno(no, student);
		// ���ûظ���Ϣ�ı����ʽ
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		if(result) {
			out.print("�޸ĳɹ�");
		}else {
			out.print("�޸�ʧ��");
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
