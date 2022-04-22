<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금</title>
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
        width:90px;
    }
    .title {
        text-align: center;
        font-weight: bold;
    }
</style>  
</head>
<body>
   <div class="container mt-3">
        <h5 class='title'>입 금</h5>
        <form id='form'>
            <div class="input-group mb-2">
                <span class="input-group-text title">계좌번호</span>
                <input type="text" class="form-control" id="id" name="id"><br>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">입금액</span>
                <input type="text" class="form-control" id="money" name="money">
            </div>
            <div class="input-group mb-2 d-grid">
                <input type="submit" class="btn btn-primary btn-block" value='입금'>
            </div>
            <div class="input-group mb-2" id='result' style="display: none;">
                <span class="input-group-text title">잔액</span>
                <input type="text" class="form-control" id="balance" disabled value='${balance }'>
            </div>            
        </form>
    </div>   
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
        	let type = "<c:out value='${vtype}'/>";
        	if(type=="R") {
        		 $('#result').show();
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
                	alert("입금액을 입력하세요.");
                	$('#money').focus();
                	return false;
                }
                
                $.ajax({
    				type:"PUT",
    				url:"http://localhost:8090/deposit/"+$('#id').val(),
    				data:JSON.stringify($('#money').val()),
    				contentType:'application/json; charset=utf-8',
    				success: function(data, statusText) {
    					console.log(data);
    					$('#balance').val(data);
    					 $('#result').show();
    				},
    				error: function(data, statusText) {
    					alert("에러 발생");
    				},
    				complete: function(data, statusText) {}
    			});
                return false;
            }
        });
    </script>  
</body>
</html>