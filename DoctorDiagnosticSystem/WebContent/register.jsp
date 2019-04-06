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
    <link rel="stylesheet" href="css/register.css">
    
<script type="text/javascript">
	function func(event){  
		var name = $("input[name='name']").val();
		var pwd = $("input[name='pwd']").val();
		var confirmpwd = $("input[name='confirmpwd']").val();
		

		if(name==""){	/* 没有输入用户名 */
			event.preventDefault();
			$("#emptyname").css("display","block");
		}else{
			if(pwd==""){	/* 没有输入密码 */
				event.preventDefault();
				$("#emptypwd").css("display","block");
			}else{

				if(pwd!=confirmpwd ){	/* 前后两次输入的密码不一致 */
					event.preventDefault();
					$("#confirmfalse").css("display","block");
				}
			}
		}
	}
</script>
<meta charset="UTF-8">
<title>医生就诊|注册</title>
</head>
<body>
<div class="form-log" >
	<form id="form-reg" action=RegisterServlet method="post">
		<div class="form-group">
			    <label for="exampleInputEmail1">用户名</label>
			    <input type="text" class="form-control" id="exampleInputEmail1 uesr" placeholder="Name" name="name">
			    <p id="emptyname" class="emptyname">* 用户名不能为空</p>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1 pwd" placeholder="Password"  name="pwd">
			    <p id="emptypwd" class="emptypwd">* 密码不能为空</p>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">确认密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1 confirmpwd" placeholder="ConfirmPassword"  name="confirmpwd">
			    <p id="confirmfalse" class="confirmfalse">* 两次输入的密码不一致</p>
		</div>
		<!-- <button id="reg" class="btn btn-default reg" value="注册">注册</button> -->  
		<input id="reg" class="btn btn-default reg" value="注册" type="submit"  onclick="func(event)" />		
	</form>
</div>
</body>
</html>