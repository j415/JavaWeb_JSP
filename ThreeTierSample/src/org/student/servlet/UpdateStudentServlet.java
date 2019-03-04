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
		// 获取待修改的学生的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		// 获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		// 将修改后的内容分装到一个实体类中
		Student student = new Student(name,age,address);
		StudentService studentservice = new StudentService();
		boolean result = studentservice.updateStudentBySno(no, student);
		// 设置回复信息的编码格式
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		if(result) {
			out.print("修改成功");
		}else {
			out.print("修改失败");
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
