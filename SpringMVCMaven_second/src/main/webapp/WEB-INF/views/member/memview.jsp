<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h1>회원정보</h1>
	<form action="meminsert" method="post" id="memform">
		<table border="1">		
		
			<tr>
				<th>아이디</th> <th>이름</th> <th>이메일</th>
			</tr>
				<tr>
					<td><input type="text" id="id" name="id" required="required" value="${mem.id }"> </td>
					<td><input type="text" id="name" name="name" required="required" value="${mem.name }"></td>
					<td><input type="text" id="email" name="email" required="required" value="${mem.email }"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="rest" value="초기화"><input type="submit"> </td>
				</tr>
		</table>
	</form>
</body>
</html>