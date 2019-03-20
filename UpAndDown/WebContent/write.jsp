<%@page import="org.student.listener.BeanListener2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
		<%
			BeanListener2 bean2 = new BeanListener2();
			bean2.setNum(1);
			bean2.setUser("aspiring");
			session.setAttribute("bean2", bean2);
		%>
</body>
</html>