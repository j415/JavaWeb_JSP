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
			<%-- <%
					Student student = (Student)request.getAttribute("student");
					out.print(student+"<br />");
					out.print(student.getSno()+"<br />");
					out.print(student.getSname()+"<br />");
					out.print(student.getAddress().getHomeAddress()+"<br />");
					out.print(student.getAddress().getSchoolAddress()+"<br />");
					
			%> --%>
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
			
			
			<font>--运算--</font><br />
			${3>2}、${3 gt 2}<br />
			${3>2 || 3<2}、${3>2 or 3<2}
			
			
			<font>--empty--</font><br />
			存在的值：${empty requestScope["my-name"]}<br />
			不存在的值：${empty requestScope["aspiring"]}<br />
			为null的值：${empty requestScope["nullValue"]}<br />
			
			
			<font>--session--</font><br />
			${sessionScope["sessionKey"] }<br />
			${sessionKey }<br />
				
			
			<font>--param、paramsValues:参数对象--</font><br />
			${param.uname }<br />
			${paramValues.hobbies[0] }	、	
			${paramValues.hobbies[1] }	、	
			${paramValues.hobbies[2] }	、	<br />
			
			<font>--获取Jsp隐式对象--</font><br />
			<!-- 获取方式：方法名去掉()和get并且首字母小写 -->
			${pageContext.request.serverPort }
</body>
</html>