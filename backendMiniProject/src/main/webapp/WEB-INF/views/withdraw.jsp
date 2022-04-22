<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출금</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>    
<style>
 ul,
        li {
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
            /* margin: 200px auto 0; */
            position: absolute;
            left: 50%;
            top: 40%;
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
            width: 100px;
            height: 40px;
            margin: auto;
            display: block;
            margin-top: 10px;
            text-align: center;
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
            /* width: 100px; */
            height: 40px;
            border: none;
            border: 1px solid #2b2e4a;
            color: #2b2e4a;
            background: white;
        }

        .caution {
            background-color: white;
            position: absolute;
            padding: 30px 30px;
            left: 50%;
            top: 78%;
            transform: translate(-50%, -50%);
            float: left;
            color: black;
            /* text-align: center; */
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
                #result .register input {
            width: 349px;
            height: 51px;
            padding: 15px;
            color: #2b2e4a;
            font-size: 14px;
            align-items: center;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            border-collapse: collapse;
            border: 0px solid #ccc;
            border-left: 1px solid #ccc;
            border-right: 1px solid #ccc;
            background-color: white;
        }
       #result .register input:valid,
       #result .register input:focus {
            border-top: 1px solid #ccc;
            border-right: 1px solid #ccc;
            border-bottom: 0px solid #ccc;
            border-left: 0px solid #ccc;
        }
       #result .register .center {
            border-collapse: collapse;
            text-align: left;
            width: 147px;
            padding: 15px;
            color: #2b2e4a;
            font-size: 14px;
            font-weight: bold;
            align-items: center;
        }
       #result .register .flex {
            display: flex;
            flex-direction: column;
        }
       #result .register .flex .container {
            display: grid;
            grid-template-columns: 1fr 3fr 1fr;
            margin-bottom: 0px;
            margin-left: 0px;
            border-collapse: collapse;
            border-left: 2px solid #3182f6;
            border-top: 1px solid #ccc;
            border-right: 1px solid #ccc;
        }
       #result .register .flex .container .item .idcheck {
            height: 100%;
            margin-left: 10px;
            padding: 5px 15px;
            background: #2b2e4a;
            color: white;
            font-size: 12px;
            transition: 0.3s;
        }
        
        
      #result  .register .flex .container .item .idcheck:hover {
            background: white;
            color: #2b2e4a;
        }
       #result .register .flex .container .item select {
            height: 40px;
            padding: 10px;
        }
       #result .register .submit {
            width: 100px;
            height: 40px;
            margin: auto;
            display: block;
            margin-top: 10px;
            text-align: center;
            color: white;
            border: none;
            border: 1px solid #3182f6;
            background: #3182f6;
            transition: 0.3s;
        }
       #result .register .flex .container:last-child {
            margin: 0;
        }
       #result .register .submit:hover {
            /* width: 100px; */
            height: 40px;
            border: none;
            border: 1px solid #2b2e4a;
            color: #2b2e4a;
            background: white;
        }
</style>
</head>
<body>
        <form id='form' action="withdraw" method="post">
             <div class="container5">
        <div class="register">
            <h3><b>출금</b></h3>
            <form id='form'>
                <div class="flex">
                    <ul class="container">
                        <li class="item center">
                            계좌번호
                        </li>
                        <li class="item">
                            <input type="text" name="id" placeholder="계좌번호를 입력하세요." autofocus id="id">
                            <!-- <input type="text" name="name" autofocus required> -->
                        </li>
                        <li class="item">

                        </li>
                    </ul>
                    <ul class="container">
                        <li class="item center">
                            출금액
                        </li>
                        <li class="item">
                            <input type="text" placeholder="출금액을 입력하세요."  id="money" name="money">
                        </li>
                    </ul>
                </div>
                <button class="submit">출금</button>
            </form>
        </div>
        <div class="caution">
            <h6><b>서비스 이용시간</b></h6>
            <span>-평일 00:30~24:00, </span><span style="color: blue;">토요일 00:30~24:00, </span><span
                style="color:chocolate;">일요일/공휴일 00:30~24:00</span>
            <div style="color:chocolate; font-size: 13px; font-weight: bold;">-타행이체가능시간 : 00:30 ~ 23:55 </div>
            <div>-적립식예금을 제외한 정기예금 및 일부 CMS이체는 휴일거래가 불가합니다.</div>
            <div>-거래중지계좌는 인터넷뱅킹을 통한 입출금 거래가 불가하오니 상세 내용은 영업점으로 문의하시기 바랍니다.</div>
            <hr>
            <h6><b>인터넷뱅킹 이체수수료</b></h6>
            <div>-당행이체수수료 : 수수료 면제</div>
            <span>-타행이체수수료 : </span><span style="color: blue;">500원/건당(1억원 초과시 1억당 500원 추가) </span>
            <div>-기타 가입한 상품 또는 서비스의 기준에 따라 수수료가 면제됩니다.</div>
        </div>
        </div>
            <div id='result' style="display: none;">
                       <div class="register">
            <h3><b>출금결과</b></h3>
            <form id='form2'>
                <div class="flex">
                    <ul class="container">
                        <li class="item center">
                            계좌번호
                        </li>
                        <li class="item">
                            <input type="text" name="id"  id="id" disabled value='${acc.id }'>
                        </li>
                        <li class="item">

                        </li>
                    </ul>
                   
                    <ul class="container">
                        <li class="item center">
                            출금액
                        </li>
                        <li class="item">
                            <input type="text"  style="color: #3182f6; text-align: end; font-weight: bold;" id="withdraw" 
                            disabled value='${withdraw }'>
                        </li>
                        <li class="item">

                        </li>
                    </ul>
                    <ul class="container" style="border-bottom: 1px solid #ccc">
                        <li class="item center">
                            출금 후 잔액
                        </li>
                        <li class="item" >
                            <input type="text" style="color: #3182f6; text-align: end; font-weight: bold;" id="balance"
                             disabled  value='${balance }'>
                            
                        </li>
                        <li class="item">

                        </li>
                    </ul>
                   
                    <button class="submit">완료</button>
                </div>
            </form>
        </div>
            </div>            
        </form>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    $(function () {
    	let type = "<c:out value='${vtype}'/>";
    	if(type=="R") {
    		 $('#result').show();
    		 alert('출금이 정상적으로 완료되었습니다.');
    	} else {
    		 $('#result').hide();
    	}
    	
        form.onsubmit = function () {
            let id = $('#id').val();
            if(id=='') {
            	alert("계좌번호를 입력하세요.");
            	$('#id').focus();
            	return false;
            }
            let money = $('#money').val();
            if(money=='') {
            	alert("출금액을 입력하세요.");
            	$('#money').focus();
            	return false;
            }
        }
    });
    $(function () {
        $('#form2').submit(function(){
               location.href = "/";
               return false;
           
       })
});
    </script>
</body>
</html>