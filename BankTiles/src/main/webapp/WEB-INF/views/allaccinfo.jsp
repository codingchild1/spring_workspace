<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 계좌 조회</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    .container {
      width: 500px;
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
	   <h5 class='title'>전체 계좌 조회</h5>
	   <button id="query" class="btn btn-primary btn-block">새로고침</button><br><br>
	   <table id="table" class="table">
	     <thead class="table-secondary" style="text-align: center;">
	       <tr>
	         <th>계좌번호</th>
	         <th>이름</th>
	         <th>잔액</th>
	         <th>종류</th>
	         <th>등급</th>
	       </tr>
	     </thead>
	     <tbody>
	       <c:forEach items="${accs }" var="acc">
	       <tr>
	         <td>${acc.id }</td>	
	         <td>${acc.name }</td>	
	         <td>${acc.balance }</td>	
	         <td>${acc.type }</td>	
	         <td>${acc.grade }</td>	
	       </tr>
	       </c:forEach>
	     </tbody>
	   </table>	
  </div>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script >
  	$(function () {
		$('#query').click(function () {
			/* $('#table > tbody').empty(); */
			$('#table > tbody').detach();
			$.ajax({
				type:"post",
				async:false,
				url:"http://localhost:8080/allaccountinfo_json",
				success: function(data, textStatus){
					var jsonInfo=JSON.parse(data);
					/*ajax 속성중 dataType을 json으로 설정하게 되면 ajax가
					JSON으로 파싱한 데이터로 받기 때문에 위의 코드를 생략할 수 있다.
					만일 dataType을 지정하지 않으면 문자열(json형태의)로 데이터가 넘어오기 때문에
					위 코드처럼 파싱처리하는 코드가 필요하다.*/
					var table = $("#table");
					for(var cnt in jsonInfo.accounts){
						var tr = $('<tr></tr>');
						table.append(tr);
				        tr.append($('<td></td>').text(jsonInfo.accounts[cnt].id));
				        tr.append($('<td></td>').text(jsonInfo.accounts[cnt].name));
				        tr.append($('<td></td>').text(jsonInfo.accounts[cnt].balance));
				        tr.append($('<td></td>').text(jsonInfo.accounts[cnt].type));
				        tr.append($('<td></td>').text(jsonInfo.accounts[cnt].grade));
					}
				},
			      error:function(data,textStatus){
				         alert("에러가 발생했습니다.");ㅣ
				},
				  complete:function(data,textStatus){
				}
			});
		});
	});
  
  </script>
<!--   <script>
      let accs = ['{"id":1001,"name":"hong","balance":100000,"grade":null}',
                  '{"id":1002,"name":"park","balance":200000,"grade":"VIP"}',
                  '{"id":1003,"name":"song","balance":300000,"grade":"Gold"}'];

      let table = $("table");
      for(let accstr of accs) {
          let acc = JSON.parse(accstr);
          let tr = $('<tr></tr>');
          table.append(tr);
          tr.append($('<td></td>').text(acc.id));
          tr.append($('<td></td>').text(acc.name));
          tr.append($('<td></td>').text(acc.balance));
          tr.append($('<td></td>').text(function() {
              if(acc.grade==null) {
                  return '일반계좌';
              } else {
                  return '특수계좌';
              }
          }));
          tr.append($('<td></td>').text(acc.grade));
      }
      
  </script>   -->
</body>
</html>