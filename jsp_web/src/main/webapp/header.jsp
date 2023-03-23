<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>HEADER</title>
	
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 모달 css  -->
	<link href="/jsp_web/css/modal.css" rel="stylesheet">
	<!-- 모든페이지 공통 css -->
	<link href="/jsp_web/css/index.css" rel="stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	
</head>

<body>
	
	<div class="container"> <!-- bs 박스권 -->
		
		<div class="header">
			<!-- logo -->
			<div class="mainlogo">
				<a href="/jsp_web/index.jsp">
					<img src="/jsp_web/img/logo.png" class="logo">
				</a>
			</div>
			
			<!-- 본메뉴 -->
			<ul class="mainmenu">
				<li> <a href="/jsp_web/board/list.jsp?cno=1"> 공지사항 </a> </li>
				<li> <a href="/jsp_web/board/list.jsp?cno=2"> 커뮤니티 </a> </li>
				<li> <a href="/jsp_web/board/list.jsp?cno=3"> QnA </a> </li>
				<li> <a href="/jsp_web/board/list.jsp?cno=4"> 노하우 </a> </li>
				<li> <a href="/jsp_web/api/api1.jsp"> api1 </a> </li>
				<li> <a href="/jsp_web/api/api2.jsp"> api2 </a> </li>
				<li> <a href="/jsp_web/api/api3.jsp"> api3[과제] </a> </li>
				<li> <a href="/jsp_web/board/chatting.jsp"> 채팅 </a> </li>
				<li> <a href="/jsp_web/product/write.jsp"> 상품등록 </a> </li>
			</ul>
			
			<!-- 서브메뉴 -->
			<div class="submenu">
				<!-- bs : 드롭다운 -->
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<!-- jquery --> <!-- 모든페이지 공통 js -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 모달 js -->	
	<script src="/jsp_web/js/modal.js" type="text/javascript"></script>
	<!-- 사용자정의 js -->
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