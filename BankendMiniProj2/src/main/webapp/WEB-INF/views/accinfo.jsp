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
    </style>
</head>
<body>
   <div class="container mt-3">
        <h5 class='title'>계좌 조회</h5>
        <form id='form'>
            <div class="input-group mb-2">
                <span class="input-group-text title">계좌번호</span>
                <input type="text" class="form-control" id="id" name="id"><br>
            </div>
            <div class="d-grid">
                <input type="submit" class="btn btn-primary btn-block" value='계좌조회'>
            </div>
        </form>

        <div id='result' >
            <div class="input-group mb-2">
                <span class="input-group-text title">계좌번호</span>
                <span class="form-control" id="rid">${acc.id }</span>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">이름</span>
                <span class="form-control" id="name">${acc.name }</span>
            </div>        
            <div class="input-group mb-2">
                <span class="input-group-text title">잔액</span>
                <span class="form-control" id="balance">${acc.balance }</span>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">종류</span>
                <span class="form-control" id="type">${acc.type }</span>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">등급</span>
                <span class="form-control" id="grade">${acc.grade }</span>
            </div>
        </div>
    </div>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
        	let type = "<c:out value='${vtype}'/>";
        	if(type=="R") {
        		$('#form').hide();
                $('#result').show();        		
        	} else {
        		$('#form').show();
                $('#result').hide();
        	}
            form.onsubmit = function () {
                if($('#id').val()=='') {
                	alert('계좌번호를 입력하세요');
                	$('#id').focus();
                }
                $.ajax({
    				type:"GET",
    				url:"http://localhost:8090/accountinfo/"+$('#id').val(),
    				contentType:'application/json; charset=utf-8',
    				success: function(data, statusText) {
    					console.log(data);
    					$('#form').hide();
    	                $('#result').show();  
    	                $('#rid').text(data.id);
    	                $('#name').text(data.name);
    	                $('#balance').text(data.balance);
    	                $('#type').text(data.type);
    	                $('#grade').text(data.grade);
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