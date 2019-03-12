package org.student.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

public class DownloadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取需要下载的文件名
		String fileName = request.getParameter("filename"); // form,a href, ...Server?a=b
		
		// 下载文件：需要设置消息头
		response.addHeader("content-Type","application/octet-stream" );// MIME类型：二进制文件（任意文件）
		// response.addHeader("content-Disposition","attachment;filename="+fileName);// fileName包含了文件后缀：abc.txt
		// 对于不同浏览器，进行不同的处理
		// 获取客户端的user-agent信息
		String agent = request.getHeader("User-Agent");
		if(agent.toLowerCase().indexOf("firefox") !=-1) {
			//ff下载 文件名乱码问题
			response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+   new String(  Base64.encodeBase64(fileName.getBytes("UTF-8"))  ) +"?=" );//fileName包含了文件后缀：abc.txt
			
		}else {
			//edge下载 文件名乱码问题
			response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")  );//fileName包含了文件后缀：abc.txt
		}
		
		
		
		// Servlet通过文件的地址，将文件转为输入流 读到Servlet中
		// path =  "D:\all-workspace\JavaWeb_JSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\UpAndDown\res"
		InputStream in = getServletContext().getResourceAsStream("/res/littlelion.png");
		// 通过输出流将刚才已经转为输入流的文件 输出给用户
		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[10];
		int len = -1;
		while(  (len=in.read(bs)) != -1) {
			out.write(bs,0,len);
		}
		out.close();
		in.close();
		

		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
