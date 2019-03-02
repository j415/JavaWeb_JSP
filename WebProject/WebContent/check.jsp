<%@page import="org.lang.entity.Login"%>
<%@page import="org.lang.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			String name = request.getParameter("unname");
			String pwd = request.getParameter("upwd");
			Login login= new Login(name, pwd);
			
			LoginDao dao = new LoginDao();
			
			int result = dao.login(login);
			if(result > 0){
				out.print("登陆成功");
			}else if(result==0){
				out.print("用户名或者密码错误");
			}else{
				out.print("系统异常");
			}
			System.out.print("B");

		
		%>

</body>
</html>