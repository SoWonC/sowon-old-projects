<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보</title>
</head>
<style>
h1 {
	text-align: center;
	background-color: gray;
	color: #fff;
	padding: 10px;
	margin: 0;
}

.checkByUser {
	width: 100%;
	border-collapse: collapse;
	border-spacing: 0;
	margin-bottom: 20px;
}

.checkByUser th, .checkByUser td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.checkByUser th {
	background-color: #f2f2f2;
	font-weight: bold;
}

.checkByUser tr:nth-child(even) {
	background-color: #f2f2f2;
}

.checkByUser tr:hover {
	background-color: #ddd;
}

.checkByUser h {
	margin: 0;
	padding: 5px;
	font-weight: normal;
}

.checkByUser tf:formatDateTime {
	font-style: italic;
}
</style>
<body>

	<h1>LylicsKeeper</h1>
	<table class=checkByUser>
		<tr>
			<th>아이디: ${user.id}</th>
		</tr>
		<tr>
			<th>이름: ${user.name}</th>
		</tr>
		<tr>
			<th>닉네임: ${user.nickname}</th>
		</tr>
		<tr>
			<th>전화번호: ${user.phone}</th>
		</tr>
		<tr>
			<th>가입일: <tf:formatDateTime value="${user.registerDateTime}"
					pattern="yyyy-MM-dd HH:mm" />
			</th>
		</tr>
	</table>
</body>
</html>