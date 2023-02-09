<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<form action="/Highlightboard/update" method="post">
		<input type="hidden" name="hino" value="${dto.hino }">
		<table border="1">
			<tr>
				<th>HITITLE</th>
				<td><input type="text" name="hititle" value="${dto.hititle }"></td>
			</tr>
			<tr>
				<th>HIPATH</th>
				<td><textarea rows="10" cols="40" name="hipath">${dto.hipath }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='/Highlightboard/list'">
				</td>
			</tr>
		</table>
	</form>
	
	

</body>
</html>