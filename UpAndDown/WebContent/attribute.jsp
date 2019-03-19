<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attribute</title>
</head>
<body>
		<%
				application.setAttribute("name", "aspire"); // 增加
				application.setAttribute("name", "aspiring"); // 替换
				application.removeAttribute("name"); // 删除
				
				session.setAttribute("school", "sdut"); // 增加
				session.setAttribute("school", "shlg"); // 替换
				session.removeAttribute("school"); // 删除
				
				request.setAttribute("company", "nec"); // 增加
				request.setAttribute("company", "necsoft"); // 替换
				request.removeAttribute("company"); // 删除
				
		%>
</body>
</html>