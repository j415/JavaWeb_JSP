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
			session.setAttribute("name", "value1");
			// request.getRequestDispatcher("ss01.jsp").forward(request, response);
			response.sendRedirect("ss01.jsp");
		%>
		
		
</body>
</html>