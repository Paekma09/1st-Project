<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<%@ page import="com.boot.jdbc.model.dto.MemberDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응원톡</title>
<link rel="stylesheet" type="text/css" href="resources/css/chatt.css">
<script type="text/javascript" src=https://code.jquery.com/jquery-3.6.1.min.js></script>
</head>
<body>
	<div id="chatt">
		<h1>응원톡</h1>
		<input type="text" id="name" value="${memberDto.name }">
		<input type="hidden" id="id" value="${memberDto.id }">
		<input type="button" value="응원톡 참가" id="btnLogin" style="background-color: #550065; color: white; border-radius: 5px; width: 15%">
		<br><br>
		<div id="talk">
			<fieldset id="addele" style="border: 1px solid white;">
				<img id="img" src="resources/img/2022.png" height="300px">
				<input type="button" value="응원톡 보기" id="talkView" onclick="view();">
				<div></div>
			</fieldset>
		</div>
		<div id="sendZone">
		<c:choose>
			<c:when test="${memberDto.name eq null }">
				<textarea id="tcontent" value="hi..." readonly="readonly" placeholder="로그인 후 이용해주세요." onclick="location.href='/loginform'"></textarea>
			</c:when>
			<c:when test=" ${empty memberDto.name }">
				<textarea id="tcontent" value="hi..." readonly="readonly" placeholder="로그인 후 이용해주세요." onclick="location.href='/loginform'"></textarea>
			</c:when>
			<c:otherwise>
				<textarea id="tcontent" value="hi..."></textarea>
			</c:otherwise>		
		</c:choose>			
			<input type="button" value="전송" id="btnSend">
		</div>
	</div>
	<script src="resources/js/chatt.js"></script>
</body>
</html>