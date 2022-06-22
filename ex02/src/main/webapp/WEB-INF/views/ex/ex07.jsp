<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex07</title>
</head>
<body>
	<c:set var="total" value="${studentVO.kor+studentVO.eng+studentVO.math}"/>
	<c:set var="avg" value="${total/3}"/>

<h1>Ex07</h1>
	<table border="1">
	<tr>
		<th>번호</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	<tr>
		<td><c:out value="${studentVO.num }"></c:out></td>
		<td><c:out value="${studentVO.kor }"></c:out></td>
		<td><c:out value="${studentVO.eng}"></c:out></td>
		<td><c:out value="${studentVO.math}"></c:out></td>
		<td><c:out value="${total}점"></c:out></td>
		<td><c:out value="${avg}점"></c:out></td>
		
	</tr>

	</table>

</body>
</html>