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
	안녕하세용<br>
	현재 아이피는 ${ip} 입니다.
		<h1>:::과일 목록:::</h1>
	<c:forEach var="fruit" items="${msg}">
	<ul>
		<li>
			${fruit}
		</li>
	</ul>
	</c:forEach>

</body>
</html>