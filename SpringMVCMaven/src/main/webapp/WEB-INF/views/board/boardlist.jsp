<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>뭐냐? 게시글 등록이다!</h1>
	<table border="1">
		<tr><th>no</th><th>title</th><th>content</th></tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.no } </td>
				<td>${board.title } </td>
				<td>${board.content } </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>