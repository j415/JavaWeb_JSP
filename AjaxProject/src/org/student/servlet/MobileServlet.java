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
		// 假设数据库中只有一个号码：17812345678
		
		// 输入输出流
		PrintWriter out = response.getWriter();
		if ("17812345678".equals(mobile)) {
			out.write("true");		// servlet以输出流的方式将 信息返回给客户端
			// out.write("此号码已存在，请替换");
			// 如果客户端是getJSON(),则需要以json格式返回数据
			out.write("{\"msg\":\"true\"}"); // "msg":"true"
		}else {
			out.write("false");
//			out.write("注册成功");
			out.write("{\"msg\":\"false\"}"); // "msg":"false"
		}
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
