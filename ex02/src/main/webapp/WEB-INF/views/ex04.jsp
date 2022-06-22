<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex04</title>
</head>
<body>
	<h1>Ex04</h1>
	<table>
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<tr>
		<td><c:out value="${infoDTO.name }"></c:out></td>
		<td><c:out value="${infoDTO.name }"></c:out></td>
		
	</tr>

	</table>

</body>
</html>