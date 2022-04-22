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
    
    button {
    	float:right;
    	margin-bottom:5px; 
    }
  </style>
</head>
<body>
  <div class="container mt-3">
    <h5 class='title'>전체 계좌 조회</h5>
    <button id="query" class="btn btn-primary">조회</button>
    <table class="table">
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
  <script>
  	$(function() {
  		$('#query').click(function() {
  			$.ajax({
    			async:false,
    			type:"post",
    			url:"http://localhost:8090/bank2/allaccountinfo_json",
    			//dataType:"json",
    			contentType : 'application/json; charset=UTF-8',
    			success: function(data, textStatus) {
    				console.log(data);
    				var jsonInfo = JSON.parse(data);
    				var accEle = "";
    				for(let acc of jsonInfo.accs) {
    					accEle += '<tr>';
    					accEle += '<td>'+acc.id+'</td>'
    					accEle += '<td>'+acc.name+'</td>'
    					accEle += '<td>'+acc.balance+'</td>'
    					accEle += '<td>'+acc.type+'</td>'
    					accEle += '<td>'+acc.grade+'</td>'
      					accEle += '</tr>'
    				}
    				
    				$("tbody>tr").detach();
    				$("table").append(accEle);
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