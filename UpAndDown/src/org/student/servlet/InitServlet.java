package org.student.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Address;
import org.student.entity.Student;



public class InitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setSno(1);
		student.setSname("aspiring");
		
		Address address = new Address();
		address.setHomeAddress("hengyang");
		address.setSchoolAddress("zibo");

		student.setAddress(address);
		
		// 将学生放到request域中
		request.setAttribute("student", student);
		
		String[] hobbies = new String[] {"basketball","football"};
		request.setAttribute("hobbies", hobbies);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cn","中国");
		map.put("us","美国");
		request.setAttribute("map", map);
		
		request.setAttribute("my-name", "aspiring");
		
		request.getRequestDispatcher("el.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
