<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f){
		
		if(f.name.value && f.content.value && f.pwd.value){
			f.action="insert.do";
			f.submit();	
		}else{
			//alert("방명록을 작성해주세요");
			return;
		}
		/* 		
	if(!f.name.value){
		alert("이름을 입력하세요")
		return;
	}
	if(!f.content.value){
		alert("내용을 입력하세요")
		return;
	}
	if(!f.pwd.value){
		alert("비밀번호를 입력하세요")
		return;
	}
	
	f.action="insert.do";
	f.submit();	
		*/		
	}
	
</script>


</head>
<body>
<!-- get방식으로 보내면 문자열로 보낸다.(문자열>사진 변환은 할 수 없음)-->
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center" >
			<caption>:::새 글 작성하기:::</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name" placeholder="작성자 이름을 입력해주세요"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea placeholder="방명록을 작성해주세요" rows="10" cols="50" name="content" style="resize:none;" wrap="on"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password" placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<th>이미지 첨부</th>
				<td>
					<input type="file" name="photo">
				</td>
			
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="등록하기" onclick="send(this.form)">
					<input type="button" value="목록으로" onclick="location.href='list.do'">
				</td>
			</tr>	
		</table>
	</form>

</body>
</html>