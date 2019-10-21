<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
	<h1>회원리스트</h1>
		<table border="1">
			<tr>
				<th>아이디</th> <th>이름</th> <th>이메일</th>
			</tr>
			<c:forEach items="${list }" var="mem">
				<tr>
					<td>아이디 : ${mem.id }</td>
					<td>이름 : ${mem.name }</td>
					<td>이메일 : ${mem.email }</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>