<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="email" name="id"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='/signup/register'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>