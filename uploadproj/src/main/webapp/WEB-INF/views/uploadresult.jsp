<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일이 업로드 되었습니다.</h3>
<c:choose>
	<c:when test="test=${fn:startWith(file.originalFilename.'http) }}">
		<img src="${file.originalFilename}"/>
	</c:when>
	<c:otherwise>
		<img src="/fileview/board/${file.originalFilename}"/>
	</c:otherwise>
</c:choose>
<span><a href="/filedownload?filename=${file.originalFilename}">${file.originalFilename }</a></span><br>
<span>${file.contentType }</span>
</body>
</html>