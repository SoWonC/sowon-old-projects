<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<div class="board">
		<div class="board-screen">
			<div class="app-title">
				<h1>해당 게시글 수정</h1>
			</div>
			<form>
				<input type="hidden" name="ly_board_no" value="${dto.ly_board_no}">
				<p>
					번호:<br />${dto.ly_board_no}
				</p>
				<p>
					제목:<br /> <input type="text" name="ly_title" value="${dto.ly_title}">
					<c:if test="${errors.ly_title}">제목을 입력하세요.</c:if>
				</p>
				
				<c:forEach var="thema" items="${thema}">
   					
      				<input type="radio" class="btn-check" name="tag_name" id="thema_${thema.tag_name}" value="${thema.tag_name}">
        			<label class="<%--btn btn-secondary--%>btn btn-outline-primary" for="thema_${thema.tag_name}">	${thema.tag_name}
    				</label><br/>
				</c:forEach>	
				
				<p>
					내용:<br />
					<textarea name="ly_content" rows="5" cols="30">${dto.ly_content}</textarea>
				</p>
				<input type="submit" id="modify-button" value="글 수정">
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>