<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>


	<%-- <form action="server" method="post">
		用户名:<input type="text" name="uname"  value="<%=(uname==null?"":uname)%>"><br/>
		
		
		密码:<input type="password" name="upwd"><br/>
		<input type="submit" value="登陆"><br/>
		
	</form> --%>

	<form action="server.jsp"  method="post">
		ユーザー:<input type="text" name="uname" ><br/>
		パスワード:<input type="password" name="upwd"><br/>
		<input type="submit" name="uname" value="登録"><br/>
		
	</form>

</body>
</html>