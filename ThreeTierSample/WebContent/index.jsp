<%@page import="org.student.entity.Page"%>
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
				Page p = (Page)request.getAttribute("p");
				for(Student student:p.getStudents()){
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
		<%
			if(p.getCurrentPage()==1){
		 %>		
		 		<a href="QueryStudentByPage?currenntPage=<%=p.getCurrentPage()+1 %>">下一页</a>
				<a href="QueryStudentByPage?currenntPage=<%=p.getTotalPage() %>">尾页</a>
		 		
		<%		
			}else if(p.getCurrentPage()==p.getTotalPage()){
		 %>
				<a href="QueryStudentByPage?currenntPage=1">首页</a>
				<a href="QueryStudentByPage?currenntPage=<%=p.getCurrentPage()-1 %>">上一页</a>
		<% 
			}else{
		 %>	
				<a href="QueryStudentByPage?currenntPage=1">首页</a>
				<a href="QueryStudentByPage?currenntPage=<%=p.getCurrentPage()-1 %>">上一页</a>
				<a href="QueryStudentByPage?currenntPage=<%=p.getCurrentPage()+1 %>">下一页</a>
				<a href="QueryStudentByPage?currenntPage=<%=p.getTotalPage() %>">尾页</a>
		<%	
			}
		 %>
		 
		 
		 <br>
		 每页显示
		 <select>
		 	<option name="" value="3" >3</option>
		 	<option value="5" >5</option>
		 	<option value="110" >101</option>
		 </select>
		 条
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

</body>
</html>