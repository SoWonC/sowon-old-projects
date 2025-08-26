<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인</title>
 
<link href="/css/main.css" rel="stylesheet">
<link href="/css/main2.css" rel="stylesheet">
</head>
<body>
  	<input class="dark-light" type="checkbox" id="dark-light" name="dark-light"/>
  	<label for="dark-light"></label>

  	<div class="light-back"></div> 

	<a href="https://front.codes/" class="logo" target="_blank">
		<img src="https://assets.codepen.io/1462889/fcy.png" alt="">
	</a>
<div id="header">
        <!-- 헤더 내용을 여기에 추가 -->
        <div class="userNow" style="font-weight: bold; text-align: center;">
            <u:isLogin>
             <p style="text-align: center;">${authInfo.nickname}님, 안녕하세요.</p>
            <a href="/logout" style="display: inline;">[로그아웃하기]</a>
        <a href="changePwd" style="display: inline;">[암호변경하기]</a>
            </u:isLogin>
            <u:notLogin>
            <a href="join">[회원가입하기]</a>
            <a href="login">[로그인하기]</a>
            </u:notLogin>
            <br />
        </div>
    </div>
  	<div class="sec-center"> 	
	  	<input class="dropdown" type="checkbox" id="dropdown" name="dropdown"/>
	  	<label class="for-dropdown" for="dropdown">메뉴<i class="uil uil-arrow-down"></i></label>
  		<div class="section-dropdown"> 
  			<a href="#" id="list-link">작사 게시판<i class="uil uil-arrow-right"></i></a>
		  	<input class="dropdown-sub" type="checkbox" id="dropdown-sub" name="dropdown-sub"/>
		  	<label class="for-dropdown-sub" for="dropdown-sub">Dropdown Sub <i class="uil uil-plus"></i></label>
	  		<div class="section-dropdown-sub"> 
	  			<a href="#">Dropdown Link <i class="uil uil-arrow-right"></i></a>
	  			<a href="#">Dropdown Link <i class="uil uil-arrow-right"></i></a>
	  		</div>
  			<a href="#">Dropdown Link <i class="uil uil-arrow-right"></i></a>
  			<a href="#">Dropdown Link <i class="uil uil-arrow-right"></i></a>
  		</div>
  	</div>
  	

    <div id="content-container" class="content-container">
        <!-- 컨텐츠가 여기에 동적으로 로드될 것입니다. -->
    </div>


	
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>