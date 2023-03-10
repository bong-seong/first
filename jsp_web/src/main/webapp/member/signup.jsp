<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : SIGNUP </title>
	
	<link href="/jsp_web/css/signup.css" rel="stylesheet">
	
</head>

<body>
	<%@ include file="/header.jsp" %> <!-- (webapp이하생략) 절대경로 -->
	
	<div class="container"> <!-- bs 박스권 --> 
		
		<form action="" class="signupForm">	
		
			<h3> Community </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다. </p>
		
			<div class="title">아이디</div> 		
			<input type="text" onkeyup="idcheck()" maxlength="30"  name="mid" class="mid">	
			<div class="idcheckconfirm"></div>
			
			<div class="title">비밀번호</div>
			<input type="password" onkeyup="pwdcheck()" maxlength="20" name="mpwd" class="mpwd">
			<div class="title">비밀번호 확인</div>
			<input type="password" onkeyup="pwdconfirmcheck()" maxlength="20" name="mpwdconfirm" class="mpwdconfirm">
			<div class="idcheckconfirm"></div>
			
			<div class="title">이메일</div>
			<div class="emailbox">
				<input type="text" onkeyup="emailcheck()" name="memail" class="memail">
				<button onclick="getauth()" class="authbtn" type="button" disabled="disabled"> 인증 </button>
				
			</div>
			<!-- 인증코드 입력 구역 -->
			<div class="authbox">
				<!-- js 들어가는 자리 -->

			</div>
			<div class="idcheckconfirm"></div>
			
			<div class="title">프로필</div>
			<div class="pimgbox">
				<img class="premimg" src="/jsp_web/member/mimg/default.png" width="100px;">
				<input onchange="premimg(this)" type="file" name="mimg" class="mimg">
			</div>
			
			<button class="signupbtn" type="button" onclick="signup()" > 가입 </button>						
		</form>
		
	</div> <!-- container end -->
	


	
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="/jsp_web/js/member/signup.js" type="text/javascript"></script>
	
</body>
</html>