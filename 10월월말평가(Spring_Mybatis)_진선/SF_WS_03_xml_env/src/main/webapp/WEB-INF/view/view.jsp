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
				<td>������ȣ</td>
				<td>${c.num}</td>
			</tr>
			<tr>
				<td>�𵨸�</td>
				<td>${c.model}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${c.price} ����</td>
			</tr>
			<tr>
				<td>������</td>
				<td>${c.vendor}</td>
			</tr>
			<tr>
				<td><a href="list.do">�������..</a></td>
			</tr>
	</table>
</body>
</html>