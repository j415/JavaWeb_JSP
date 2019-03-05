<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("tr:odd").css("background-color","#ddd");
	});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			// 判断是否增加成功
			String message = (String)request.getAttribute("message");
			if(message!=null){
				if(message.equals("error")){
					out.print("増加失敗");
				}else if(message.equals("notError")){
					out.print("増加成功");
				}else{
					// 啥也不添加
				}
			}
		%>


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
		<a href="add.jsp">新規</a>

</body>
</html>