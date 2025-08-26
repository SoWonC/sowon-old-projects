<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
</head>

<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        
        h1 {
    text-align: center;
    background-color: gray;
    color: #fff;
    padding: 10px;
    margin: 0;
}

        p {
            margin: 10px 0;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }

        a:hover {
            text-decoration: underline;
        }

        .welcome-message {
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            margin-top: 50px;
        }

        .user-info {
            text-align: center;
        }

        .user-info a {
            display: block;
            margin-top: 10px;
        }

        .user-info a:last-child {
            margin-top: 20px;
        }
    </style>
    
<body>
<h1>LylicsKeeper</h1>
    <c:if test="${empty authInfo}">
    <p>환영합니다.</p>
    <p>
        <a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
        <a href="<c:url value="/login" />">[로그인]</a>
    </p>
    </c:if>
    
    <c:if test="${! empty authInfo}">
    <p>작사가 ${authInfo.nickname}님, 환영합니다.</p>
    
    <p>
        <a href="<c:url value="/edit/changePassword" />">[비밀번호 변경]</a>
        <a href="<c:url value="/logout" />">[로그아웃]</a><br/>
        <a href="<c:url value="/show/myPage" />">[마이페이지]</a>
        <a href="<c:url value="/users" />">[회원 검색]</a>
   		<a href="<c:url value="secure/boardMain" />">[작사 게시판]</a>
   		<a href="<c:url value="/com/list" />">[커뮤니티]</a>
    </p>
    
    </c:if>
</body>
</html>
