<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : LOGIN </title>
	
	<link href="/jsp_web/css/signup.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<%@ include file ="/header.jsp"%>
	
	<div class="container"> <!-- bs 박스권 --> 
		
		<form class="signupForm">	
		
			<h3> Login </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다. </p>
		
			<div class="title">아이디</div> 		
			<input type="text" maxlength="30"  name="mid" class="mid">	
			
			<div class="title">비밀번호</div>
			<input type="password" maxlength="20" name="mpwd" class="mpwd">
			<div class="idcheckconfirm"></div>
			
			<div class="subbtnbox">
				<a href="/jsp_web/member/findid.jsp">아이디 찾기</a>
				<span> | </span>
				<a href="/jsp_web/member/findpwd.jsp">비밀번호 찾기</a>
			</div>
			
			<button class="signupbtn" type="button" onclick="login()" > 로그인 </button>
	</div> <!-- container end -->
	
	
	
	<!-- 정의 js -->
	<script src="/jsp_web/js/member/login.js" type="text/javascript"></script>
</body>
</html>