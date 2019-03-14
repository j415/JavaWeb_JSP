<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl2</title>
</head>
<body>
		<c:if test="${10>2}" var="result" scope="request">
			zhen!
			${result }
		
		</c:if>
		<br />
		
		<c:set var="role" value="student" scope="request"></c:set>
		answer:${requestScope.role }
		<br>
		<c:choose>
			<c:when test="${requestScope.role=='teacher' }">
					teacher is code...
			</c:when>
			<c:when test="${requestScope.role == 'student' }">
					student is code...
			</c:when>
			<c:otherwise>
					admmin is code...
			</c:otherwise>
		</c:choose>
		<br>
		<c:forEach begin="0" end="5" step="1" varStatus="status">
				${status.index }:test->
		</c:forEach>
		<br>
		
		<c:forEach var="str" items="${requestScope.strs }">
			${str}
		</c:forEach>
		<br>
		<c:forEach var="stu" items="${requestScope.stus }">
			${stu.sno }:${stu.sname}
		</c:forEach>

</body>
</html>