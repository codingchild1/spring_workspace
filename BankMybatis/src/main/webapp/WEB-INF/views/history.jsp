<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>íėŽėę°</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
            list-style: none;
        }
        .container1 {
            width: 100%;
            height: 2000px;
            background: #E5F2FF;
            background-size: 940px;
            background-repeat: no-repeat;
        }
        .d1 {
            position: absolute;
            max-width: 900px;
            top: 35%;
            left: 28%;

        }
        .history {
            position: absolute;
            top: 120%;
            left: 35%;
            margin: 0;

        }
        .d2 {
            left: 30%;
            transform: translateY(0px);
            opacity: 1;
        }
        .s1 {
            display: block;
            margin-bottom: 25px;
            font-size: 38px;
            font-style: normal;
            font-weight: bold;
            font-stretch: normal;
            line-height: 52px;
            color: #333d4b;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .d3 {
            display: inline-flex;
            flex-direction: column;
            width: 400px;
            margin-top: 51px;
        }
        .s2 {
            margin-bottom: 9px;
            font-size: 21px;
            font-style: normal;
            font-weight: normal;
            font-stretch: normal;
            line-height: 26.29px;
            color: rgba(0, 19, 43, 0.58);
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .s3 {
            font-size: 64px;
            font-style: normal;
            font-weight: bold;
            font-stretch: normal;
            line-height: 80.13px;
            color: #333d4b;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .d4 {
            display: inline-flex;
            flex-direction: column;
            width: 400px;
            margin-top: 51px;
        }
        .s4 {
            margin-bottom: 9px;
            font-size: 21px;
            font-style: normal;
            font-weight: normal;
            font-stretch: normal;
            line-height: 26.29px;
            color: rgba(0, 19, 43, 0.58);
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .s5 {
            font-size: 64px;
            font-style: normal;
            font-weight: bold;
            font-stretch: normal;
            line-height: 80.13px;
            color: #333d4b;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .d5 {
            display: inline-flex;
            flex-direction: column;
            width: 400px;
            margin-top: 51px;
        }
        .s6 {
            margin-bottom: 9px;
            font-size: 21px;
            font-style: normal;
            font-weight: normal;
            font-stretch: normal;
            line-height: 26.29px;
            color: rgba(0, 19, 43, 0.58);
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .s7 {
            font-size: 64px;
            font-style: normal;
            font-weight: bold;
            font-stretch: normal;
            line-height: 80.13px;
            color: #333d4b;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .d6 {
            display: inline-flex;
            flex-direction: column;
            width: 400px;
            margin-top: 51px;
        }
        .s8 {
            margin-bottom: 9px;
            font-size: 21px;
            font-style: normal;
            font-weight: normal;
            font-stretch: normal;
            line-height: 26.29px;
            color: rgba(0, 19, 43, 0.58);
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .s9 {
            font-size: 64px;
            font-style: normal;
            font-weight: bold;
            font-stretch: normal;
            line-height: 80.13px;
            color: #333d4b;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .s10 {
            display: block;
            margin-top: 36.26px;
            font-size: 14px;
            font-style: normal;
            font-weight: normal;
            font-stretch: normal;
            line-height: 20px;
            color: #6b7684;
            letter-spacing: normal;
            word-break: keep-all;
            -webkit-font-smoothing: subpixel-antialiased;
        }
        .history h2 {
            position: relative;
            font-size: 32px;
            color: #333d4b;
            line-height: 1;
        }
        .history h2:before {
            content: "";
            position: absolute;
            left: -48px;
            top: 50%;
            width: 17px;
            height: 17px;
            border-radius: 100%;
            background: #E5F2FF;
            border: 3px solid #333d4b;
            transform: translateY(-50%);
            box-sizing: border-box;
        }
        .history div {
            position: relative;
            padding: 0 0 0 48px;
        }
        .history div:before {
            content: "";
            position: absolute;
            left: 8px;
            top: 0;
            width: 2px;
            height: 100%;
            background: #333d4b;
        }
        .history div:first-child:before {
            top: 10px;
            height: calc(100% - 10px);
        }
        .history ol {
            padding: 20px 0 74px;
            margin-bottom:0px;
        }
        .history li {
            font-size: 17px;
            color: #333d4b;
            line-height: 29px;
        }
    </style>
</head>
<body>
    <div class="container5">
        <div class="d1">
            <div>
                <div class="d2">
                    <span class="s1">ëģíëĨž ėīë§íë ėŽëëĪėī ëŠĻėŽ,<br> ė­ėŽė ëĻėë§í ëģíëĨž ë§ë­ëëĪ.</span>
                    <div class="d3">
                        <span class="s2">ëė  ę°ėė ė</span>
                        <span class="s3"> 1,500ë§ +</span>
                    </div>
                    <div class="d4">
                        <span class="s4">ëė  íŽėęļėĄ</span>
                        <span class="s5">900ėĩ ė +</span>
                    </div>
                    <div class="d5">
                        <span class="s6">ė ėēī íė ė</span>
                        <span class="s7">500ëŠ +</span>
                    </div>
                    <div class="d6">
                        <span class="s8">ėķė ėëđėĪ ė</span>
                        <span class="s9">20ę° +</span>
                    </div>
                    <span class="s10">
                        2021ë 11ė
                        <!--  -->
                        ęļ°ėĪ
                    </span>
                </div>
            </div>
        </div>
    </div>
    <div class="history">
        <div>
            <h2>2021</h2>
            <ol>
                <li>ėę° íėą ėŽėĐė 1,000ë§ëŠ ëí</li>
                <li>ė ėĄęļėĄ 1ėĄ°, ëė  ėĄęļėĄ 10ėĄ° ëí</li>
                <li>420ėĩ ė íŽė ė ėđ</li>
                <li>ëĐėš ėđīë ėķė</li>
                <li>ęģ ę° ížíī ė ėĄ ėąėė  ėí</li>
            </ol>
        </div>
        <div>
            <h2>2020</h2>
            <ol>
                <li>ėļęģ 100ë íííŽ ęļ°ė ėĪ 35ė ė ė </li>
                <li>ęģžíęļ°ė ė ëģīíĩė ëķ ėĢžė·Ļ 2018ė ëģīëģīíļëė ėė</li>
                <li>300ėĩ ė íŽė ė ėđ</li>
                <li>ëė  ėĄęļėĄ 1ėĄ° ė ëí</li>
            </ol>
        </div>
        <div>
            <h2>2019</h2>
            <ol>
                <li>ę°íļ ėĄęļ ėëđėĪ ėķė</li>
                <li>50ėĩ ė íŽė ė ėđ</li>
                <li>ëĐėš  ėíęķ ëąëĄ</li>
            </ol>
        </div>
    </div>
</body>
</html>