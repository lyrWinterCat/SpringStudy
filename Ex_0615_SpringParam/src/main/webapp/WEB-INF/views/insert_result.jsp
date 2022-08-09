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
	<p>이름 : ${vo.name}</p>
	<p>나이 : ${vo.age}</p>
	<p>전화번호 : ${vo.tel}</p>
	
	<input type="button" value="돌아가기" onclick="location.href='insert_form.do'">
	<!-- 스프링에서는 jsp>jsp 이동 불가능
	반드시 컨트롤러를 거쳐서 jsp로 전환을 해 주어야 한다. -->

</body>
</html>