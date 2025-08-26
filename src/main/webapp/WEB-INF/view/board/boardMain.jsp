<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 메인</title>
    
</head>
<body>
    <div id="header">
        <!-- 헤더 내용을 여기에 추가 -->
        <h1>게시판 메인</h1>
        <div class="userNow" style="font-weight: bold;">
            <u:isLogin>
            ${authInfo.nickname}님, 안녕하세요.
            <a href="logout">[로그아웃하기]</a>
            <a href="changePwd">[암호변경하기]</a>
            </u:isLogin>
            <u:notLogin>
            <a href="join">[회원가입하기]</a>
            <a href="login">[로그인하기]</a>
            </u:notLogin>
            <br />
        </div>
    </div>

    <div id="menu">
        <!-- 메뉴 탭 내용을 여기에 추가 -->
        <ul>
            <li><a href="#" id="list-link">게시판 목록</a></li>
           <!--<li><a href="#" id="write-link">게시글 쓰기</a></li>
             다른 메뉴 항목 추가 -->
        </ul>
    </div>

    <div id="content-container">
        <!-- 컨텐츠가 여기에 동적으로 로드될 것입니다. -->
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>