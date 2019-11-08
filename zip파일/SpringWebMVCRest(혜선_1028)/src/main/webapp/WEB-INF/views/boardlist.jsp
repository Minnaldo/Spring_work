<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${list }" var="board">
		<h3>${board.num }/ ${board.title }</h3>
		<h4>${board.content }</h4>
	</c:forEach>
</body>
</html>