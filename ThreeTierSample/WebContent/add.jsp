<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check() {// onsubmit: return true:表单正常提交  return false:表单终止提交
		var sno = $("#sno").val();
		var sname = $("#sname").val();
		var sage = $("#sage").val();
		var saddress = $("#saddress").val();
	
		
		
		if(!(sno>0 && sno <101)){
			alert("学号有误！必须是1-100")
			return false ;
		}
		
		if(sname.length<1 && sname.length>5){
			alert("学生姓名长度在2~5之间");
			return false;
		}
		if(sage<=0 && sage=>200){
			alert("学生年龄在1~199之间");
			return false;
		}
		if(saddress.length<=0 && saddress.length>=9){
			alert("学生地址长度在1~9之间");
			return false;
		}
		
		return true;
	};


	$(document).ready(function(){
	});
</script>
<meta charset="UTF-8">
<title>add</title>
</head>
<body>
	<form action="AddStudentServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno" /></br>
		姓名：<input type="text" name="sname" id="sname" /></br>
		年龄：<input type="text" name="sage" id="sage" /></br>
		地址：<input type="text" name="saddress" id="saddress" /></br>
		<input type="submit" value="新た" >
	</form>

</body>
</html>