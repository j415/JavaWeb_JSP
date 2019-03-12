<%@page import="org.student.entity.Student"%>
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
					Student student = (Student)request.getAttribute("student");
					out.print(student+"<br />");
					out.print(student.getSno()+"<br />");
					out.print(student.getSname()+"<br />");
					out.print(student.getAddress().getHomeAddress()+"<br />");
					out.print(student.getAddress().getSchoolAddress()+"<br />");
					
			%>
			<hr />
			<font>--点操作符--</font><br />
			${requestScope.student}<br>
			${requestScope.student.sno}<br>
			${requestScope.student.sname}<br>
			${requestScope.student.address}<br>
			${requestScope.student.address.homeAddress}<br>
			${requestScope.student.address.schoolAddress}<br>
			
			<font>--中括号操作符--</font><br />
			${requestScope.student["sno"]}<br>
			${requestScope.student['sname']}<br>
			
			<font>--特殊符号--</font><br />
			<font>点操作符：</font>${requestScope.my-name}<br>
			<font>中括号操作符：</font>${requestScope["my-name"]}<br>
			
			
			<font>----数组---</font><br />
			<font>中括号操作符：</font>
			${requestScope.hobbies[0]}、
			${requestScope.hobbies[1]}<br>
			
			<!-- 优点
			点操作符：方便
			中括号操作符：功能强大
			1.可以容纳一些特殊符号（?.-）
			2.可以容纳变量属性(可以动态赋值)
			3.可以处理数组 -->
			
			<font>--Map--</font><br />
			${requestScope.map.cn}<br>
			${requestScope.map["us"]}<br>
			
			
			
			
			
</body>
</html>