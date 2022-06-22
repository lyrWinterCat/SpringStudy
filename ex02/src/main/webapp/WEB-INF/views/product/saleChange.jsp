<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세일 항목 변경</title>
</head>
<body>
	<form action="/change" method="post">
	<input type="hidden" name="productName">
	<input type="hidden" name="productPrice">
	<input type="hidden" name="discountRate">
		<table border="1" style="margin:0 auto;">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="1"></td>
				<td>오징어 땅콩</td>
				<td>3500</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="2"></td>
				<td>초코우유</td>
				<td>1500</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="3"></td>
				<td>벌집핏자</td>
				<td>2500</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="4"></td>
				<td>샌드위치</td>
				<td>4500</td>
			</tr>
		</table>
		<br>
		<div style="text-align:center">
			<button class="rate" type="button"data-rate="10">10%</button>
			<button class="rate" type="button"data-rate="30">30%</button>
			<button class="rate" type="button"data-rate="60">60%</button>
			<button class="rate" type="button"data-rate="90">90%</button>
			<button style="display:block; margin:10px auto; width:188px;">적용</button>
		</div>	
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- jquery 검색 >> 최신버전클릭 >> Download the compressed, production jQuery 3.6.0 클릭
>> 나오는 http 주소 복붙 해서 script로 넣어주기 -->
<script>
	let $temp;
 	$("button.rate").click(function(e){
 		if($temp){
 			$temp.css("color","black")
 		}
 		
		$temp=$(this);
	 	$(this).css("color","red");
	 	$("input[name='discountRate']").val($(this).data("rate"));
 });

 	// button을 클릭하지 않았을 시 (기본상태) : 폰트 색이 검정
 	// this 이벤트를 받은 버튼(클릭된 버튼) : 폰트 색이 빨강
 	
 	$("input[name='productNumber']").click(function(){
 		const tdTags=$(this).closest("tr").children();
 		
 		$("input[name='productName']").val($(tdTags[1]).text());
 		$("input[name='productPrice']").val($(tdTags[2]).text());
 	});

</script>
</html>