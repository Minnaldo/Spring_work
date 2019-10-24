<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
</head>
<body>
	<h1>상품리스트</h1>
	<table border="1">
		<tr>
			<th>상품번호</th><th>상품이름</th><th>상품가격</th><th>재고수량</th>
		</tr>
		<c:forEach items="${ list }" var="product">
		<tr>
			<td><a href="productselectone?num=${ product.num }">${ product.num }</a></td>
			<td>${ product.name }</td>
			<td>${ product.price }</td>
			<td>${ product.quantity }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>