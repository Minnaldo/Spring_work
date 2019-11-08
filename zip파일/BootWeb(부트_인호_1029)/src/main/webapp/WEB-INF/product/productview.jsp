<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단일 상품 정보</title>
</head>
<body>
<h1>상품 정보</h1>
	<table border="1">
		<tr>
			<td>상품번호</td>
			<td><input type="text" id="num" name="num" required="required" value="${ product.num }"></td>
		</tr>
		<tr>
			<td>상품이름</td>
			<td><input type="text" id="name" name="name" required="required" value="${ product.name }"></td>
		</tr>
		<tr>
			<td>상품가격</td>
			<td><input type="text" id="price" name="price" required="required" value="${ product.price }"></td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td><input type="text" id="quantity" name="quantity" required="required" value="${ product.quantity }"></td>
		</tr>
	</table>
</body>
</html>