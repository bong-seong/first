<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : FIND ID </title>
	
	<link href="/jsp_web/css/signup.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<%@ include file ="/header.jsp"%>
	
	<div class="container"> <!-- bs 박스권 --> 
		
		<form action="" class="signupForm">	
		
			<h3> 내 ID 찾기 </h3>
			<p> 계정정보 (아이디) 찾기 </p>
		
			<div class="title">이메일</div> 		
			<input type="text" maxlength="30" name="memail" class="memail">	
			
			<div class="idcheckconfirm"></div>
			
			<button class="signupbtn" type="button" onclick="findid()" > 아이디 찾기 </button>
	</div> <!-- container end -->
	
	
	
	<!-- 정의 js -->
	<script src="/jsp_web/js/member/login.js" type="text/javascript"></script>
</body>
</html>