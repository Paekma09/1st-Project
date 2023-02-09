<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .header{
               text-align: center;
            }
            .div1{
               display: inline-block;
               margin-left: 750px;
               font-size:35px;
            }
            .div2{
               display: inline-block;
               margin-left: 200Px;
                font-size:35px;
            }
            .div3{
               display: inline-block;
               margin-left: 140px;
                font-size:35px;
            }
            .div4{
               display: inline-block;
               margin-left: 120px;
                font-size:35px;
            }
            hr {
           background:red;
           width:1000px;
           height:1px;
           border:1;
            }
            
           
            .wp1 > div{
            display: inline-block;
           }
           
           .wp1{margin-left: 730px;}

           .wp1 .bd0{width: 23%;}
           .wp1 .bd2{width: 26%;}
           .wp1 .bd3{width: 30%}
           .wp1 .bd4{width: 0%; text-align: right;}
    </style>
</head>
<body>
    <h1 class="header">경기일정</h1>  
    <div class="wp0">
    <div class="div1">DAY</div> <div class="div2">OPPONENT</div> <div class="div3">STADIUM</div>  <div class="div4">RESULT</div>
</div>
    <hr>
    <c:forEach items="${list }" var="dto">
    <div class="wp1">
    <div class="bd0" style="font-size:25px;"><h5>${dto.myregdate}</h5></div>     
    <div class="bd1">(${dto.mygroup })</div>
    <div class="bd2" style="font-size:25px;"><h6>${dto.myenemy }</h6></div> 
    <div class="bd3" style="font-size:25px;"><h6>${dto.mycontent }</h6></div> 
    <div class="bd4" style="font-size:25px;"><b>${dto.myresult }</b></div>
    </div>
    <hr>
    </c:forEach>
</body>
</html>