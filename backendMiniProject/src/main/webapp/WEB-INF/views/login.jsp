<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
    <style>
        .container {
            width: 400px;
        }

        .input-group-text {
            display: inline-block;
            width: 130px;
        }

        .title {
            text-align: center;
            font-weight: bold;
        }
                .container1 {
            width: 100%;
            height: 950px;
            background: #E5F2FF;
            background-size: 100%;
            background-repeat: no-repeat;
        }
        .container3 {
            width: 400px;
        }
        h2 {
            text-align: center;

        }
        th {
            width: 80px;
            text-align: left;
        }
        .reg input {
            width: 100px;
            height: 65px;
            display: block;
            color: white;
            border: 1px solid #3182f6;
            background: #3182f6;
            transition: 0.3s;
        }
        .reg input:hover {
            color: #2b2e4a;
            background: white;
        }
        .caution {
            background-color: white;
            position: absolute;
            padding: 30px 30px;
            left: 50%;
            top: 70%;
            transform: translate(-50%, -50%);
            float: left;
            color: black;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            z-index: 10;
            box-shadow: 1px 1px 5px rgb(0 0 0 / 20%);
        }
        .caution div {
            font-size: 13px;
        }
        .caution span {
            font-size: 13px;
            font-weight: bold;
        }
        
    </style> 
</head>
<body>
        <form id='form' action="login" method="post">
            <div class="hero2">
            <div class='container3'>
                <h3>로그인</h3>
                <form id='form'>
                    <table style="padding-top: 10px;">
                        <tr>
                            <th>아이디</th>
                            <td style="padding: 5px;"><input style="width: 200px; border: 1px solid #2b2e4a" type='text'
                                    id='id' name="id"></td>
                            <td rowspan="2" class="reg"><input type='submit' value='로그인'></td>
                        </tr>
                        <tr>
                            <th>비밀번호</th>
                            <td style="padding: 5px;"><input style=" width: 200px; border: 1px solid #2b2e4a"
                                    type='password' id='password'  name="password"></td>
                        </tr>
                    </table>
                    <ul style="list-style: none; padding-top: 20px;">

                        <li style="left:0 ; padding: 0 0 0 9px; font-size: 12px; font-family:dotum; line-height: 24px;">
                            아이디가 없으신가요?<a
                                style="margin: 0 0 0 10px; font-family:  dotum; font-weight: bold; text-decoration: underline;"
                                href="memmenu?cpage=join">회원가입 하기</a></li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="caution">
            <h6 style="margin-bottom: 10px;"><b>가짜 은행사이트에 속지 마세요!!</b></h6>
            <h6 style="color: blue; margin-bottom: 10px;"><b>멀캠은 어떠한 이유로도 OTP카드와 보안카드 전체 또는 일부를 요구하지 않습니다.</b></h6>
            <div>최근 금융기관 콜센터 번호를 도용하여 개인정보유출 등 사유로 가짜사이트 접속을 유도하는 SMS가 발견되고 있습니다.</div>
            <div>또한 PC에 악성코드가 설치될 경우 즐겨찾기 또는 정상 은행사이트를 입력하셔도 가짜 은행사이트에 연결될 수 있습니다.</div>
        </div>
        </form>
      <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
            form.onsubmit = function () {
                let id = $('#id').val();
                if(id=='') {
                	alert("아이디를 입력하세요.");
                	$('#id').focus();
                	return false;
                }
                let password = $('#password').val();
                if(password=='') {
                	alert("비밀번호를 입력하세요.");
                	$('#password').focus();
                	return false;
                }
            }
        });
    </script>  
</body>
</html>