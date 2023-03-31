<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 수업 : 포인트 </title>
</head>
<body>

	<%@ include file ="/header.jsp" %>
	
	<div class="container">
		
		<h3> 포인트결제 </h3>
		<button type="button" onclick="setpay(10000)"> 10000 원 </button>
		<button type="button" onclick="setpay(50000)"> 50000 원 </button>
		<br> 
		<button onclick="requestPay()">결제하기</button> <!-- 결제하기 버튼 생성 -->
		
		
		<h3> 본인인증 </h3>
		
	</div>
	
	<!-- 포트원 결제 JS -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<!-- SMS 본인인증 -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<!-- 사용자정의 JS -->
	<script src="/jsp_web/js/member/point.js" type="text/javascript"></script>
</body>
</html>