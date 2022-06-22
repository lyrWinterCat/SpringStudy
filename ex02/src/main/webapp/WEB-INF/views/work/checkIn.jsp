<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크인</title>
</head>
<body>
<form action="/getToWork" name="checkInForm">
	<input type="text" name="name"> <br>
	<button>출근</button>
	<button type="button">퇴근</button>
</form>

<script>
	let form = checkInForm;
	let button = document.querySelector("button[type='button']");
	form.setAttribute("action","/getToWork");
	button.addEventListener("click",function(){
		form.setAttribute("action","/leaveWork");
		form.submit();
		
	})
	//console.log(form.getAttribute("action"));

</script>

</body>
</html>