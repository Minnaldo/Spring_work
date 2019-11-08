<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>횐조회</title>
<script type="text/javascript">
function del() {
	location.href="memdelete"
}
</script>
</head>
<body>
	<h1>안녕하세요 횐님</h1>
	<form action="memupdate" method="post" id="memform">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" required="required"
					value="${mem.id }"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" id="pw" name="pw"
					required="required" value="${mem.pw }"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" id="name" name="name"
					required="required" value="${mem.name }"></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><input type="email" id="email" name="email"
					value="${mem.email }"></td>
			</tr>
			<tr>
				<td><input type="reset" value="clear"><input
					type="submit" value="update">
					<input type="button" value="delete" onclick="del()"></td>
			</tr>
		</table>
	</form>
</body>
</html>