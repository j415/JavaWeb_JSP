<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<%
			pageContext.setAttribute("name", "value1");
			request.getRequestDispatcher("pageC01.jsp").forward(request, response);
		%>
		
		
		
		<%=pageContext.getAttribute("name") %>


</body>
</html>