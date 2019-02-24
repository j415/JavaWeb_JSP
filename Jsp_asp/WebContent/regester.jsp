<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aspiring</title>
</head>
<body>
	<form action="show.jsp" method="post">
		ユーザー名(～めい)：<input	type="text" name="uname"/><br>
		パスワード：<input	type="password" name="upwd"/><br>
		年齢(ねんれい)：<input	type="text" name="uage"/><br>
		趣味(しゅみ)：
		<input	type="checkbox" name="uhobbies" value="サッカー"/>サッカー、
		<input	type="checkbox" name="uhobbies" value="バスケットボール" />バスケットボール、
		<input	type="checkbox" name="uhobbies" value="卓球" />卓球(たっきゅう)<br>
		<input	type="submit" value="登録(とうろく)">
		
	</form>

</body>
</html>