<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="member/memregpage">회원등록</a>
<a href="member/memselectall">회원조회</a>
<br>
<a href="product/productregpage">제품등록</a>
<a href="product/productselectlist">제품등록</a>
</body>
</html>
