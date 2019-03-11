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
		// �ϴ�
		try {
			boolean isMultipart=  ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {
				// FileItemFactory factory = new DiskFileItemFactory();
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				
				// ע�⣺���ļ�������д��parseRequest֮ǰ
				// �����ϴ������ļ��Ĵ�С��DiskFileItemFactory
				factory.setSizeThreshold(10240); // ������ʱ�Ļ����ļ���СΪ10k
				factory.setRepository(new File("D:\\all-workspace\\JavaWeb_JSP\\UpAndDown\\WebContent\\uploadtemp"));// ������ʱ�ļ���Ŀ¼
				// �����ϴ������ļ��Ĵ�С 200kb ��ServletFileUpload
				upload.setSizeMax(1024*200); // ���ֽ�BΪ��λ
				Thread.sleep(3000);// ��ͣ3��
				
				
				// ͨ��parseRequest����form�е����������ֶΣ������浽items�����У���ǰ�˴��ݵ�sno sname spicture��ʱ�ͱ�������items�У�
				List<FileItem> items = upload.parseRequest(request);
				// ����items�е����ݣ�sno sname spicture��
				Iterator<FileItem> iter =  items.iterator();
				while(iter.hasNext()) {
					FileItem item =  iter.next();
					String itemName = item.getFieldName();
					int sno = -1;
					String sname = null;
					
					// �ж�ǰ���ֶ� ����ͨform���ֶΣ������ļ��ֶ�
					// ����name���� �ж�item��sno sname ����spictrue
					if(item.isFormField()) {
						if(itemName.equals("sno")) {
							sno = Integer.parseInt(item.getString("utf-8"));
						}else if(itemName.equals("sname")){
							sname = item.getString("utf-8");
						}else {
							System.out.println("�����ֶ�");
						}
					}else {// spicture
						// �ļ��ϴ�
						// �ļ��� getFieldName�ǻ�ȡ��ͨ���ֶε�Nameֵ
						// getname()�ǻ�ȡ�ļ���
						String fileName =  item.getName();
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png") || ext.equals("jpg") || ext.equals("gif"))) {
							System.out.println("ͼƬ�������󣡸�ʽֻ����png��jpg��gif");
							return;
						}
						
						// ��ȡ�ļ����� ���ϴ�
						// �����ļ�·����ָ���ϴ���λ��(������·��)
						String path = "D:\\all-workspace\\JavaWeb_JSP\\UpAndDown\\WebContent\\upload";
						// ���ö�̬·��
						// String path = request.getSession().getServletContext().getRealPath("upload");
						File file = new File(path,fileName);
						
						
						
						item.write(file);// �ϴ�
						System.out.println(fileName+"�ϴ��ɹ�");
						return ;
						
						
					}
					
					
					
					
					
				}
				
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {
			// TODO Auto-generated catch block
			System.out.println("�ϴ��ļ���С�������ƣ����200kb");
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
