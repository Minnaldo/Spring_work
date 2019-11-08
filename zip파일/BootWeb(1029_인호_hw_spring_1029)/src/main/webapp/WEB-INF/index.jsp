<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW_1029</title>
<Script Language="JavaScript">
	function login() {
		if (loginform.id.value == "") {
			alert("ID를 입력하세요")
			loginform.id.focus();
		} else if (loginform.pw.value == "") {
			alert("비밀번호를 입력하세요")
			loginform.pw.focus();
		} else {
			loginform.action="member/login";
			loginform.submit();
		}
	}
</Script>
</head>
<body>
	<center><h1>Hello Spring Boot - webapp - WEB-INF</h1></center>

	<c:choose>
		<c:when test="${id eq null }">
			<center><form action="" method="post" id="loginform">
				<table>
					<tr>
						<td>id</td>
						<td><input type="text" id="id" name="id" required="required"></td>
					</tr>
					<tr>
						<td>pw</td>
						<td><input type="password" id="pw" name="pw" required="required"></td>
					</tr>

					<tr>
						<td colspan="2"><input type="button" value="로그인"
							onclick="login()"></td>
					</tr>
				</table>
			</form></center>
		</c:when>
		<c:otherwise>
			${ id }님 안녕하세요	<input type="button" value="로그아웃"
				onclick="location.href='member/logout'">
		</c:otherwise>
	</c:choose>

	<center><a href="member/memregpage">회원등록</a></center>
	<center><a href="member/memselectall">회원조회</a></center>
</body>
</html>