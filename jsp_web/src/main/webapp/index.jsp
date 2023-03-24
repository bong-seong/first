<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;"> <!-- 가로/세로 사이즈 생략시 auto( 내용물 크기만큼 ) -->
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : INDEX </title>
	<link href="/jsp_web/css/index.css" rel="stylesheet">
	
</head>
<body style="height: 100%;">

	<%@ include file="/header.jsp" %> <!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox">
		검색창
	</div>
	
	
	<div style="display: flex; width: 100%; height: 100%;">
		<div id="map" style="width:80%;height:80%;"></div>
	
		<!-- 사이드바 -->	
		<div class="productlistbox" style="width: 20%"></div>
	</div>
	
	<%@ include file="/footer.jsp" %> 
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<script src="/jsp_web/js/index.js" type="text/javascript"></script>
</body>
</html>

<%-- 

		<% // 스크립트 태그
			String str = "유재석";
		%>
		<!--
		<h3> <%= str %> </h3>
  		-->
 --%>