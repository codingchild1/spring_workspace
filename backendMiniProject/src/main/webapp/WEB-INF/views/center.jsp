<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>고객센터</title>
    <style>
        .container1 {
            width: 100%;
            height: 950px;
            background: #E5F2FF;
            background-size: 100%;
            background-repeat: no-repeat;
        }
        .register {
            position: absolute;
            left: 50%;
            top: 55%;
            transform: translate(-50%, -50%);
            padding: 8px 8px;
            color: #2b2e4a;
        }
        .head {
            margin-top: 146px;
            margin-bottom: 40px;
            font-size: 56px;
            font-weight: 700;
            line-height: 130%;
            color: #333d4b;
            text-align: center;
        }
        .d1 {
            display: flex;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
            margin-bottom: 35px;
        }
        .d2 {
            display: flex;
            justify-content: center;
            width: 200px;
            height: 90px;
            border-radius: 6px;
        }
        .d3 {
            display: flex;
            flex-direction: column;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
        }
        .s1 {
            font-size: 17px;
            font-weight: 400;
            line-height: 150%;
            color: rgba(0, 19, 43, 0.58);
        }
        .s2 {
            display: flex;
            align-items: center;
            font-size: 26px;
            font-weight: 700;
            line-height: 150%;
            color: rgba(3, 18, 40, 0.7);
        }
        .l {
            width: 1px;
            height: 54px;
            margin: 0 18px;
            background-color: rgba(0, 27, 55, 0.1);
        }
        .d4 {
            display: flex;
            -webkit-box-align: center;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
            width: 200px;
            height: 90px;
            border-radius: 6px;
        }
        .d5 {
            display: flex;
            flex-direction: column;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
        }
        .s3 {
            font-size: 17px;
            font-weight: 400;
            line-height: 150%;
            color: rgba(0, 19, 43, 0.58);
        }
        .s4 {
            display: flex;
            -webkit-box-align: center;
            align-items: center;
            font-size: 26px;
            font-weight: 700;
            line-height: 150%;
            color: rgba(3, 18, 40, 0.7);
        }
    </style>
</head>
<body>
    <div class="container5">
        <div class="register">
            <h1 class="head">멀캠 고객센터에서<br>
                24시간 상담받을 수 있어요!</h1>
            <div class="d1">
                <div class="d2">
                    <div class="d3">
                        <span class="s1">피해・사기 상담</span>
                        <span class="s2">1234-5678</span>
                    </div>
                </div>
                <div class="l"></div>
                <div class="d4">
                    <div class="d5">
                        <span class="s3">일반 상담</span>
                        <span class="s4">1234-6789</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>