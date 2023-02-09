<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 h1{
        text-align: center;
     }
     .div1{
        display: inline-block;
        margin-left: 130px;
     }
     .div2{
        display: inline-block;
        margin-left: 260Px;
     }
     .div3{
        display: inline-block;
        margin-left: 250px;
     }
     .div4{
        display: inline-block;
        margin-left: 240px;
     }
     hr {
    background:red;
    width:1000px;
    height:1px;
    border:1;
    }
    h5{
     display: inline;
     margin-left: 130px;
    }
    h6{
        display: inline;
    }
    .color_18{
        font-style: red;
        margin-left: 40px;
    }
    .font_7{
      margin-left: 180px;
       
    }
    .font_8{
        margin-left: 80px; 
    }
    </style>
</head>
<body>
 <h1>경기일정</h1>  
    <div class="div1">DAY</div> <div class="div2">OPPONENT</div> <div class="div3">STADIUM</div>  <div class="div4">RESULT</div>
    <hr>
    <c:forEach items="${list }" var="dto">
    <h5 class="h5" style="font-size:35px;">${dto.myregdate}</h5>     <span class="color_18">(${dto.mygroup })</span><h6 class="font_6" style="font-size:20px;">${dto.myenemy }</h6> <span class="color_18"></span><h6 class="font_8" style="font-size:20px;">${dto.mycontent }</h6>  <h6 class="font_7" style="font-size:20px;"><span style="font-family:avenir-lt-w01_35-light1475496,sans-serif;">${dto.myresult }</span></h6>
    <hr >
    </c:forEach>
</body>
</html>