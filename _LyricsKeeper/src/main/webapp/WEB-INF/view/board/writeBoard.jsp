<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>New Board Write</title>
</head>
<body style="margin: 8px;">
	<div class="wrapper">
		<div class="title-text">
			<div class="title writeboard">Lyrics Write</div>
		</div>
		<div class="form-container">
			<form>
				<p>
					제목:<br /> <input type="text"  name="ly_title" placeholder="제목을 입력하세요." value="${ly_board.ly_title}"
						style="width: 225px;" required>
				</p>
					<div id="titleError"></div>
				<c:forEach var="thema" items="${thema}">
   					
      				<input type="radio" class="btn-check" name="tag_name" id="thema_${thema.tag_name}" value="${thema.tag_name}">
        			<label class="<%--btn btn-secondary--%>btn btn-outline-primary" for="thema_${thema.tag_name}">	${thema.tag_name}
    				</label><br/>
				</c:forEach>
				<div id="tagError"></div>	
				<p>
					내용:<br />
					<textarea name="ly_content" rows="5" cols="30" placeholder="내용을 입력하세요." required></textarea>
				</p>
				<div id="contentError"></div>
				
				<input type="hidden" name="nickname" value="${authInfo.nickname}" /> <!-- 세션에서 가져온 사용자 정보를 hidden 필드에 할당 -->
				<input type="hidden" name="id" value="${authInfo.id}" /> <!-- 세션에서 가져온 사용자 정보를 hidden 필드에 할당 -->
				<input type="submit" id="write1-button" value="새 글 등록">
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>