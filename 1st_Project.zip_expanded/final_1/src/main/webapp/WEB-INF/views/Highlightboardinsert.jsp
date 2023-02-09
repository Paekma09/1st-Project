<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: gray">

<header class="bg-primary bg-gradient text-white" style="background-color:#550065  !important">
            <div class="container px-4 text-center">
                <p class="lead">글 쓰기 상세 페이지</p>
            </div>
        </header>

<form action="/Highlightboard/insert" method="post">
	<table border="1" class="container col-3 mt-2" style="background-color: white" class="table">
		<tr class="table-active">
			<th style="text-align: center;">제 목</th>
			<td><input type="text" name="hititle"></td>
		</tr>
		<tr>
			<th style="text-align: center;">U R L</th>
			<td><textarea rows="20" cols="40" name="hipath"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="작성">
				<input type="button" value="목록" onclick="location.href='/Highlightboard/list'">
	</table>

</form>


</body>
</html>