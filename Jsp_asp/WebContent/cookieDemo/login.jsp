<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<%!
		String uname;
	%>
	<%
		/* boolean flag = false;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie :cookies){
			if(cookie.getName().equals("uname")){
				uname = cookie.getValue();
				flag = true;
			}
		} */
		boolean flag = false ;
		Cookie[] cookies = request.getCookies() ;
		for(Cookie cookie :cookies){
			if(cookie.getName().equals("uname")){
				uname = cookie.getValue() ;
				flag = true ; 
				
			}
		}
		/* if(!flag){
			out.print("cookie已失效！");
		}else{
			out.print("cookie:"+uname);
		} */
		if(!flag){//if(flag !==true)
			out.print("cookie已失效1！");
		}else{
			out.print("cookie:"+uname);
		}
	%>


	<form action="server.jsp"  method="post">
		ユーザー:<input type="text" name="uname" value="<%=(uname==null? "":uname)%>"><br/>
		パスワード:<input type="password" name="upwd"><br/>
		<input type="submit" name="uname" value="登録"><br/>
		
	</form>

</body>
</html>