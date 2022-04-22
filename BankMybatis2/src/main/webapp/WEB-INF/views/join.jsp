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
    </style> 
</head>
<body>
   <div class="container mt-3">
        <h5 class='title'>회원 가입</h5>
        <form id='form' action="join" method="post">
            <div class="input-group mb-2">
                <span class="input-group-text title">이름</span>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">아이디</span>
                <input type="text" class="form-control" id="id" name="id">
                <button type="button" class="btn btn-info" id="memidoverlap">중복</button>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">비밀번호</span>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">비밀번호 확인</span>
                <input type="password" class="form-control" id="password2" name="password2">
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">이메일</span>
                <input type="text" class="form-control" id="email" name="email">
            </div>            
            <div class="d-grid">
                <input type="submit" class="btn btn-primary btn-block" value='회원가입'>
            </div>
        </form>
    </div>   
    
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
        let email = $('#email').val();
        if(email=='') {
        	alert("이메일을 입력하세요.");
        	$('#email').focus();
        	return false;
        }
        let password2 = $('#password2').val();
        if(password!=password2){
        	alert("비밀번호 확인이 일치하지 않습니다.")
        	$('#password2').focus();
        	return false;
        }
    });
    </script>      
</body>
</html>