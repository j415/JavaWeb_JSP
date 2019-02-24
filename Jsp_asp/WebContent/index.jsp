<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"	import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>蔣華超</title>
</head>
<body>
	<%="当前项目的虚拟路径： "+application.getContextPath()+"<br>" %>
	<%="虚拟路径对应的绝对路径： "+application.getRealPath("/Jsp_asp")+"<br>" %>
	******蔣華asp*******
	<br>
	<%		// 局部变量，定义方法
		String hobby = "read book";
		out.println("<font color=blue>hobby : </font>" + hobby);
		init();
	%>
	<br>
	<%!		// 全局变量，java语句
		public String bookName;
		public void init(){
			Date date = new Date();
			bookName="jsp学习<br>"+date;
		}
	%>
	<%="hear<br>ing="+bookName		//	输出表达式
	%>
</body>
</html>