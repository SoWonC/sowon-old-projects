<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.register" /></title>
</head>
<body>
<h1>LylicsKeeper</h1>
    <h2><spring:message code="user.info" /></h2>
    <form:form action="step3" modelAttribute="registerRequest">
    <p>
        <label><spring:message code="id" />:<br>
        <form:input path="id" />
        <form:errors path="id"/>
        </label>
    </p>
    <p>
        <label><spring:message code="name" />:<br>
        <form:input path="name" />
        <form:errors path="name"/>
        </label>
    </p>
    <p>
        <label><spring:message code="nickname" />:<br>
        <form:input path="nickname" />
        <form:errors path="nickname"/>
        </label>
    </p>
    <p>
        <label><spring:message code="phone" />:<br>
        <form:input path="phone" />
        <form:errors path="phone"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password.confirm" />:<br>
        <form:password path="confirmPassword" />
        <form:errors path="confirmPassword"/>
        </label>
    </p>
    <input type="submit" value="<spring:message code="register.btn" />">
    </form:form>
</body>
</html>
