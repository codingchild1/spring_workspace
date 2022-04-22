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
        background-color: white ! important;
        width: 600px;
        background:none;
      }
      .container1 {
        width:100%; 
        height:950px;
        background: #E5F2FF;
        background-size: 100%;
        background-repeat: no-repeat;
      }
      .input-group-text {
        display: inline-block;
        width: 90px;
      }
      .title {
        text-align: left;
        font-weight: bold;
      }
      .caution{
        background-color: white;
        position: absolute;
        padding: 30px 30px;
        left: 50%;
        top: 80%;
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
      .title{
      border:0px;
      }
  </style>
</head>
<body>
 <div class="hero2">
  <div class="container mt-3">
    <h5 class='title' ><input type="text" id="name" style="border:0px; background-color:white; width:70px; font-weight:bold; color:black;" disabled value='${name }'>님의 계좌</h5><br>
    <p style="text-align: left; font-size: 15px;">계좌 수 : <input type="text" id="count" name="count" style="border:0px; background-color:white;" disabled value='${count }'></p>
    <table class="table">
      <thead class="table-secondary" style="text-align: center;">
        <tr>
          <th>은행</th>
          <th>계좌번호</th>
          <th>상품명</th>
          <th>잔액</th>
          <th>종류</th>
          <th>등급</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${accs }" var="acc">
        <tr>
          <td>${acc.bank }</td>	
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

  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
  	$(function() {
  		$('#query').click(function() {
  			$.ajax({
    			async:false,
    			type:"post",
    			url:"http://localhost:8090/allaccountinfo_json",
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