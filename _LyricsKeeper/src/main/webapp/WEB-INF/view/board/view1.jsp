<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>해당 게시물 보기</title>
</head>
<body>

해당 내용보기 <br>
<hr>
작성자 : ${dto.nickname} <br>
제목 : ${dto.ly_title} <br>
태그 : ${dto.tag_name} <br>
조회수 : ${dto.ly_hits} <br> 
내용 : ${dto.ly_content} <br>
작성일시 : ${dto.ly_boardregdate}
<hr>
<c:if test="${authInfo.id == dto.id}">
						<!--<a href="modify?ly_board_no=${dto.ly_board_no}">[게시글수정]</a>
							<a href="delete?ly_board_no=${dto.ly_board_no}">[게시글삭제]</a>  -->
							<a href="#" class="atag" class="modify-link" data-board-no="${dto.ly_board_no}">[게시글수정]</a>
							<a href="#" class="atag" class="delete-link" data-board-no="${dto.ly_board_no}">[게시글삭제]</a>
							
						</c:if>
<br>
<a href="#" class="list-link">목록보기</a>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>