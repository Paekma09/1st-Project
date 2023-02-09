<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function deleteHighlight(hino){
		if(confirm ("삭제하시겠습니까?")){
			location.href='/Highlightboard/delete?hino=' + hino
		}
	};
	
	function deletecomment(cono, hino){
		if(confirm ("삭제하시겠습니까?")){
			location.href='/Highlightboard/deletecomment?cono=' + cono+"&hino="+hino;
		}
	};
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body style="background-color: gray">





	<div class="container col-6 mt-2" style="background-color: white">

		<table border="1" class="table">
			<tr class="table-active">
				<th style="text-align: center;">${dto.hititle }</th>
			</tr>
			<tr>
				<th colspan="2"  style="text-align: center;">하이라이트 영상</th>
			</tr>
			<tr>
				<td colspan="2" align="center"><iframe width="560" height="315" src="${dto.hipath }"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="수정" 	onclick="location.href='/Highlightboard/updateform?hino=${dto.hino}'">
					<input type="button" value="삭제" 	onclick="deleteHighlight(${dto.hino})"> 
					<input type="button" value="목록" 	onclick="location.href='/Highlightboard/list'">
				</td>
			</tr>


		</table>
		<hr>


		<table border="1" class="table">
			<c:forEach items="${coList }" var="coDto">
				<tr class="table-active">
					<td style="width:20%">${coDto.name }</td>
					<td>${coDto.codetail }</td>
					<td><fmt:formatDate value="${coDto.codate}"	pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td colspan="2">
					<c:if test="${login.id eq coDto.id }">
						<input type="button" value="삭제"	onclick="deletecomment(${coDto.cono}, ${dto.hino });">
					</c:if>
					</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3">
					<div>
						<form method="post" action="/Highlightboard/insertcomment">
							<input type="hidden" value="${dto.hino} " name="hino" />
							<c:if test="${!empty login }">
							<p>
								<label>댓글 작성자: </label> <input type="text" readonly="readonly" value="${login.name }" >
								<input type="hidden" name="id" value="${login.id }">
							</p>
							<p>
								<textarea rows="4" cols="80" name="codetail"></textarea>
							</p>
							<p>
								<button type="submit">댓글 작성</button>
							</p>
							</c:if>
						</form>

					</div>
				</td>
			</tr>
		</table>

	</div>

</body>
</html>