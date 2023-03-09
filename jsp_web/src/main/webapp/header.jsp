<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HEADER</title>
	
	<!-- 모든페이지 공통 css -->
	<link href="/jsp_web/css/index.css" rel="stylesheet">
	
</head>
<body>

	<h3> 헤더 입니다. </h3>
	<div class="header">
		<!-- js 들어갈 자리 -->
	</div>
	
	<!-- jquery --> <!-- 모든페이지 공통 js -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jsp_web/js/header.js" type="text/javascript"></script>
	
</body>
</html>


<%-- 
	<% String login = (String)request.getSession().getAttribute("login"); %>
	
	<a href="/jsp_web/index.jsp"> 홈 </a>
	<%
		if(login == null ){
	%>
			<a href="/jsp_web/member/signup.jsp"> 회원가입 </a>
			<a href="/jsp_web/member/login.jsp"> 로그인 </a>
	<%
		} else if( login.equals("admin") ){
	%>
			<a href="/jsp_web/admin/info.jsp"> 관리자페이지 </a>
			<a href="/jsp_web/member/logout.jsp"> 로그아웃 </a>
	<%		
		} else {
	%>
			<%=login %> 님 안녕하세요
			<a href="/jsp_web/member/logout.jsp"> 로그아웃 </a>
	<%
		}
	 %> 
--%>