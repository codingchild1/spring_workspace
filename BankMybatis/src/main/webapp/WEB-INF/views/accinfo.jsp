<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 조회</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
      
        ul, li {
        list-style: none;
          }
        a {
        text-decoration: none;
        color: inherit;
        }  
        .container1 {
            width:100%; 
            height:950px;
            background: #E5F2FF;
            background-size: 100%;
            background-repeat: no-repeat;
        }      
        .register{
            width: 550px;
            position: absolute;
            left: 50%;
            top:40%;
            transform: translate(-50%,-50%);
            padding: 15px 20px;
            background: white;
            color: #2b2e4a;
            font-size: 14px;
            text-align: left;
            box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
        }
        .register h3{
            font-size: 20px;
            margin-bottom: 20px;
            text-align: center;
        }
       .container5 .register input{
            width: 100%;
            height: 40px;
            outline: none;
            padding: 10px;
            border: 1px solid #707070;
            transition: 0.3s;
        }
        .register input:valid, .register input:focus{
            border: 1px solid #2b2e4a;
        }
        .register .center{
            display: flex;
            align-items: center;
        }
        .register .flex{
            display: flex;
            flex-direction: column;
        }
        .register .flex .container{
            display: grid;
            grid-template-columns: 1fr 3fr 1fr;
            margin-bottom: 10px;
        }
        .register .flex .container .item .idcheck{
            height: 100%;
            margin-left: 10px;
            padding: 5px 15px;
            background: #2b2e4a;
            border: 1px solid #2b2e4a;
            color: white;
            font-size: 12px;
            transition: 0.3s;
        }
        .register .flex .container .item .idcheck:hover{
            background: white;
            color: #2b2e4a;
        }
        .register .flex .container .item select{
            height: 40px;
            padding: 10px;
            border: 1px solid #2b2e4a;
        }
        .register .submit{
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
        .register .flex .container:last-child{
            margin: 0;
        }
        .register .submit:hover{
            height: 40px;
            border: none;
            border: 1px solid #2b2e4a;
            color: #2b2e4a;
            background: white;
        }
    .caution{
        background-color: white;
        position: absolute;
        padding: 30px 30px;
        left: 50%;
        top: 70%;
        transform: translate(-50%,-50%);
        float: left;
        color: black;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        z-index: 10;
        box-shadow: 1px 1px 5px rgb(0 0 0 / 20%);
    }
    .caution div{
        font-size: 13px;
    }
    .caution span{
        font-size: 13px;
        font-weight: bold;
    }

    input[type="text"]:disabled{
            background: white;
     }
           #result .register{
            width: 400px;
            height: 180px;
            position: absolute;
            left: 50%;
            top:40%;
            transform: translate(-50%,-50%);
            padding: 8px 8px;
            background: white;
            color: #2b2e4a;
            font-size: 14px;
            text-align: left;
            box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
        }
                .register span input{
            border: 0px;
        }

    </style>
</head>
<body>
        <form id='form' action="accinfo" method="post">
    <div class="container5">
    <div class="register">
        <h3><b>계좌조회</b></h3>
        <form id='form'>
            <div class="flex">
                <ul class="container">
                    <li class="item center">
                        계좌번호
                    </li>
                    <li class="item">
                        <input type="text" name="id"  placeholder="계좌번호를 입력하세요." autofocus id="id">
                    </li>
                    <li class="item">
                    </li>
                </ul>
            </div>
            <button class="submit">계좌조회</button>
                </form>
                </div>
   </div>  
<div class="caution">
    <h6><b>서비스 이용시간</b></h6>
    <span>-평일 00:30~24:00, </span><span style="color: blue;">토요일 00:30~24:00, </span><span style="color:chocolate;">일요일/공휴일 00:30~24:00</span>
    <hr>
    <h6><b>거래내역조회 안내</b></h6>
    <div>-무통장(미기장)거래내역은 통장없이 거래한 내역을 조회합니다.</div>
    <div>-무통장 거래내역 조회는 시작일로부터 최대 180일 이내에 최대 120건 조회 가능합니다.</div>
    <div>-이체메모에 마우스를 올리면 이체시 작성한 메모내용을 확인할 수 있습니다.</div>
</div>
        <div id='result' style="display: none;">
    <div class="register">
   <div style="margin: 5px ; padding: 5px;">
       <span ><input type="text" id="type" style="font-size: 15px; width: 50px;" disabled value='${acc.type }'></span>
       <span ><input type="text" id="name" style="font-size: 17px; width: 120px;" disabled value='${acc.name }'></span>
       <span style="padding-right: 0px; float: right; font-size: 15px;">등급</span>
       <span ><input type="text" id="grade" style="padding-right: 0px; float: right; font-size: 15px; width: 37px;" disabled value='${acc.grade }'></span>
   </div>
   <div ><input type="text" id="id" style="margin: 5px ; padding: 5px; padding-left: 15px; color: #3182f6; font-weight: bold; font-size: 22px; border: 0px;" disabled value='${acc.id }'></div>
   <div></div>
   <div style="margin-top: 30px; margin-right: 8px; float: right;">
       <span style="font-size: 16px;">잔액 : </span>
       <span><input type="text" id="balance"  style=" font-size: 22px; font-weight: bold; color: #3182f6; width: 80px;" disabled value='${acc.balance }'></span>
   </div>
</div>
    </div>
</form>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    $(function () {
    	let type = "<c:out value='${vtype}'/>";
    	if(type=="R") {
             $('#result').show();    		
    		$('#form').hide(); 
    	} else {
    		$('#form').show();
            $('#result').hide();
    	}
        form.onsubmit = function () {
            if($('#id').val()=='') {
            	alert('계좌번호를 입력하세요');
            	$('#id').focus();
            	return false;
            }
        }
    });
    </script> 
</body>
</html>