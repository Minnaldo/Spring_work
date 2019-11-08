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
<c:choose>
<c:when test="${uid eq null }">
<form action="login" method="post">
	<input type="text" name="uid" value="ID">
	<input type="password" name="upw" value="PW">
	<input type="submit" value="submit">
</form>
</c:when>
<c:otherwise>
	${uid }님 회ㅡ하 
	<a href="logout">회ㅡ바</a>
</c:otherwise>
</c:choose>
</body>
</html>