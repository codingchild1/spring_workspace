<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
        	$("#btn").click(function(){
        		$.ajax({
        			type:"get",
        			async:true,
        			url:"http://localhost:8090/test/memberList2",
        			dataType:"json",
        			success: function(data, textStatus){
        				console.log(data);
        				console.log(textStatus);
        				$.each(data, function(i,v){
        					$("#output").append('<tr><td>'+v.id+'</td><td>'+
        							v.pwd+'</td><td>'+v.name+'</td><td>'+v.email+'</td></tr>');
        				});
        			},
        			error: function(data, textStatus){
        				alert("에러 발생");
        			},
        			complete:function(data, textStatus){
        			
        			}
        		});
        	});
        });
    </script> 
</head>
<body>
<input type="button" id="btn" value="버튼"/>
<table id="output" border="1">
	<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
</table>
</body>
</html>