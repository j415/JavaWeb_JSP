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
		
		// ����ҳ�����5���ֶΣ�������һ���Զ����㣬���ʵ��ֻ��Ҫ��װ4�����ɣ�����װ��page����֮��
		Page page = new Page();

		int totalCount = studentService.getTotalCount(); // ��������
		page.setTotalCount(totalCount);
		
		String cpage = request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		
		int currentPage = Integer.parseInt(cpage);
		page.setCurrentPage(currentPage);
		
		/* currentPage:��ǰҳ��ҳ�룩
		 * students:��ǰҳ�����ݼ��ϣ���ǰҳ������ѧ����
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
