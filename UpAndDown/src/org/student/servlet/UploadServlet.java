package org.student.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		// 上传
		try {
			boolean isMultipart=  ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {
				// FileItemFactory factory = new DiskFileItemFactory();
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				
				// 注意：对文件的限制写在parseRequest之前
				// 设置上传单个文件的大小：DiskFileItemFactory
				factory.setSizeThreshold(10240); // 设置临时的缓冲文件大小为10k
				factory.setRepository(new File("D:\\all-workspace\\JavaWeb_JSP\\UpAndDown\\WebContent\\uploadtemp"));// 设置临时文件的目录
				// 控制上传单个文件的大小 200kb ：ServletFileUpload
				upload.setSizeMax(1024*200); // 以字节B为单位
				Thread.sleep(3000);// 暂停3秒
				
				
				// 通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前端传递的sno sname spicture此时就保存在了items中）
				List<FileItem> items = upload.parseRequest(request);
				// 遍历items中的数据（sno sname spicture）
				Iterator<FileItem> iter =  items.iterator();
				while(iter.hasNext()) {
					FileItem item =  iter.next();
					String itemName = item.getFieldName();
					int sno = -1;
					String sname = null;
					
					// 判断前端字段 是普通form表单字段，还是文件字段
					// 根据name属性 判断item是sno sname 还是spictrue
					if(item.isFormField()) {
						if(itemName.equals("sno")) {
							sno = Integer.parseInt(item.getString("utf-8"));
						}else if(itemName.equals("sname")){
							sname = item.getString("utf-8");
						}else {
							System.out.println("其他字段");
						}
					}else {// spicture
						// 文件上传
						// 文件名 getFieldName是获取普通表单字段的Name值
						// getname()是获取文件名
						String fileName =  item.getName();
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png") || ext.equals("jpg") || ext.equals("gif"))) {
							System.out.println("图片类型有误！格式只能是png、jpg、gif");
							return;
						}
						
						// 获取文件内容 并上传
						// 定义文件路径：指定上传的位置(服务器路径)
						String path = "D:\\all-workspace\\JavaWeb_JSP\\UpAndDown\\WebContent\\upload";
						// 设置动态路径
						// String path = request.getSession().getServletContext().getRealPath("upload");
						File file = new File(path,fileName);
						
						
						
						item.write(file);// 上传
						System.out.println(fileName+"上传成功");
						return ;
						
						
					}
					
					
					
					
					
				}
				
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			System.out.println("上传文件大小超过限制，最大200kb");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
