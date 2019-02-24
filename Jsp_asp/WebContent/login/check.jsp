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
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		if(name.equals("asp") && pwd.equals("asp")){
			// 页面跳转：重定向，导致数据丢失
			// response.sendRedirect("success.jsp");
			// 页面跳转：请求转发，可以收到数据，并且地址栏没有改变（任然保留转发时的页面）
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			//登陆失败
			out.print("用户名或者密码有误!");
		}
	%>

</body>
</html>