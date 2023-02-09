<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>
function fn1(){
	if (confirm("게시글을 삭제하시겠습니까?")) {
		location.href='/board/delete?boardSeq=${dto.boardSeq}'
	}
};
function fn2(){
	if (confirm("게시글을 추천하시겠습니까?")) {
		location.href='/board/updatelike?boardSeq=${dto.boardSeq}'
	}
};
	</script>
	<table border="1" class="table">
		<tr class="table-active">
			<th>작성자</th>
			<td width="500px">${dto.id }</td>
		</tr>
		<tr>
			<th>제  목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내  용</th>
			<td width="500px"><textarea rows="10" cols="70" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="수정" onclick="location.href='/board/updateform?boardSeq=${dto.boardSeq}'">
				<input type="button" value="삭제"  onclick="javascript:fn1();">
				<input type="button" value="목록" onclick="location.href='/board/list'">
				<div style="text-align:center">
					<input type="image" value="" src="../../img/likebutton.webp" width="35px" onclick="fn2();">
					<span>${dto.like }</span>
					
				</div>
				<div>
					<form method="post" action="/board/insertcomment?boardSeq=${dto.boardSeq}">
						<p>
							<label>댓글 작성자:</label><input type="text" name="id" >
						</p>
						<p>
							<textarea rows="4" cols="100" name="content"></textarea>
						</p>
						<p>
							<input type="submit" value="댓글 작성">
						</p>
					</form>
					
				</div>
			</td>
		</tr>
		</table>
		<table border="1">
		<c:forEach items="${comment }" var="cmt">
			<tr>
				<td width="100px">${cmt.id }</td>
				<td width="475px">${cmt.content }</td>
				<td width="200px"><fmt:formatDate value="${cmt.regDate}" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate>
				<input type="button" value="삭제" onclick="location.href='/board/delcomment?commentSeq=${cmt.commentSeq} + &boardSeq=${dto.boardSeq}'"></td>
			</tr>		
		</c:forEach>		
	</table>
	</div>
</body>
</html>