<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$("#checkJson1").click(function() {
			let article={articleNo:"114", writer:"박지성", title:"안녕하세요", content:"상품 소개 글입니다."};
			$.ajax({
				type:"POST",
				url:"http://localhost:8090/boards",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(article),
				success: function(data, statusText) {
					alert(data);
				},
				error: function(data, statusText) {
					alert("에러 발생");
				},
				complete: function(data, statusText) {}
			});
		});
		
		$("#checkJson2").click(function() {
			$.ajax({
				type:"GET",
				url:"http://localhost:8090/boards/115",
				success: function(data, statusText) {
					console.log(data);
					alert(JSON.stringify(data));
				},
				error: function(data, statusText) {
					alert("에러 발생");
				},
				complete: function(data, statusText) {}
			});
		});
		
		$("#checkJson3").click(function() {
			let article={articleNo:"114", writer:"박지성", title:"날쌘들이의 일상", content:"축구와 늘 함께합니다."};
			$.ajax({
				type:"PUT",
				url:"http://localhost:8090/boards/114",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(article),
				success: function(data, statusText) {
					alert(JSON.stringify(data));
				},
				error: function(data, statusText) {
					alert("에러 발생");
				},
				complete: function(data, statusText) {}
			});
		});
		
		$("#checkJson4").click(function() {
			$.ajax({
				type:"DELETE",
				url:"http://localhost:8090/boards/114",
				contentType:"application/json; charset=utf-8",
				success: function(data, statusText) {
					alert(JSON.stringify(data));
				},
				error: function(data, statusText) {
					alert("에러 발생");
				},
				complete: function(data, statusText) {}
			});
		});
	});

</script>
</head>
<body>
	<input type="button" id="checkJson1" value="새글 쓰기"><br><br>
	<input type="button" id="checkJson2" value="조회"><br><br>
	<input type="button" id="checkJson3" value="수정"><br><br>
	<input type="button" id="checkJson4" value="삭제"><br><br>
	<div id="output"></div>
</body>
</html>