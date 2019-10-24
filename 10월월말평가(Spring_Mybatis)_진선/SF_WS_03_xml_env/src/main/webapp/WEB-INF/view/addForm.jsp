<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="addCar.do" method="post">
		<table>
			<tr>
				<td>차량번호</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>모델명</td>
				<td><input type="text" name="model"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price"> 만원</td>
			</tr>
			<tr>
				<td>제조사 코드</td>
				<td><input type="text" name="vcode"></td>
			</tr>
			<tr>
				<td><input type="submit" value="자동차 등록"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
		<a href="list.do">목록으로..</a>
	</form>
</body>
</html>