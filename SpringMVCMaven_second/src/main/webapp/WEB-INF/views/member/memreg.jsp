<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<!-- 점심 먹고 와서 버튼부터.. -->
<script type="text/javascript">
	function insert() {
		memform.action = "meminsert";
		memform.submit();
	}
	function update() {
		memform.action = "memupdate";
		memform.submit();
	}
	function del() {
		memform.action = "memdelete";
		memform.submit();
	}
	function seletone() {
		memform.action = "memselectone";
		memform.submit();
	}
	function selectlist() {
		memform.action = "memselectall";
		memfrom.submit();
	}
</script>

</head>
<body>
	<h1>회원등록</h1>
	<form action="meminsert" method="post" id="memform">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" required="required">
				</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw"
					required="required"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" id="name" name="name"
					required="required"></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="email" id="email" name="email"></td>
				
			<!-- 버튼 생성 -->
			</tr>
				<td colspan="2">
					<input type="reset" value="초기화">
					<input type="button" value="삽입" onclick="insert()">
					<input type="button" value="수정" onclick="update()">
					<input type="button" value="삭제" onclick="del()">
					<input type="button" value="선택조회" onclick="selectone()">
					<input type="button" value="전체조회" onclick="selectlist()">
				</td>
			<tr>
				
			</tr>
		</table>
	</form>
</body>
</html>