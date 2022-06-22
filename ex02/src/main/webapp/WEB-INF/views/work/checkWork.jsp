<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Date nowTime=new Date();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goWork(f){
		f.action="is_late"
		f.submit();
	}
	
	function goHome(f){
		f.action="is_ok"
		f.submit();
	}

</script>
</head>
<body>
<form>
	<input type="text" name="name" placeholder="이름을 입력하세요">
	<input type="button" value="출근" onclick="goWork(this.form)">
	<input type="button" value="퇴근" onclick="goHome(this.form)">

</form>

</body>
</html>