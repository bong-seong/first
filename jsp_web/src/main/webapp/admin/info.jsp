<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : ADMIN INFO </title>
</head>
<body>

	<h3> 모든 회원 명단 </h3>
	<table class="info_table" border="1">
	</table>
	
	
	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="/jsp_web/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>