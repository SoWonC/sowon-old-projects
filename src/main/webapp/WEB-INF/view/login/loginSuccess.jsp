<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <p>
        <spring:message code="login.done" />
        작사가 <${authInfo.nickname}>님, 환영합니다.
    </p>
    
    <p>
        <a href="<c:url value='/main'/>">
            [<spring:message code="go.main" />]
        </a>
    </p>
</body>
</html>
