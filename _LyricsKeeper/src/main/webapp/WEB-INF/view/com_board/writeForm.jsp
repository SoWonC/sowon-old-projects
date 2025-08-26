<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><p>

<table width="500" cellpadding="0" cellspacing="0" border="1">
    <form action="writeForm" method="post">
    <tr>
        <td > 작성자 </td>
        <td> <p> ${authInfo.nickname}</p></td>
        <input type="hidden" name="writer" size = "100" value="${authInfo.nickname}">
    </tr>
    <tr>
        <td> 제목 </td>
        <td> <input type="text" name="title" size = "100" > </td>
    </tr>
    <tr>
        <td> 내용 </td>
        <td> <input type="text" name="content" size = "100" > </td>
    </tr>
    <tr >
        <td colspan="2"> <input type="submit" value="입력">
              &nbsp;&nbsp; <a href="list">목록보기</a></td>
    </tr>
    </form>
</table>
<p> <a href="/">홈화면으로 돌아가기</a> </p>
<p> <a href="/com/list">리스트 화면으로 돌아가기</a> </p>
</body>
</html>