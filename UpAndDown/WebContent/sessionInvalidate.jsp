<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session销毁页面</title>
</head>
<body>
		<%
				System.out.println("===session销毁页面sessionInvalidate.jsp===");
				session.invalidate();
		%>
</body>
</html>