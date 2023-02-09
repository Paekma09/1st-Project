<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .wrapper{
        width: 800px;
        margin-left: 230px;
    }
    .header{
        text-align: center;
    }
    .sodate{
        text-align: center;
        background-color: lightgray;
        font-size: 20px;
    }
    .sostar{
        display: inline-block;
        margin-left: 180px;
    }
    .sores{
        display: inline-block;
        margin-left: 200px;
    }
    .sogroup{
        margin-left: 380px;
        font-size: 20px;
    }
    .soteam{
        margin-left: 330px;
        width: 300px;
    }

</style>
<body>
    <div class="header"><h1>경기 일정</h1></div>
    <br><hr><br><br>
<c:forEach items="${list }" var="dto">   
<div class="wrapper">
    <div class="sodate">${dto.myregdate }</div>
    <div class="sogroup">${dto.mygroup }</div><hr><br>
    <div class="soteam"><b>${dto.myenemy }</b></div><hr>
    <div class="sostar"><br>
        <div><b>경기장</b></div><hr>
        <div>${dto.mycontent }</div>
    </div>
    <div class="sores">
        <div><b>경기 결과</b></div><hr>
        <div>${dto.myresult }</div>
    </div>
</div>
<br><br><hr><br>
</c:forEach>
</body>
</html>