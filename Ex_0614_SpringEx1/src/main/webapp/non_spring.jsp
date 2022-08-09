<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//기존방식
	//1. 기본생성자 + setter
	PersonVO p1 = new PersonVO();
	p1.setName("홍길동");
	p1.setAge(30);
	p1.setTel("010-111-1111");
	
	//2. 오버로드된 생성자 사용
	PersonVO p2 = new PersonVO("김길동",32,"010-222-2222");
	
	//body에서 el표기법으로 출력하기 위해 request영역에 바인딩
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> ${p1.name } / ${p1.age } / ${p1.tel }</p>
	<p> ${p2.name } / ${p2.age } / ${p2.tel }</p>
</body>
</html>