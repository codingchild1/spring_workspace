<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    --%>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>멀캠은행</title>
    <link href="${path}/resources/css/style.css" rel="stylesheet"/> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container1 {
            width: 100%;
            height: 900px;
            background:
            linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.363)),
            /* linear-gradient(rgba(0, 0, 0, 0),rgba(0,0,0,0.685)), */
            url(images/toss-im-web-intro-still-start.jpg);
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <div class="container1">
        <div class="header">
            <h1><a href="boot_bankmain.html">MK bank</a></h1>
            <div class="nav1">
                <ul>
                    <li><a href="boot_history.html">은행소개</a></li>
                    <li><a>조회</a>
                        <div>
                            <div class="con1">
                                <ul class="row1">
                                    <li class="cell"><a href="boot_accInfo.html" class="block">일반계좌조회 </a><span
                                            class="icon-1"></span></li>
                                    <li class="cell"><a href="boot_allAccInfo.html" class="block">전체계좌조회 </a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a>이체</a>
                        <div>
                            <div class="con1">
                                <ul class="row1">
                                    <li class="cell"><a href="boot_deposit.html" class="block">입금하기 </a></li>
                                    <li class="cell"><a href="boot_withdraw.html" class="block">출금하기 </a><span
                                            class="icon-1"></span></li>
                                    <li class="cell"><a href="boot_transfer.html" class="block">이체하기</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a href="boot_center.html">고객센터</a></li>
                    <li><b><a href="boot_login.html">로그인</a></b></li>
                </ul>
            </div>
        </div>
        <div class="hero">
            <h2 style="color: black;"><b>자산을 설계하세요</b></h2>
            <p style="color: black;">금융의 모든 것<br>멀캠뱅크에서 쉽고 간편하게</p>
            <!-- <button><b><a href="boot_makeAcc.html" class="block">계좌 만들기</a></b></button> -->
        </div>
    </div>
</body>
</html>