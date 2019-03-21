package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MobileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String mobile = request.getParameter("mobile");
		// �������ݿ���ֻ��һ�����룺17812345678
		
		// ���������
		PrintWriter out = response.getWriter();
		if ("17812345678".equals(mobile)) {
			out.write("true");		// servlet��������ķ�ʽ�� ��Ϣ���ظ��ͻ���
			// out.write("�˺����Ѵ��ڣ����滻");
			// ����ͻ�����getJSON(),����Ҫ��json��ʽ��������
			out.write("{\"msg\":\"true\"}"); // "msg":"true"
		}else {
			out.write("false");
//			out.write("ע��ɹ�");
			out.write("{\"msg\":\"false\"}"); // "msg":"false"
		}
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}