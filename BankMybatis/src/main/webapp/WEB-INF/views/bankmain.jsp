<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>멀캠은행</title>
   <link rel="stylesheet" type="text/css" href="css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
    <style>
/* 	.container1 .header .nav1 .login {
		color:#3182f6; 
		font-size: 17px;
	} */

    </style>
</head>
<body>
    <div class="container1">
        <div class="header">
            <h1><a href="/">MK bank</a></h1>
            <div class="nav1">
                <ul>
                    <li><a href="history">은행소개</a></li>
                    <li><a>조회</a>
                        <div>
                            <div class="con1">
                                <ul class="row1">
                                    <li class="cell"><a href="accmenu?cpage=accinfo" class="block">일반계좌조회 </a><span
                                            class="icon-1"></span></li>
                                    <li class="cell"><a href="allaccountinfo" class="block">전체계좌조회 </a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a>이체</a>
                        <div>
                            <div class="con1">
                                <ul class="row1">
                                    <li class="cell"><a href="accmenu?cpage=deposit" class="block">입금하기 </a></li>
                                    <li class="cell"><a href="accmenu?cpage=withdraw" class="block">출금하기 </a><span
                                            class="icon-1"></span></li>
                                    <li class="cell"><a href="accmenu?cpage=transfer" class="block">이체하기</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a href="center">고객센터</a></li>
                    <li class="login" style="color:#3182f6; font-size: 17px;">
                        <c:choose>
                            <c:when test="${empty id }">
                              <a href="memmenu?cpage=login">로그인</a>
                            </c:when>
                            <c:otherwise>
                                <a href="logout">로그아웃</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </div>
        </div>
    </div>

        <jsp:include page='${cpage }.jsp'/>

</body>
</html>