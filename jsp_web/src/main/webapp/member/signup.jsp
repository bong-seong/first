<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : SIGNUP </title>
</head>

<body>
	<%@ include file="/header.jsp" %> <!-- (webapp이하생략) 절대경로 -->
	
	
	<h3> 회원가입 </h3>
	
	<form action="" class="signupForm">	
	
		아이디 : 		<input type="text" onkeyup="idcheck()" maxlength="30"  name="mid" class="mid">	
		<span class="idcheckconfirm"></span> <br/>
		
		비밀번호 :		<input type="password" onkeyup="pwdcheck()" maxlength="20" name="mpwd" class="mpwd">
		<span class="idcheckconfirm"></span> <br/>
		비밀번호 확인 : 	<input type="password" onkeyup="pwdconfirmcheck()" maxlength="20" name="mpwdconfirm" class="mpwdconfirm">
		<br/>
		
		이메일 : 		<input type="text" onkeyup="emailcheck()" name="memail" class="memail">
		<span class="idcheckconfirm"></span> <br/>
		
		프로필 : 		<input onchange="premimg(this)" type="file" name="mimg" class="mimg">
		<br/><br/>
			<img class="premimg" src="/jsp_web/member/mimg/default.png" width="100px;">
			<br/> 미리보기 <br/>
		<button type="button" onclick="signup()" > 가입 </button>						
	</form>


	
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="/jsp_web/js/member/signup.js" type="text/javascript"></script>
	
</body>
</html>