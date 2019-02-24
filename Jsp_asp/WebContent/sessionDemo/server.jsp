<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>server</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		if(name.equals("asp") && pwd.equals("asp")){// 假设 name:asp pwd:asp
			// 只有登陆成功，session中才会存在uname/upwd
			session.setAttribute("uname", name);
			session.setAttribute("upwd", pwd);
			
			System.out.println("sessionId : " + session.getId());
			
			// Cookie cookie = new Cookie("uname",name);
			// response.addCookie(cookie);
			// 服务器在第一次相应客户端时，会发送一个JSESSIONID的cookie
			// session.setMaxInactiveInterval(10);
			
			request.getRequestDispatcher("client.jsp").forward(request,response);
			
		}else{
			response.sendRedirect("login.jsp");
		}

	%>

</body>
</html>