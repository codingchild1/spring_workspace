<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
    <style>
 * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        ul, li {
            list-style: none;
        }
        a {
            text-decoration: none;
            color: inherit;
        }
        .container1 {
            width: 100%;
            height: 950px;
            background: #E5F2FF;
            background-size: 100%;
            background-repeat: no-repeat;
        }
        .register {
            width: 550px;
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            padding: 15px 20px;
            background: white;
            color: #2b2e4a;
            font-size: 14px;
            text-align: left;
            box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
        }
        .register h3 {
            font-size: 20px;
            margin-bottom: 20px;
            text-align: center;
        }
        .register input {
            width: 100%;
            height: 40px;
            outline: none;
            padding: 10px;
            border: 1px solid #707070;
            transition: 0.3s;
        }
        .register input:valid,
        .register input:focus {
            border: 1px solid #2b2e4a;
        }
        .register .center {
            display: flex;
            align-items: center;
        }
        .register .flex {
            display: flex;
            flex-direction: column;
        }
        .register .flex .container {
            display: grid;
            grid-template-columns: 1fr 3fr 1fr;
            margin-bottom: 10px;
        }
        .register .flex .container .item .idcheck {
            height: 100%;
            margin-left: 10px;
            padding: 5px 15px;
            background: #2b2e4a;
            border: 1px solid #2b2e4a;
            color: white;
            font-size: 12px;
            transition: 0.3s;
        }
        .register .flex .container .item .idcheck:hover {
            background: white;
            color: #2b2e4a;
        }
        .register .flex .container .item select {
            height: 40px;
            padding: 10px;
            border: 1px solid #2b2e4a;
        }
        .register .submit {
            width: 100%;
            height: 40px;
            color: white;
            border: none;
            border: 1px solid #3182f6;
            background: #3182f6;
            transition: 0.3s;
        }
        .register .flex .container:last-child {
            margin: 0;
        }
        .register .submit:hover {
            width: 100%;
            height: 40px;
            border: none;
            border: 1px solid #2b2e4a;
            color: #2b2e4a;
            background: white;
        }
    </style> 
</head>
<body>
        <form id='form' action="join" method="post">
 <div class="container1">
        <div class="register">
            <h3><b>회원가입</b></h3>
            <form id='form'>
                <div class="flex">
                    <ul class="container">
                        <li class="item center">
                            이름
                        </li>
                        <li class="item">
                            <input type="text" name="name" placeholder="이름을 입력하세요." autofocus id="name" name="name">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            아이디
                        </li>
                        <li class="item">
                            <input type="text" placeholder="아이디를 입력하세요." id="id" name="id">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            비밀번호
                        </li>
                        <li class="item">
                            <input type="password" placeholder="비밀번호를 입력하세요." id="password" name="password">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            비밀번호 확인
                        </li>
                        <li class="item">
                            <input type="password" placeholder="비밀번호를 입력하세요." id="password2" name="password2">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            생년월일
                        </li>
                        <li class="item">
                            <input type="date" id="birth" name="birth">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            성별
                        </li>
                        <li class="item">
                            <select name="gender" id="gender" name="birth">
                                <option value="선택" selected>선택</option>
                                <option value="남성">남성</option>
                                <option value="여성">여성</option>
                            </select>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            전화번호
                        </li>
                        <li class="item">
                            <input type="text" placeholder="휴대전화번호" id="number" name="number">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            이메일
                        </li>
                        <li class="item">
                            <input type="text" placeholder="이메일을 입력하세요" id="email" name="email">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                        </li>
                        <li class="item">
                            <button class="submit">가입하기</button>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
        </form>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
	$('#memidoverlap').click(function () {
		if($('#id').val()==""){
			alert("아이디를 입력하세요.");
			$('#submit').attr("disabled", true);
			return false;
		} 
		$.ajax({
			type:"post",
			dataType:"text", 
			async:false, 
			url:"http://localhost:8090/memidoverlap",
			data:{id:$('#id').val()},
			success: function(data, textStatus){
				if(data=="true"){
					alert("사용 불가능합니다.");
					$('#submit').attr("disabled", true);
				} else {
					alert("사용 가능합니다.");
					$('#submit').attr("disabled", false);
				}
			}
		});
	});
    $('#form').submit(function() {
        let name = $('#name').val();
        if(name=='') {
        	alert("이름을 입력하세요.");
        	$('#name').focus();
        	return false;
        }
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
        let password2 = $('#password2').val();
        if(password!=password2){
        	alert("비밀번호 확인이 일치하지 않습니다.")
        	$('#password2').focus();
        	return false;
        }
        let birth = $('#birth').val();
        if(birth=='') {
        	alert("생일을 선택하세요.");
        	$('#birth').focus();
        	return false;
        }
        let gender = $('#gender').val();
        if(gender=='') {
        	alert("성별을 선택하세요.");
        	$('#gender').focus();
        	return false;
        }
        let number = $('#number').val();
        if(number=='') {
        	alert("전화번호를 입력하세요.");
        	$('#number').focus();
        	return false;
        }
        let email = $('#email').val();
        if(email=='') {
        	alert("이메일을 입력하세요.");
        	$('#email').focus();
        	return false;
        }
    });
    </script>      
</body>
</html>