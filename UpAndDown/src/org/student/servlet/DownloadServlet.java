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
		// ��ȡ��Ҫ���ص��ļ���
		String fileName = request.getParameter("filename"); // form,a href, ...Server?a=b
		
		// �����ļ�����Ҫ������Ϣͷ
		response.addHeader("content-Type","application/octet-stream" );// MIME���ͣ��������ļ��������ļ���
		// response.addHeader("content-Disposition","attachment;filename="+fileName);// fileName�������ļ���׺��abc.txt
		// ���ڲ�ͬ����������в�ͬ�Ĵ���
		// ��ȡ�ͻ��˵�user-agent��Ϣ
		String agent = request.getHeader("User-Agent");
		if(agent.toLowerCase().indexOf("firefox") !=-1) {
			//ff���� �ļ�����������
			response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+   new String(  Base64.encodeBase64(fileName.getBytes("UTF-8"))  ) +"?=" );//fileName�������ļ���׺��abc.txt
			
		}else {
			//edge���� �ļ�����������
			response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")  );//fileName�������ļ���׺��abc.txt
		}
		
		
		
		// Servletͨ���ļ��ĵ�ַ�����ļ�תΪ������ ����Servlet��
		// path =  "D:\all-workspace\JavaWeb_JSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\UpAndDown\res"
		InputStream in = getServletContext().getResourceAsStream("/res/littlelion.png");
		// ͨ����������ղ��Ѿ�תΪ���������ļ� ������û�
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
