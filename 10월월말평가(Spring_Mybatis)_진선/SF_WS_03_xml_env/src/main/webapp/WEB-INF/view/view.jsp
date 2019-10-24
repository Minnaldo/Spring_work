<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
				<td>차량번호</td>
				<td>${c.num}</td>
			</tr>
			<tr>
				<td>모델명</td>
				<td>${c.model}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${c.price} 만원</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>${c.vendor}</td>
			</tr>
			<tr>
				<td><a href="list.do">목록으로..</a></td>
			</tr>
	</table>
</body>
</html>