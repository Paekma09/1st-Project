<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body style="background-color: gray">


<header class="bg-primary bg-gradient text-white" style="background-color:#550065  !important">
            <div class="container px-4 text-center">
                <h1 class="fw-bolder">하이라이트</h1>
                <p class="lead">2022년 카타르 월드컵</p>
            </div>
        </header>

	<div class="container col-6" style="background-color:  white">
	
	
	
	<table border="0" class="table table-hover">
		<col width="50">
		<col width="200">
		<col width="100">
		<col width="100">
		
		<tr>
			<th scope="col" class="text-center">글 번호</th>
			<th scope="col" class="text-center">글 제목</th>
			<th scope="col" class="text-center">조회수</th>
			<th scope="col" class="text-center">작성일</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" style="width: 60%">-----작성된 글이 없습니다-----</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td style="width: 10%" class="text-center">${dto.hino }</td>
						<td style="width: 60%"><a href="/Highlightboard/detail?hino=${dto.hino }" style="text-decoration:none"  >${dto.hititle } (${dto.commentcount})</a></td>
						<td style="width: 10%" class="text-center">${dto.hireadcount }</td>
						<td style="width: 20%" class="text-center"><fmt:formatDate value="${dto.hidate}" pattern="yyyy-MM-dd(E)" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="4" align="right">
				<c:if test="${login.id eq 'admin' }">
				<input type="button" value="글 작성"
				onclick="location.href='/Highlightboard/insertform'">
				</c:if>
			</td>
		</tr>
			
	</table>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/Highlightboard/list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/Highlightboard/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/Highlightboard/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
	
	
	</div>
</body>
</html>