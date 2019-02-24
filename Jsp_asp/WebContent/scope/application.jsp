<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			application.setAttribute("name", "value1");
			request.getRequestDispatcher("ap01.jsp").forward(request, response);
		%>
		
</body>
</html>