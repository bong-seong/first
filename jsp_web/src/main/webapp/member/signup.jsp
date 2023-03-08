<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : SIGNUP </title>
</head>

<body>

	<h3> 회원가입 </h3>
	
	<form action="" class="signupForm">	
		아이디 : <input onkeyup= "idcheck()" maxlength="30" type="text" name="mid" class="mid">	
		<span class="idcheckconfirm"></span>
		<br/>
		비밀번호 : <input type="password" 	name="mpwd"  		class="mpwd">			<br/>
		비밀번호 확인 : <input type="password"	name="mpwdconfirm"  class="mpwdconfirm"><br/>
		이메일 : <input type="text" 		name="memail"  		class="memail">			<br/>
		프로필 : <input type="file" 		name="mimg"  		class="mimg">			<br/>
		<button type="button" onclick="signup()" > 가입 </button>						<br/>
	</form>


	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="/jsp_web/js/member/signup.js" type="text/javascript"></script>
	
</body>
</html>