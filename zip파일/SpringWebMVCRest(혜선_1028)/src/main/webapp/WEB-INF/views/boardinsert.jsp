<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardinsert" method="post" id="boardform">
		<input name="num" type="text" required="required"><br> <input
			name="title" type="text"><br>
		<textarea name="content" cols="20" rows="30"></textarea>
		<br>
		<div>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		</div>
	
	</form>
</body>
</html>