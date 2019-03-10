package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class QueryStudentByPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService  = new StudentServiceImpl();
		
		// 将分页所需的5个字段（其中有一个自动计算，因此实际只需要组装4个即可），组装到page对象之中
		Page page = new Page();

		int totalCount = studentService.getTotalCount(); // 数据总数
		page.setTotalCount(totalCount);
		
		String cpage = request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		
		int currentPage = Integer.parseInt(cpage);
		page.setCurrentPage(currentPage);
		
		/* currentPage:当前页（页码）
		 * students:当前页的数据集合（当前页的所有学生）
		 */
		
		int pageSize = 3;
		page.setPageSize(pageSize);
		
		List<Student> students =  studentService.queryStudentsByPage(currentPage, pageSize);
		System.out.println(page);
		System.out.println(totalCount);
		
		
		
		page.setStudents(students);
		request.setAttribute("p", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
