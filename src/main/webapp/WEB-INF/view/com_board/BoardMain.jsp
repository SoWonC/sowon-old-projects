<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인</title>
 
<link href="/css/main.css" rel="stylesheet">
<link href="/css/content.css" rel="stylesheet">
<link href="/css/usernow.css" rel="stylesheet">
</head>
<body>
  	
	<header class="cd-header">
		<div class="header-wrapper">
			<div class="logo-wrap">
				<a href="#" class="hover-target"><span>Lyrics</span>Keeper</a>
			</div>
			<div class="nav-but-wrap">
				<div class="menu-icon hover-target">
					<span class="menu-icon__line menu-icon__line-left"></span>
					<span class="menu-icon__line"></span>
					<span class="menu-icon__line menu-icon__line-right"></span>
				</div>					
			</div>					
		</div>				
	</header>
	
<div id="header">
        <!-- 헤더 내용을 여기에 추가 -->
        <div class="userNow" style="font-weight: bold; text-align: center;">
            <u:isLogin>
             <p style="text-align: center;">${authInfo.nickname}님, 안녕하세요.</p>
            <a href="/logout" style="display: inline;">[로그아웃하기]</a>

            </u:isLogin>
            <u:notLogin>
            <a href="join">[회원가입하기]</a>
            <a href="login">[로그인하기]</a>
            </u:notLogin>
            <br />
        </div>
    </div>
    
	<div class="nav">
		<div class="nav__content">
			<ul class="nav__list">
				<li class="nav__list-item active-nav"><a href="#" class="hover-target">Home</a></li>
				<li class="nav__list-item"><a href="#" id="list-link"  class="hover-target">작사 게시판</a></li>
				<li class="nav__list-item"><a href="#" class="hover-target">자유 커뮤니티</a></li>
				<li class="nav__list-item"><a href="#" class="hover-target">마이페이지</a></li>

			</ul>
		</div>
	</div>		

	<div class="section full-height over-hide">	
		<div class="switch-wrap">
			<h1>Lyrics - Keeper</h1>
			<div id="switch" class="hover-target">
				<div id="circle"></div>
			</div>
			<p><span>dark</span> - <span>light</span></p>
		</div>
	</div>	
	
	<div id="content-container" class="content-container">
        <!-- 컨텐츠가 여기에 동적으로 로드될 것입니다. -->
        <input type="hidden" value="${nick}" >
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.number}</td>
				<td><a href="view?number=${dto.number}">${dto.title}</a></td>
				<td>${dto.nickname}</td>
				<td>${dto.hits}</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="writeForm">글작성</a>
	</p>
	
	<p> <a href="/">홈화면으로 돌아가기</a> </p>
        
    </div>
	<div class='cursor' id="cursor"></div>
	<div class='cursor2' id="cursor2"></div>
	<div class='cursor3' id="cursor3"></div>

<!-- Link to page
================================================== -->

<a href="https://front.codes/" class="link-to-portfolio hover-target" target=”_blank”></a>

	
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/mainn.js"></script>
    <script src="/js/main3.js"></script>
    
</body>
</html>