<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br> 제목 : ${dto.title} 작성자 : ${dto.nickname} 작성시간:
	${dto.boardregdate}
	<c:if test="${authInfo.nickname == dto.nickname}">
    <a href="update?number=${dto.number}">[게시글수정]</a>
    <a href="delete?number=${dto.number}">[게시글삭제]</a>
	</c:if>
	<hr>
	내용보기
	<br>
	<hr>
	내용 : ${dto.content}
	<br>
	<p>	<a href="/com/list">리스트 화면으로 돌아가기</a></p>
	<p>	<a href="/">홈화면으로 돌아가기</a></p>
</body>
</html>