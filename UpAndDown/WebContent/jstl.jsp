<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
	<%-- <%
		request.setAttribute("name","aspire");
	%>
	== --%>
	<c:set var="name" value="aspiring" scope="request" />
	${requestScope.name }
	<font>---给普通对象的属性赋值---</font><br>
	赋值前：${requestScope.student.sname }<br>
	
	<c:set target="${requestScope.student }" property="sname" value="aspir" />
	赋值后：${requestScope.student.sname }<br>
	
	
	
	<font>---给MAP对象的属性赋值---</font><br>
	赋值前：${requestScope.map.cn }<br>
	
	<c:set target="${requestScope.map }" property="cn" value="China" />
	赋值后：${requestScope.map.cn }<br>
	
	
	<font>---给不存在的变量赋值---</font><br>
	<c:set var="id" value="151112020-xx" scope="request" />
	${requestScope.id }<br>
	
	<font>---给不存在的属性赋值---</font><br>
	<%-- <c:set target="${requestScope.sid }" property="id" value="151112020-xx" /> --%>
	<font>:报错！！！表示不能给不存在的属性赋值</font><br>
	
	
	<font>---c:out---</font><br>
	传统的El：${requestScope.student }<br>
	c:out方式：<c:out  value="${requestScope.student }" /><br>
	c:out显示不存在的数据：<c:out  value="${requestScope.stu }" default="aiwen" /><br>

	普通超链接：<a href="https://www.baidu.com">baidu</a><br>
	true：<c:out value='<a href="https://www.baidu.com">baidu</a>' escapeXml="true" /><br>
	false：<c:out value='<a href="https://www.baidu.com">baidu</a>' escapeXml="false" /><br>
	
	<font>---c:remove---</font><br>
	<c:set var="a" value="A" scope="request" />
	删除前显示：${a }<br>
	<c:remove var="a" scope="request" />
	删除后显示：${a }<br>
	
	
	
</body>
</html>