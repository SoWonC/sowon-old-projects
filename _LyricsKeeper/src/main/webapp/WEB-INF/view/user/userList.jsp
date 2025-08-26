<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
    <h1>LylicsKeeper</h1>
    <table class=UserList>
        <!-- 테이블 헤더 -->
        <tr>
            <th>id</th>
            <th>이름</th>
            <th>닉네임</th>
            <th>전화번호</th>
            <th>가입날짜</th>
        </tr>
        
        <!-- 사용자 목록을 반복하여 표시 -->
        <c:forEach var="user" items="${userPage.user}">
            <tr>
                <!-- 사용자의 id를 링크로 연결 -->
                <td><a href="<c:url value='/users/${user.id}'/>">${user.id}</a></td>
                <td>${user.name}</td>
                <td>${user.nickname}</td>
                <td>${user.phone}</td>
                <td>${user.registerDateTime}</td>
            </tr>
        </c:forEach>
        
        <!-- 페이지 네비게이션 표시 -->
        <c:if test="${userPage.hasUser()}">
            <tr>
                <td colspan="10">
                    <!-- 이전 페이지로 이동하는 링크 -->
                    <c:if test="${userPage.startPage > 1}">
                        <a href="users?pageNo=${userPage.startPage - 1}">[이전]</a>
                    </c:if>
                    
                    <!-- 페이지 번호를 반복하여 표시 -->
                    <c:forEach var="pNo" begin="${userPage.startPage}" end="${userPage.endPage}">
                        <c:choose>
                            <!-- 현재 페이지를 강조 표시 -->
                            <c:when test="${pNo == userPage.currentPage}">
                                <strong>${pNo}</strong>
                            </c:when>
                            <!-- 다른 페이지로 이동하는 링크 -->
                            <c:otherwise>
                                <a href="users?pageNo=${pNo}">${pNo}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <!-- 다음 페이지로 이동하는 링크 -->
                    <c:if test="${userPage.endPage < userPage.totalPages}">
                        <a href="users?pageNo=${userPage.endPage + 1}">[다음]</a>
                    </c:if>
                </td>
            </tr>
        </c:if>
    </table>
    
    <!-- 가입날짜로 회원 검색 링크 -->
    <a href="<c:url value="/users/regdate" />">[가입날짜로 회원 검색]</a>

</body>
</html>
