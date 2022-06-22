<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form>
		<input type="text" name="number" placeholder="바코드 번호를 입력하세요">
		<input type="button" value="조회하기" onclick="send(this.form)">
	</form>
</body>
<script>
	function send(f){
		f.action="productView";
		f.submit();
	}
</script>

</html>