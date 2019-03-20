<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	// function register() {		// post方式
	function registerGet() {		// get 方式
		var mobile = document.getElementById("mobile").value;
		// 通过Ajax方式请求服务端
		xmlHttpRequest = new XMLHttpRequest();
		
		// xmlHttpRequest对象的回调函数
		xmlHttpRequest.onreadystatechange = callBack ;

		// xmlHttpRequest.open("post","MobileServlet",true);				// post方式
		xmlHttpRequest.open("post","MobileServlet?mobile="+mobile,true);	// get方式
		
		// 设置post的头信息
		// xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		// get不需要头信息
		// xmlHttpRequest.send("mobile="+mobile); // post方式
		xmlHttpRequest.send(null);				  // get方式
	
	// 定义回调函数（接受服务器的返回值）
	function callBack() {
		if(xmlHttpRequest.readyState == 4 & xmlHttpRequest.status == 200){
			// 接收服务端返回的数据
			var data = xmlHttpRequest.responseText; // 服务端返回值为string类型
			if(data == "true"){
				alert("此号码已存在，请更换");
			}else{
				alert("注册成功！");
			}
		}
	}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="">
				手机：<input id="mobile" type="text">
				<!-- <button onclick="register()" >注册</button> -->		<!-- post 方式 -->
				<button onclick="registerGet()" >注册</button>		<!-- get 方式 -->
					
			</form>

</body>
</html>