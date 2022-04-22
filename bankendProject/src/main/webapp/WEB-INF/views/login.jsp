<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <style>
        .container3{
            width: 350px;
        }
        h2{
            text-align: center;
            
        }
        th{
            width: 100px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div class='container3'>
        <h2>로그인</h2>
        <hr>
        <form id='form'>
    <table>
        <tr>
            <th>아이디</th>
            <td><input type='text' id='id' name='id'></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type='password' id='password' name='password'></td>
        </tr>
        <tr>
            <td ></td>
            <td style="padding: 15px; text-align: justify;"><input type='submit' name="submit" id="submit" value='로그인'>&nbsp;&nbsp;&nbsp;<input type='reset' value='취소'></td>
        </tr>
    </table>
    </form>
    </div> 
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
  
        
         $(function () {
            form.onsubmit = function () {
                if($('#id').val()=='') {
                	alert("아이디를 입력하세요.");
                	$('#id').focus();
                	return false;
                }
                if($('#password').val()=='') {
                	alert("비밀번호를 입력하세요.");
                	$('#password').focus();
                	return false;
                }
                $.ajax({
    				type:"POST",
    				url:"http://localhost:8090/login/",
    				data:{id:$('#id').val(), password:$('#password').val()},
    				success: function(data, statusText) {
    					if(data=="true"){
    						alert("login ok");
    						console.log("true");
    						
    					}else{
    						alert("login fail");
    						console.log("false");
    					}
    				},
    				error: function(data, statusText) {
    					alert("에러 발생");
    				},
    				complete: function(data, statusText) {}
    			});
                return false;
            }
        }); 
/*         $(function () {
            form.onsubmit = function () {
                if($('#id').val()=='') {
                	alert("아이디를 입력하세요.");
                	$('#id').focus();
                	return false;
                }
                if($('#password').val()=='') {
                	alert("비밀번호를 입력하세요.");
                	$('#password').focus();
                	return false;
                }
                $.ajax({
    				type:"POST",
    				url:"http://localhost:8090/login2/",
    				data:{id:$('#id').val(), password:$('#password').val()},
    				success: function(data, statusText) {
    					if(data=="true"){
    						alert("사용 불가능합니다.");
    						$('#submit').attr("disabled", true);
    					} else {
    						alert("사용 가능합니다.");
    						$('#submit').attr("disabled", false);
    					}
    				}
    			});
        }); */
    </script>
</body>
</html>