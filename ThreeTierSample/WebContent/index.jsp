<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<%
				// 获取request中的数据
				List<Student> students = (List<Student>)request.getAttribute("students");
				for(Student student:students){
			%>
					<tr>
						<td><a href="QueryStudentBySno?sno=<%=student.getSno() %>"><%=student.getSno() %></td>
						
						
						<td><%=student.getSname() %></td>
						<td><%=student.getSage() %></td>
						<td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</td>
					</tr>
			<%
				}
			%>
				
		</table>

</body>
</html>