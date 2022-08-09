<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
<caption>:::사원 목록:::</caption>
<tr>
	<th>사원 번호</th>
	<th>이름</th>
	<th>부서 번호</th>
	<th>직종</th>
	<th>입사 날짜</th>
</tr>
<c:forEach var="vo" items="${list}">
<tr>
	<td>${vo.sabun}</td>
	<td>${vo.saname}</td>
	<td>${vo.deptno}</td>
	<td>${vo.sajob}</td>
	<td>${vo.sahire}</td>
	</tr>
</c:forEach>


</table>

</body>
</html>