<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send1(f){
		var name=f.name.value;
		var age=f.age.value;
		var tel = f.tel.value;
		
		//과제 : 유효성검사
		if(!f.name.value){
			alert("이름을 적어주세요");
			return;
		}
		if(!f.age.value){
			alert("나이를 적어주세요");
			return;
		}
		if(!f.tel.value){
			alert("전화번호를 적어주세요");
			return;
		}
		
		f.action="insert1.do"
		f.method="POST";
		f.submit();	
	}
	
	function send2(f){
		var name=f.name.value;
		var age=f.age.value;
		var tel = f.tel.value;
		
		if(!f.name.value){
			alert("이름을 적어주세요");
			return;
		}
		if(!f.age.value){
			alert("나이를 적어주세요");
			return;
		}
		if(!f.tel.value){
			alert("전화번호를 적어주세요");
			return;
		}		

		f.action="insert2.do";
		//f.method="POST";
		f.submit();
	}


</script>
</head>
<body>
<form>
	<table border="1" align="center">
		<caption>:::개인정보 입력:::</caption>
		<tr>
			<th>이름</th>
			<td><input name="name"></td>		
		</tr>
		<tr>
			<th>나이</th>
			<td><input name="age"></td>		
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input name="tel"></td>		
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="낱개로 받기" onclick="send1(this.form);">	
				<input type="button" value="객체로 받기" onclick="send2(this.form);">	
			</td>		
		</tr>	
	</table>
</form>
</body>
</html>