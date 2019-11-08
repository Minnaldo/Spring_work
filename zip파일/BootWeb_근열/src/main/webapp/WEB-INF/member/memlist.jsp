<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>횐님리스트</title>
</head>
<body>
	<h1>횐님들의 소중한 정보</h1>
	<table border="1">
		<tr>
			<th>ID</th><th>NAME</th><th>MAIL</th>
		</tr>
		<c:forEach items="${list }" var="mem">
			<tr>
				<td><a href="memselone?id=${mem.id}">${mem.id }</a></td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
			</tr>
		</c:forEach>
	</table>
<a href="./">home</a>
</body>
</html>