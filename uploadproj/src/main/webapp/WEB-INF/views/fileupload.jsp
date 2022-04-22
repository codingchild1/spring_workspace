<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="/fileupload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit" value="업로드"/>
	</form>
	
</div>
</body>
</html>