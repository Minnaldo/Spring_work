<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>자동차 관리 - 리스트</h2>
	
	<table>
		<tr>
			<td width="100px">모델번호</td>
			<td width="100px">모델이름</td>
			<td width="100px">가격</td>
			<td width="100px">제조사명</td>
			<td width="100px">삭제</td>
			
		</tr>
		
		<c:forEach items="${list}" var="car">
		<tr>
			<td width="100px"><a href="view.do?num=${car.num}">${car.num }</a></td>
			<td width="100px">${car.model }</td>
			<td width="100px">${car.price }</td>
			<td width="100px">${car.vendor }</td>
			<td width="100px"><a href="delete.do?num=${car.num }">삭제</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td align="right"><a href="addForm.do">추가 등록</a></td>
		<tr>
	</table>
</body>
</html>