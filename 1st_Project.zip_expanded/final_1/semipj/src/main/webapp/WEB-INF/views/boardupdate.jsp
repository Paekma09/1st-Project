<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World Cup</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body style="background-color: gray">
        <div class="container col-8 mt-2" style="background-color:white">
	<form action="/board/update" method="post">
		<input type="hidden" name="boardSeq" value="${dto.boardSeq }">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><input type="text" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<th>내  용</th>
				<td><textarea rows="10" cols="70" name="content">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='/board/list'">
				</td>
			</tr>
		</table>
	</form>









</div>
</body>
</html>