<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.boot.jdbc.model.dto.MemberDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/chatt.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <header>
        <div id="navbar">
        <ul class="header-wrap container" type="none">
        <div class="nav-menu">
            <li><a href="#"><img src="resources/img/logo.png" style="width: 44px;"></a></li>
            <li><a href="#">About Us</a></li>
             <li><a href="guessvictory/list">경기 예측</a></li>
            <li><a href="board/list">게시판</a></li> 
            <li><a href="Highlightboard/list">하이라이트</a></li>
            <li><a href="WorldCup/list">경기 일정</a></li>
            <li><a href="#">커뮤니티</a></li>
            <div class="dropdown">
            <li class="material-symbols-outlined dropbtn" onclick="myFunction();">person
                <div id="myDropdown" class="dropdown-content">
                    <form action="/login" method="post" class="loginBox">
                        <table id="tableTr">
                            <tr>
                                <th>ID</th>
                                <td><input type="email" name="id"></td>
                            </tr>
                            <tr>
                                <th>PW</th>
                                <td><input type="password" name="password"></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="align-items: center;" id="input_btn">
                                    <input type="submit" value="로그인">
                                    <input type="button" value="회원가입" onclick="location.href='/signup/signupform'">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                </li>
            </div>
        </div>
         </ul>
        </div>
    </header>
    <main>
        <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="resources/img/firstimg.jpg" class="d-block" alt="1">
                </div>
              <div class="carousel-item">
                <img src="resources/img/secondimg.png" class="d-block" alt="2">
              </div>
              <div class="carousel-item">
                <img src="resources/img/thirdimg.jpeg" class="d-block" alt="3">
              </div>
              <div class="carousel-item">
                <img src="resources/img/fourthimg.webp" class="d-block" alt="4">
              </div>
              <div class="carousel-item">
                <img src="resources/img/fifthimg.webp" class="d-block" alt="5">
              </div>
              <div class="carousel-item">
                <img src="resources/img/sixthimg.webp" class="d-block" alt="6">
              </div>
              <div class="carousel-item">
                <img src="resources/img/seventhimg.webp" class="d-block" alt="7">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
          <div class="random-1">
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
				<textarea id="tcontent" value="hi..." readonly="readonly" placeholder="로그인 후 이용해주세요."></textarea>
			</c:when>
			<c:when test=" ${empty memberDto.name }">
				<textarea id="tcontent" value="hi..." readonly="readonly" placeholder="로그인 후 이용해주세요."></textarea>
			</c:when>
			<c:otherwise>
				<textarea id="tcontent" value="hi..."></textarea>
			</c:otherwise>		
		</c:choose>			
			<input type="button" value="전송" id="btnSend">
		</div>
	</div>
	<script src="resources/js/chatt.js"></script>	
          </div>
    </main>
    <footer>
        <div class="footer-wrap">
            <div class="social-media container">
                <div class="footer-logo"><a href="#">
                    <img src="resources/img/logo.png" style="width: 35px;">
                </a></div>
                <div class="brands">
                    <a href="https://twitter.com/FIFAcom"><i class="fa-brands fa-twitter fa-2xl"></i></a>
                    <a href="https://www.facebook.com/fifa"><i class="fa-brands fa-facebook fa-2xl"></i></a>
                    <a href="https://www.instagram.com/fifaworldcup"><i class="fa-brands fa-instagram fa-2xl"></i></a>
                    <a href="https://www.youtube.com/FIFATV"><i class="fa-brands fa-youtube fa-2xl"></i></a>
                </div>
                <div class="apps">
                    <a href="https://play.google.com/store/apps/details?id=com.fifa.fifaapp.android&hl=en"><img src="resources/img/googlePlay.png"></a>
                    <a href="https://apps.apple.com/us/app/fifa-official-app/id756904853"><img src="resources/img/appleAppStore.png"></a>
                </div>
            </div>
            <!-- <div class="random2" style="margin-bottom:300px; color:azure; font-size: 100px; text-align: center;">
                RANDOM
            </div> -->
            <hr style="color: #f5f5f7;">
            <div class="footer-last">
            <div class="rules">
                <a href="https://www.fifa.com/data-protection-portal/data-protection-policy">Privacy Policy</a>
                <a href="https://www.fifa.com/terms-of-service">TERMS OF SERVICE</a>
                <a href="https://www.fifa.com/fifaplus/en/articles/advertise-with-us">ADVERTISE</a>
                <a href="">MANAGE COOKIE PREFERENCES</a>
            </div>
            <span class="cpyt">Copyright © 1994 - 2022 FIFA. All rights reserved.</span>
            </div>
        </div>
    </footer>
    <script src="https://kit.fontawesome.com/2659579d21.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>