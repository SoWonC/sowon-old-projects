<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="/css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<c:if test="${boardsuccess eq 'yes'}">
     <script>
      alert("게시물 등록이 완료되었습니다!")
     </script>
   </c:if>
	<div class="wrapper">
		<div class="title-text">
			<div class="title board">게시판</div>
		</div>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>태그</td>
				<td>작성일자</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.ly_board_no}</td>
					<td>${dto.nickname}</td>
					<!--<td><a href="view?ly_board_no=${dto.ly_board_no}">${dto.ly_title}</a></td>-->
					<td><a href="#" class="atag" class="view-link" data-board-no="${dto.ly_board_no}">${dto.ly_title}</a></td>
					<td>${dto.tag_name}</td>
					<td>${dto.ly_boardregdate}</td>
					<td>${dto.ly_hits}</td>
					<!-- <td><a href="delete?id=${dto.ly_board_no}">X</a></td> -->
				</tr>
			</c:forEach>
			
		</table>
		<a href="#" id="write-link">[게시글쓰기]</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>