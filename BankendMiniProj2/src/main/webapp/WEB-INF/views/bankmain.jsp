<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멀캠은행</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    .fakeimg {
      height: 200px;
      background: #aaa;
    }
  </style>

</head>
<body>
 <div class="p-5 bg-primary text-white text-center">
    <h1>멀캠은행</h1>
  </div>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" href="accmenu?cpage=makeaccount">계좌개설</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="accmenu?cpage=deposit">입금</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="accmenu?cpage=withdraw">출금</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="accmenu?cpage=accinfo">계좌조회</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="accmenu?cpage=allaccinfo">전체계좌조회</a>
        </li>
      </ul>

      <ul class="navbar-nav" style="justify-content: right;">
        <li class="nav-item">
          <c:choose>
          	<c:when test="${empty id }">
	            <a class="nav-link" href="memmenu?cpage=login">로그인</a>
          	</c:when>
          	<c:otherwise>
          		<a class="nav-link" href="logout">로그아웃</a>
          	</c:otherwise>
          </c:choose>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="join" href="memmenu?cpage=join">회원가입</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container mt-3" style="width:100%;height:500px;align-content: center;">
  	<jsp:include page='${cpage }.jsp'/>

  </div>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
    $('a').click(function () {
      $('a').removeClass('active');
      $(this).addClass('active');
    });
  </script>

</body>
</html>