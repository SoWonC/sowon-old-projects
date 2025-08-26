<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.register" /></title>
</head>
<body>
<h1>LylicsKeeper</h1>
    <p>
        <spring:message code="register.done">
        	<spring:argument value="${registerRequest.nickname}" />
        </spring:message>
    </p>
    <p>
        <a href="<c:url value='/main'/>">
            [<spring:message code="go.main" />]
        </a>
    </p>
</body>
</html>
