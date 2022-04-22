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
    </style>
</head>
<body>
   <div class="container mt-3">
        <h5 class='title'>계좌 개설</h5>
        <form id='form' action="makeaccount" method="post">
            <div class="input-group mb-2">
                <span class="input-group-text title">계좌번호</span>
                <input type="text" class="form-control" id="id" name="id" style="width: 228px;"><br>
                <button type="button" class="submit2" id="accoverlap" >중복</button>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">이름</span>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">입금액</span>
                <input type="text" class="form-control" id="balance" name="balance">
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">종류</span>
                <span class="form-control"><input type="radio" name='type' value="normal" checked name="type">&nbsp;일반계좌 &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name='type' value="special" name="type">&nbsp;특수계좌</span>
            </div>
            <div class="input-group mb-2">
                <span class="input-group-text title">등급</span>
                <select class="form-select" id='grade' disabled name="grade">
                    <option value="VIP">VIP</option>
                    <option value="Gold">Gold</option>
                    <option value="Silver">Silver</option>
                    <option value="Normal">Normal</option>
                </select>
            </div>
            <div class="d-grid">
                <input type="submit" class="btn btn-primary btn-block" value='계좌개설'>
            </div>
        </form>
    </div>

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
        if(type=='special') {
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
        let name = $('#name').val();
        if(name=='') {
        	alert("이름을 입력하세요.");
        	$('#name').focus();
        	return false;
        }
        let money = $('#balance').val();
        if(money=='') {
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