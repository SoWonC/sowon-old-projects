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
	<input type="hidden" value="${nick}">
	<table>
		<tr>
			<td>
			<input type="text" size="60" value="">
			<input type="button"  value="검색">
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
			<input type="button"  value="최신">
			<input type="button"  value="인기">
			</td>
		</tr>
	</table>
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

	<p>
		<a href="/">홈화면으로 돌아가기</a>
	</p>

</body>
</html>