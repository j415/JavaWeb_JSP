<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aspiring_show</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");	// 设置post编码
		String name = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("uage"));
		String pwd = request.getParameter("upwd");
		
		String[] hobbies = request.getParameterValues("uhobbies");
	%>
	
	注册成功，信息如下：</br>
	ユーザー名:<%=name %></br>
	年齢:<%=age %></br>
	パスワード:<%=pwd %></br>
	趣味:</br>
	<%-- <%
			if(hobbies !=null){
			for(String hobby :hobbies)
			{
				out.print(hobby +"&nbsp;");
			}
			}
		%> --%>
	<%
		if(hobbies != null ){
			for(int i=0;i<hobbies.length;i++){
				out.print(hobbies[i]+"&nbsp;");
			}
		}
		
	%>
	

</body>
</html>