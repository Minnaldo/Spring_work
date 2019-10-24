<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>
	<h1>회원등록</h1>
	<form action="meminsert" method="post" id="memform">
		<table border="1">
			<tr>
				<td>ID</td><td><input type="text" id="id" name="id" required="required"></td>
			</tr>
			<tr>
				<td>PW</td><td><input type="password" id="pw" name="pw" required="required"></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" id="name" name="name" required="required"></td>
			</tr>
			<tr>
				<td>email</td><td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>