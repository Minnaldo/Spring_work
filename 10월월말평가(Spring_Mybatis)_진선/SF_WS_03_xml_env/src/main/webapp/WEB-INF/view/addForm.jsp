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
				<td>������ȣ</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>�𵨸�</td>
				<td><input type="text" name="model"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="number" name="price"> ����</td>
			</tr>
			<tr>
				<td>������ �ڵ�</td>
				<td><input type="text" name="vcode"></td>
			</tr>
			<tr>
				<td><input type="submit" value="�ڵ��� ���"></td>
				<td><input type="reset" value="���"></td>
			</tr>
		</table>
		<a href="list.do">�������..</a>
	</form>
</body>
</html>