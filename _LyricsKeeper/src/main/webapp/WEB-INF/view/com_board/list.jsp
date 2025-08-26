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
			<td><input type="text" size="60" value="" method=""> <input
				type="submit" value="검색"></td>
		</tr>
	</table>
	<table>
		<tr>

			<form action="list" method="get">
				<input type="submit" value="최신">
			</form>
			<form action="listup" method="GET">
				<input type="submit" value="인기">
			</form>
			<form action="writeForm" method="GET">
				<input type="submit" value="글작성">
			</form>
		</tr>
	</table>
	<table width="500" cellpadding="0" cellspacing="0" border="1">

		<tr>
			
			<td>★</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>


		<c:forEach var="com" items="${com_Page.com}">
			<tr>
				<!-- 사용자의 id를 링크로 연결 -->
				<td>${com.boardregdate}</td>
				<td><a href="view?number=${com.number}">${com.title}</a></td>
				<td>${com.nickname}</td>
				<td>${com.hits}</td>

			</tr>
		</c:forEach>

		<c:if test="${com_Page.hasUser()}">
			<tr>

				<td colspan="10"><c:if test="${com_Page.currentPage >1}">
						<a href="/com/list?pageNo=${com_Page.currentPage - 1}">[이전]</a>
					</c:if> <c:forEach var="pNo" begin="${com_Page.startPage}"
						end="${com_Page.endPage}">
						<c:choose>
							<c:when test="${pNo == com_Page.currentPage}">
								<strong>${pNo}</strong>
							</c:when>
							<c:otherwise>
								<a href="/com/list?pageNo=${pNo}">${pNo}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach> <c:if test="${com_Page.currentPage < com_Page.totalPages}">
						<a href="/com/list?pageNo=${com_Page.currentPage + 1}">[다음]</a>
					</c:if></td>
			</tr>
		</c:if>
	</table>

	<p></p>

	<p>
		<a href="/">홈화면으로 돌아가기</a>
	</p>

</body>
</html>