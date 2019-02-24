<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response_addCookie</title>
</head>
<body>
		<%
			// 服务端
			Cookie cookie1 = new Cookie("name","asp");
			Cookie cookie2 = new Cookie("pwd","asp");
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			//页面跳转到客户端（重定向、转发）
			response.sendRedirect("result.jsp");
		%>

</body>
</html>