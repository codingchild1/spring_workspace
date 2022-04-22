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
                <input type="text" class="form-control" id="name" name="name"><br>
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
                <input type="submit" id="submit" class="btn btn-primary btn-block" value='회원가입'>
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
				/*비동기통신 ajax : 화면전환없이 데이터만 주고받을 때 사용하는 프로토콜*/
				type:"post",
				dataType:"text", /*일반적으로 text나 json*/
				async:false, /*false면 동기식이라는 뜻 : 해당 처리이후 이후 코드를 진행하고자 할 때 사용*/
				/*자바 스크립트 영역에서 에이작스로 데이터를 가져온 후 어떤 함수를 수행한다고 가정하자.*/
				/*비동기적으로 에이작스 데이터를 가져온다면 그 함수의 데이터는 정확하지 않을 수 있다. */
				/*이때 동기적으로 에이작스 데이터를 가져온다면 에이작스를 통해 서버의 데이터를 가져오는 동안
				이후 함수 코드의 컴파일이 진행되지 않기 때문에 그 데이터는 정확할 것이다.*/
				url:"http://localhost:8080/memberoverlap",
				data:{id:$('#id').val()},
				/*데이터는 key와 value의 쌍으로 넘긴다.*/
				success: function(data, textStatus){
				/*데이터는 받아온 data(attribute 형태로)*/
				/*textStatus는 ajax 비동기통신의 성공여부를 내부적으로 가져오는 문자열 매개변수이다. 현재 사용하지 않음*/
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
            let password1 = $('#password').val();
            if(password1=='') {
            	alert("비밀번호를 입력하세요.");
            	$('#password1').focus();
            	return false;
            }
            let email = $('#email').val();
            if(email=='') {
            	alert("이메일을 입력하세요.");
            	$('#email').focus();
            	return false;
            }
            let password2 = $('#password2').val();
            if(password1!=password2){
            	alert("비밀번호 확인이 일치하지 않습니다.")
            	$('#password2').focus();
            	return false;
            }
        });
    </script> 
</body>
</html>