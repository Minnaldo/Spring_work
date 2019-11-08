<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>횐등록</title>
</head>
<body>

<jsp:include page="login.jsp"/>
	<h1>안녕하세요 횐님</h1>
	<form action="meminsert" method="post" id="memform">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" required="required"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw"
					required="required"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" id="name" name="name"
					required="required"></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<td><input type="reset" value="clear"><input
					type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<br>
<a href="./">home</a>
</body>
</html>