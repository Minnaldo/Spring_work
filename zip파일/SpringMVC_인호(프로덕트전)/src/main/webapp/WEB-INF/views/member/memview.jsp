<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id" name="id" required="required" value="${ mem.id }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name" name="name" required="required" value="${ mem.name }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" id="email" name="email" required="required" value="${ mem.email }"></td>
		</tr>
	</table>
</body>
</html>