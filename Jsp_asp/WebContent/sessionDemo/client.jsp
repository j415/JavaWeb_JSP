<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>client</title>
</head>
<body>
	欢迎您：
	<%
		String name = (String)session.getAttribute("uname");
		// 如果没有用户登陆，而是直接通过地址栏访问client.jsp，则必然能获取到的name是null
		if(name == null){
			response.sendRedirect("login.jsp");
		}else{
			out.print(name);
		}
	%>
	<a href="invalidate.jsp">注销</a>

</body>
</html>