<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적용된 항목</title>
</head>
<body>
<table border="1" style="margin:0 auto;">
	<tr>
		<th>상품 번호</th>
		<th>상품명</th>
		<th>상품 원가</th>
		<th>상품 가격</th>
		<th>적용된 할인율</th>
	</tr>
	<tr>
		<td><c:out value="${product.productNumber}"></c:out></td>
		<td><c:out value="${product.productName}"></c:out></td>
		<td><c:out value="${originPrice}원"></c:out></td>
		<td><c:out value="${product.productPrice}원"></c:out></td>
		<td><c:out value="${product.discountRate}%"></c:out></td>
	</tr>
</table>
<form action="/usePoint" method="post" name="discountForm">
	<input type="hidden" name="productNumber" value="${product.productNumber}">
	<input type="hidden" name="productPrice" value="${product.productPrice}">
	<input type="submit" value="포인트를 사용하여 상품 구매하러 가기" style="display:block; margin:0 auto;">
</form>
<br>
<input type="button" onclick="location.href='/sale'" value="상품 및 할인율 변경하기" style="display:block; margin:0 auto;">

</body>
</html>