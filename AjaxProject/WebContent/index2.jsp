<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	function register() {
		var $mobile = $("#mobile").val();
		/* $.ajax({
			url:"MobileServlet",
			method:"post",
			data:"mobile="+$mobile,
			success:function(result,testStatus){
				if(result == "true"){
					alert("此号码已存在，请更换");
				}else{
					alert("注册成功！");
				}
			},
			error:function(xhr,errorMessage,e){
				alert("系统异常")
			}
		}) */
		
		/* $.post(
				"MobileServlet",
				"mobile="+$mobile,
				function(result,testStatus){
					if(result == "true"){
						alert("此号码已存在，请更换");
					}else{
						alert("注册成功！");
					}
				},
				)
				 */
				
		/* $.get(
				"MobileServlet",
				"mobile="+$mobile,
				function(result,testStatus){
					if(result == "true"){
						alert("此号码已存在，请更换");
					}else{
						alert("注册成功！");
					}
				},
				"text"		// text json xml
				)
				*/
				
		/* $("#tip").load(
				"MobileServlet",
				"mobile="+$mobile,
				
				); */
		/* var student = {"name":"aspire" , "age":18};
		alert(student.name+":"+student.age);
		
		var students = [
			{"name":"aspire" , "age":18},
			{"name":"a" , "age":11},
			{"name":"as" , "age":12},
			{"name":"asp" , "age":13},
		];
		alert(students[1].name+":"+students[1].age)
		 */
		 /* $.getJSON(
				"MobileServlet",
				{"mobile":$mobile},
				function(result){
					if(result.msg == "true"){
						alert("此号码已存在，请更换");
					}else{
						alert("注册成功！");
					}
				}
			); */
		$.getJSON(
				"MobileServlet",
			//	"mobile="+$mobile,
				{"mobile":$mobile},
			function (result){//msg:true|false
					alert(123);
					if(result.msg == "true"){
						alert("已存在！注册失败！");
					}else{
						alert("注册成功！");
					}
			}

		);
		 
	}
	/* json中只有一个对象的情况
	function testJson() {
		$.getJSON(
				"JsonServlet",
				{"name":"aspire001","age":18.0},
			function (result){ //js需要通过eval()函数 将返回值转为一个js能够识别的json对象
					var jsonStudent =  eval(result.stu1);
					alert(jsonStudent.name+":"+jsonStudent.age);
			
					
			}

		);
	} */
	
	/* json中有多个对象的情况*/
	function testJson() {
		$.getJSON(
				"JsonServlet",
				{"name":"aspire001","age":18.0},
			function (result){ 
					// result: {"stu1":stu1"， stu2":stu2", stu3",stu3}
					var jsonStudents =  eval(result);
					$.each(jsonStudents, function(i,element){
						alert(this.name +":"+this.age);
					})
			
					
			}

		);
	} 
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="">
				手机：<input id="mobile" type="text">
				<button onclick="register()" >注册</button>	<!-- post 方式 -->
				<span id="tip"></span>
				<button onclick="testJson()" >testJson</button>	
			</form>

</body>
</html>