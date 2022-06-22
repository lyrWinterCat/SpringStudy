<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f){
		f.action="change"
		f.submit();
	}

</script>

</head>
<body>
<form method="post">
	<table border="1">
	<caption>:::상품 목록:::</caption>
		<tr>
			<th>선택</th>
			<th>상품명</th>
			<th>가격</th>
		</tr>
		<tr>
			<td><input type="radio" name="check" value="오징어땅콩 1500"></td>
			<td>오징어땅콩</td>
			<td>1500</td>		
		</tr>
		<tr>
			<td><input type="radio" name="check" value="벌집핏자 2000"></td>
			<td>벌집핏자</td>
			<td>2000</td>		
		</tr>
		<tr>
			<td><input type="radio" name="check" value="초코우유 1100"></td>
			<td>초코우유</td>
			<td>1100</td>		
		</tr>
		<tr>
			<td><input type="radio" name="check" value="샌드위치 2300"></td>
			<td>샌드위치</td>
			<td>2300</td>		
		</tr>
		<tr>
			<td colspan="3">
			<input type="radio" name="sale" value="90">10%
			<input type="radio" name="sale" value="70">30%
			<input type="radio" name="sale" value="40">60%
			<input type="radio" name="sale" value="10">90%
			</td>
		</tr>	
		<tr>
		<td colspan="3">
			<input type="button" value="전송" onclick="send(this.form)">
		</td>
		</tr>
	</table>
</form>

</body>
</html>