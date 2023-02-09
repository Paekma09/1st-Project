<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorldCup</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<style type="text/css">
		a:link{color: blue;}
		a:visited{color: blue;}
		a:hover{color:white;background: #550065;}
		a{text-decoration:none}
		
		
		#ex1{font-weight:bold;}
		#ex2{font-weight:black;}
	</style>
<body style="background-color: gray">
<header class="bg-primary bg-gradient text-white" style="background-color:#550065  !important">
            <div class="container px-4 text-center">
                <h1 class="fw-bolder"><img src="../../img/img3.png" width="50px">자유게시판</h1>
<!--                 <input type="image" value="" src="../../img/img3.png" width="50px"> -->
                <p class="lead">2022년 카타르 월드컵</p>
            </div>
        </header>
<div class="container col-8" style="background-color:  white">
	<table border="1">
		<col width="50">
		<col width="875">
		<col width="150">
		<col width="100">
		<col width="75">
		<col width="200">
		
		<tr align="center">
			<th>NO</th>
			<th>제  목</th>
			<th>작성자</th>	
			<th>좋아요</th>
			<th>조  회</th>
			<th>작성시간</th>
			<td><input type="hidden" value="${dto.boardSeq} " name="boardSeq" /></td>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="6" align="center">작성된 글이 없습니다</td>
				</tr>
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${notice }" var="notice">
					<tr align="center">
<%-- 						<td>${test.index }</td> --%>
						<td>${notice.boardSeq }</td>
						<td style="background-color:yellow;"><small style="color: black;">※공지사항※</small><a href="/board/detail?boardSeq=${notice.boardSeq }"id="ex2">${notice.title }
							</a><small><b>[&nbsp;<c:out value="${notice.cntComment }"/>&nbsp;]</b></small>
						</td>
						<td>${notice.id }</td>
						<td>${notice.like }</td>
						<td>${notice.readCount }</td>
						<td><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd(E) HH:mm:ss" /></td>
<%-- 						<td>${notice.regDate }</td> --%>
					</tr>
				</c:forEach>
				<c:forEach items="${like }" var="like">
				
					<tr align="center">
<%-- 						<td>${test.index }</td> --%>
						<td>${like.boardSeq }</td>
						<td style="background-color:buttonface;"><small style="color: red;">Hot!&nbsp;</small><a href="/board/detail?boardSeq=${like.boardSeq }"id="ex1">${like.title }</a>
							<small><b>[&nbsp;<c:out value="${like.cntComment }"/>&nbsp;]</b></small>
						</td>
						<td>${like.id }</td>
						<td>${like.like }</td>
						<td>${like.readCount }</td>
						<td><fmt:formatDate value="${like.regDate}" pattern="yyyy-MM-dd(E) HH:mm:ss" /></td>
<%-- 						<td>${like.regDate }</td> --%>
					</tr>
				</c:forEach>
				<c:forEach items="${list }" var="dto">
					<tr align="center">
<%-- 						<td>${test.index }</td> --%>
						<td>${dto.boardSeq }</td>
						<td><a href="/board/detail?boardSeq=${dto.boardSeq }">${dto.title }</a>
							<small><b>[&nbsp;<c:out value="${dto.cntComment }"/>&nbsp;]</b></small>
						</td>
						<td>${dto.id }</td>
						<td>${dto.like }</td>
						<td>${dto.readCount }</td>
						<td><fmt:formatDate value="${dto.regDate}" pattern="yyyy-MM-dd(E) HH:mm:ss" /></td>
<%-- 						<td>${dto.regDate }</td> --%>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="글작성"
            onclick="location.href='/board/insertform'">
			</td>
		</tr>
		
	</table>
	</div>
</body>
</html>