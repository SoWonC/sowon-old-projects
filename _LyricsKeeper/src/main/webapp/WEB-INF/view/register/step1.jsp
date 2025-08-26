<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.register" /></title>
</head>
<body>
<h1>LylicsKeeper</h1>
    <h2><spring:message code="LyricsKeeper.term" /></h2>
    <p>오픈 가사 등록 회원 약관에 동의 하시겠습니까?</p>
    <form action="step2" method="post">
    <label>
        <input type="checkbox" name="agree" value="true"> 
        <spring:message code="term.agree" />
    </label>
    <input type="submit" value="<spring:message code="next.btn" />" />
    </form>
</body>
</html>
