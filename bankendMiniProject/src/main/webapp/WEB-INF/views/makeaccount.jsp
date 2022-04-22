<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container {
            width: 350px;
        }

        .input-group-text {
            display: inline-block;
            width: 90px;
        }

        .title {
            text-align: center;
            font-weight: bold;
        }
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
        .register .flex .container4 {
            display: grid;
            grid-template-columns: 1fr 3fr 1fr;
            margin-bottom: 10px;
        }
        .register .flex .container4 .item .idcheck {
            height: 100%;
            margin-left: 10px;
            padding: 5px 15px;
            background: #2b2e4a;
            border: 1px solid #2b2e4a;
            color: white;
            font-size: 12px;
            transition: 0.3s;
        }
        .register .flex .container4 .item .idcheck:hover {
            background: white;
            color: #2b2e4a;
        }
        .register .flex .container4 .item select {
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
                .register .submit2 {
            width: 58px;
            height: 40px;
            color: white;
            border: none;
            border: 1px solid #3182f6;
            background: #3182f6;
            transition: 0.3s;
           vertical-align: top;
           border-radius: 5px;
        }
        .register .submit2:hover {
            width: 58px;
            height: 40px;
            border: none;
            border: 1px solid #2b2e4a;
            color: #2b2e4a;
            background: white;
        }
        .input-group-text {
            display: inline-block;
            width: 90px;
        }
        .form-control {
            border: 1px solid #2b2e4a;
            text-align: center;
            border-radius: 0%;

        }
    </style>
</head>
<body>
        <form id='form' action="makeaccount" method="post">
        <div class="register">
            <h3><b>계좌개설</b></h3>
            <form id='form'>
                <div class="flex">
                    <ul class="container4">
                        <li class="item center">
                            계좌번호
                        </li>
                        <li class="item1" style="float: left;">
                            <input type="text"  placeholder="사용할 계좌번호를 입력하세요." style="width: 223px;" autofocus id="id"  name="id">
                        	<button type="button" class="submit2" id="accoverlap" >중복</button>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            계좌비밀번호
                        </li>
                        <li class="item">
                            <input type="password"  placeholder="비밀번호를 입력하세요." autofocus id="password" name="password">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            비밀번호 확인
                        </li>
                        <li class="item">
                            <input type="password"  placeholder="비밀번호를 입력하세요." autofocus id="password2" name="password2">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            이름
                        </li>
                        <li class="item">
                            <input type="text" placeholder="이름을 입력하세요." autofocus id="name1" name="name1" >
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            예금상품
                        </li>
                        <li class="item">
                            <select name="name" id="name">
                                <option value="선택" selected>선택</option>
                                <option value="주거래우대통장">주거래우대통장</option>
                                <option value="더나은미래통장">더나은미래통장</option>
                                <option value="주택청약종합저축">주택청약종합저축</option>
                            </select>
                            <!-- <input type="text" placeholder="이름을 입력하세요." id="name" name="name"> -->
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            입금액
                        </li>
                        <li class="item">
                            <input type="text" placeholder="입금액을 입력하세요." id="balance" name="balance">
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            종류
                        </li>
                        <li class="item">
                            <span class="form-control"><input type="radio"  name='type'
                                    style="font-size: 1em; width: 1em; height: 1em; vertical-align: middle;"
                                    value="저축성" checked>&nbsp;저축성 &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name='type'
                                    style="font-size: 1em; width: 1em; height: 1em; vertical-align: middle;"
                                    value="입출금">&nbsp;입출금</span>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                            등급
                        </li>
                        <li class="item">
                            <select class="form-select" id='grade' name="grade" style="padding-left: 20px;" disabled>
                                <option>VIP</option>
                                <option>Gold</option>
                                <option>Silver</option>
                                <option>Normal</option>
                            </select>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                    <ul class="container4">
                        <li class="item center">
                        </li>
                        <li class="item">
                            <button class="submit">계좌개설</button>
                        </li>
                        <li class="item">
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        </form>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    $('#accoverlap').click(function () {
    	if($('#id').val()==""){
			alert("계좌번호를 입력하세요.");
			$('#submit').attr("disabled", true);
			return false;
		} 
		$.ajax({
			type:"post",
			dataType:"text",
			async:false,
			url:"http://localhost:8090/accoverlap",
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
    /* $("#accidoverlap").click(function() {
    	let id = $('#id').val();
    		if(id == '') {
    			alert("계좌번호를 입력하세요");
    		} else {
    			$.ajax({
    				type: "post",
    				dataType: "text",
    				async: false,
    				url: "http://localhost:8090"+CONTEXT_PATH+"/accidoverlap",
    				data: {id: id},
    				success: function(data, textStatus) {
    					if(data == 'true') {
    						alert("사용 불가능합니다.");
    					} else {
    						alert("사용 가능합니다.");
    					}
    				}
    			})	
    		}
    	}) */

    $('input[type="radio"]').change(function() {
        let type = $('input[type="radio"]:checked').val();
        if(type=='입출금') {
            $('select').attr('disabled',false);
        } else {
            $('select').attr('disabled',true);
        }
    });
    
    $('#form').submit(function() {
    	let id = $('#id').val();
        if(id=='') {
        	alert("계좌번호를 입력하세요.");
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
        let name = $('#name').val();
        if(name=='') {
        	alert("이름을 입력하세요.");
        	$('#name').focus();
        	return false;
        }
        let balance = $('#balance').val();
        if(balance=='') {
        	alert("입금액을 입력하세요.");
        	$('#balance').focus();
        	return false;
        }
        let type = $('input[name=type]:checked').val();
        if(type=='') {
        	alert("계좌종류를 선택하세요.");
        	return false;
        }
        let grade = $('#grade').val();
       	if(type=="normal"){
       		return true;
       	} else{
            if(grade=='') {
            	alert("등급을 선택하세요.");
            	return false;
            }
       	}
    });
    </script> 
</body>
</html>