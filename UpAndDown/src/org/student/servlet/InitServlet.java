package org.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		request.setAttribute("nullValue", null);
		
		String[] strs = new String[] {"aaa","bb","c"};
		request.setAttribute("strs", strs);
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		stu1.setSname("aspire");
		stu1.setSno(1);
		stu2.setSno(2);
		stu2.setSname("aspiring");
		List<Student> stus = new ArrayList<>();
		
		stus.add(stu1);
		stus.add(stu2);
		request.setAttribute("stus", stus);
		
		request.getSession().setAttribute("sessionKey", "sessionValue");

		// request.getRequestDispatcher("el.jsp").forward(request, response);
		// request.getRequestDispatcher("jstl.jsp").forward(request, response);
		request.getRequestDispatcher("jstl2.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
