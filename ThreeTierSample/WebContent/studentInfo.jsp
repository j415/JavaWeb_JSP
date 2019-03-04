<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentInfo</title>
</head>
<body>
		<%
			Student student =  (Student)request.getAttribute("student");
		%>
		<!-- 通过表单展示此人信息 -->
		<form action="">
			学号：<input type="text" value="<%=student.getSno() %>" ></br>
			姓名：<input type="text" value="<%=student.getSname() %>" ></br>
			年龄：<input type="text" value="<%=student.getSage() %>" ></br>
			地址：<input type="text" value="<%=student.getSaddress() %>" ></br>
		</form>

</body>
</html>