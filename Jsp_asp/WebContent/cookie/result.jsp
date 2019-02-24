<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
		<%
			/* Cookie[] cookies = request.getCookies();
		
			for(Cookie cookie:cookies){
				out.print(cookie.getName()+" : "+cookie.getValue()+"<br>");
				
			} */
			Cookie[] cookies =  request.getCookies();
			for(Cookie cookie:cookies){
				out.print(cookie.getName()+"--"+cookie.getValue() +"<br/>");
			}
		%>
</body>
</html>