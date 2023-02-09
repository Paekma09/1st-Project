<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	/* window.onload = function(){
		if(${login}.id )
		alert("")
	} */
	$(function(){
		$(".nation1").click(function(){
			var element = $(this);
			var nation1 = element.children().children("#nationName1").html();
	        var playTime = element.parent().siblings("#playTime").html();
	        var playDate = element.parent().parent().prev().prev().children("span:eq(0)").html();
	        
	      	$.ajax({
				url : "ajaxVote1?nation1=" + nation1 + "&playTime=" + playTime + "&playDate=" + playDate,
				type : "GET",
				dataType : "text",
				success : function(data){
					element.children().children("#voteRates1").html(data + "%");
					element.siblings(".nation2").children().children("#voteRates2").html((100-data) + "%");
					element.children().addClass("hvr-bounce-to-left");
				},
				error : function(){
					alert("통신 오류");
				}
			});
		});
		
		$(".nation2").click(function(){
			var element = $(this);
			var nation2 = element.children().children("#nationName2").html();
	        var playTime = element.parent().siblings("#playTime").html();
	        var playDate = element.parent().parent().prev().prev().children("span:eq(0)").html();

			$.ajax({
				url : "ajaxVote2?nation2=" + nation2 + "&playTime=" + playTime + "&playDate=" + playDate,	
				success : function(data){
					element.children().children("#voteRates2").html(data + "%");
					element.siblings(".nation1").children().children("#voteRates1").html((100-data) + "%");
					element.children().addClass("hvr-bounce-to-right");
				},
				error : function(){
					alert("통신 오류");
				}
			});
		});
	})
</script>
<style>
    /* Bounce To Right */
	.hvr-bounce-to-right {
	  -webkit-transform: perspective(1px) translateZ(0);
	  transform: perspective(1px) translateZ(0);
	  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
	  position: relative;
	  -webkit-transition-property: color;
	  transition-property: color;
	  -webkit-transition-duration: 0.5s;
	  transition-duration: 0.5s;
	}
	.hvr-bounce-to-right:before {
	  content: "";
	  position: absolute;
	  z-index: -1;
	  top: 0;
	  left: 0;
	  right: 0;
	  bottom: 0;
	  background: #550065;
	  -webkit-transform: scaleX(0);
	  transform: scaleX(0);
	  -webkit-transform-origin: 0 50%;
	  transform-origin: 0 50%;
	  -webkit-transition-property: transform;
	  transition-property: transform;
	  -webkit-transition-duration: 0.5s;
	  transition-duration: 0.5s;
	  -webkit-transition-timing-function: ease-out;
	  transition-timing-function: ease-out;
	}
	.hvr-bounce-to-right:hover, .hvr-bounce-to-right:focus, .hvr-bounce-to-right:active {
	  color: white;
	}
	.hvr-bounce-to-right:hover:before, .hvr-bounce-to-right:focus:before, .hvr-bounce-to-right:active:before {
	  -webkit-transform: scaleX(1);
	  transform: scaleX(1);
	  -webkit-transition-timing-function: cubic-bezier(0.52, 1.64, 0.37, 0.66);
	  transition-timing-function: cubic-bezier(0.52, 1.64, 0.37, 0.66);
	}
	
	/* Bounce To Left */
	.hvr-bounce-to-left {
	  -webkit-transform: perspective(1px) translateZ(0);
	  transform: perspective(1px) translateZ(0);
	  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
	  position: relative;
	  -webkit-transition-property: color;
	  transition-property: color;
	  -webkit-transition-duration: 0.5s;
	  transition-duration: 0.5s;
	}
	.hvr-bounce-to-left:before {
	  content: "";
	  position: absolute;
	  z-index: -1;
	  top: 0;
	  left: 0;
	  right: 0;
	  bottom: 0;
	  background: #550065;
	  -webkit-transform: scaleX(0);
	  transform: scaleX(0);
	  -webkit-transform-origin: 100% 50%;
	  transform-origin: 100% 50%;
	  -webkit-transition-property: transform;
	  transition-property: transform;
	  -webkit-transition-duration: 0.5s;
	  transition-duration: 0.5s;
	  -webkit-transition-timing-function: ease-out;
	  transition-timing-function: ease-out;
	}
	.hvr-bounce-to-left:hover, .hvr-bounce-to-left:focus, .hvr-bounce-to-left:active {
	  color: white;
	}
	.hvr-bounce-to-left:hover:before, .hvr-bounce-to-left:focus:before, .hvr-bounce-to-left:active:before {
	  -webkit-transform: scaleX(1);
	  transform: scaleX(1);
	  -webkit-transition-timing-function: cubic-bezier(0.52, 1.64, 0.37, 0.66);
	  transition-timing-function: cubic-bezier(0.52, 1.64, 0.37, 0.66);
	}
	.nationalFlag{
        border : 1px solid;
        width: 200px;
        height: 100px;
    }

    button{
        background-color:transparent;
        cursor:pointer;
        border:none;
        width:300px;
    }
    
    .todayBox{
        background-color : #550065;
        color: white;
        border-radius: 10px;
    }   

    #mainImg{
        text-align: center;
    }
    body{
        margin: 0px auto;
        width:800px;
    }
    
    #playTime{
    	border: 1px #550065 solid; background-color: #b066bf; color: white; border-radius: 10px;
    }
    
</style>
</head>
<body>

	<!-- <div id="mainImg"><img src=".././image/guessVictoryImg.PNG"></div> -->
	<div id="mainImg"><img src="resources/img/fifa.png"></div>
	<c:forEach items="${dateList }" var="date">
		<div id="playDate">
			<span style="font-size: 20px; font-weight:bold">${date }</span>
			<c:if test="${date eq today}">
				<span id="today" class="todayBox">&nbsp오늘&nbsp</span>
			</c:if>
			<br><br>
			<div style="border-top:3px #550065 dotted"></div>
		</div><br>
		<div class="playInfo">
			<c:forEach items="${list }" var="dto">
				<c:choose>
					<c:when test="${dto.playDate eq date}">
						<span id="playTime" style="font-size: 15px; font-weight:bold; padding:5px;">${dto.playTime}</span><br><br>
						<div class="matchButton" style="text-align: center;">
							<button type="button" class="nation1" style="padding-right: 80px;">
								<div>
									<img class="nationalFlag" src="${dto.nationImg1 }">
								</div><br>
								<div class="matchItem_Info">
									<div id="nationName1" style="font-size: 20px; font-weight:bold">${dto.nation1 }</div>
									<div id="voteRates1" style="font-size: 20px; font-weight:bold;"></div>
								</div>
							</button>
							<button type="button" class="nation2" style="padding-left: 80px;">
								<div>
									<img class="nationalFlag" src="${dto.nationImg2 }">
								</div><br>
								<div class="matchItem_Info">
									<div id="nationName2" style="font-size: 20px; font-weight:bold">${dto.nation2 }</div>
									<div id="voteRates2" style="font-size: 20px; font-weight:bold;"></div>
								</div>
							</button>
						</div>
						<br><br><br>
					</c:when>
				</c:choose>
			</c:forEach>
		</div>
	</c:forEach>
</body>
</html>