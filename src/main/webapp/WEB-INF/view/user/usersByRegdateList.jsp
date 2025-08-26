<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<style>
h1 {
	text-align: center;
	background-color: gray;
	color: #fff;
	padding: 10px;
	margin: 0;
}

.Users {
	width: 100%;
	border-collapse: collapse;
	border-spacing: 0;
	margin-bottom: 20px;
}

.Users th, .Users td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.Users th {
	background-color: #f2f2f2;
	font-weight: bold;
}

.Users tr:nth-child(even) {
	background-color: #f2f2f2;
}

.Users tr:hover {
	background-color: #ddd;
}

.Users h {
	margin: 0;
	padding: 5px;
	font-weight: normal;
}

.Users tf:formatDateTime {
	font-style: italic;
}
</style>

<style>
form {
	width: 300px;
	margin: 0 auto;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

input[type="text"] {
	width: 100%;
	padding: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.error-message {
	color: red;
	font-size: 14px;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>


<body>
	<h1>LylicsKeeper</h1>
	<form:form modelAttribute="searchByRegdate">
		<p>
			<label>from<form:input path="from" /></label> <br />
			<form:errors path="from" />
			<br /> <label>to<form:input path="to" /></label> <br />
			<form:errors path="to" />
			<br /> <input type="submit" value="조회">
		</p>
	</form:form>


	<c:if test="${! empty usersByRegdate}">
		<table class=Users>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>전화번호</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="user" items="${usersByRegdate}">
				<tr>
					<td><a href="<c:url value='/users/${user.id}'/>">${user.id}</a></td>
					<td>${user.name}</td>
					<td>${user.nickname}</td>
					<td>${user.phone}</td>
					<td><tf:formatDateTime value="${user.registerDateTime}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			

		</table>
	</c:if>




</body>
</html>