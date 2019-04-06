<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- 引用公共bootstrap和jQuery文件 -->
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
	
	<!-- 引用内部文件 -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">

<script>
	$(document).ready(function(){
		$("#selector").change(function(){
			var val = $("#selector").val();
			if(val=="user"){
				$("#form-reg").css("display","block");
			}else{
				$("#form-reg").css("display","none");
			}
		})

		$("#log").click(function(){			
			
		});
		

	});
	
</script>

<meta charset="UTF-8">
<title>就诊系统|登录</title>
</head>
<body>
<div class="form-log" >
	<form action=LoginServlet method="post">
		 <div class="form-group">
		    <label for="exampleInputEmail1">用户名</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="name" name="name">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">密码</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"  name="pwd">
		  </div>
		<select id="selector" class="btn btn-default selector"  name="selector">
		  <option value ="user">用户</option>
		  <option value ="doctor">医生</option>
		  <option value="admin">管理员</option>
		</select>
		<!-- <a id="reg" class="btn btn-default reg" href="register.jsp" role="button">注册</a> -->
		<button id="log"  class="btn btn-default log " value="登录">登录</button>
		
	</form>
	<br>
	<font color="red">
		<%
			if(request.getAttribute("message") != null){
				out.print(request.getAttribute("message"));
			}
		%>
	</font>
	<form id="form-reg"  action=LoginServlet method="post">
		<a id="reg" class="btn btn-default reg" href="register.jsp" role="button">注册</a>
	</form>
</div>
	
</body>

</html>