<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex05</title>
</head>
<body>
<h1>Ex05</h1>
	<table border="1">
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>성별</th>
	</tr>
	<tr>
		<td><c:out value="${infoDTO.name }"></c:out></td>
		<td><c:out value="${infoDTO.age }"></c:out></td>
		<td><c:out value="${gender}"></c:out></td>
		
	</tr>

	</table>

</body>
</html>