<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> API3 : 과제 </title>
</head>
<body>

	<%@ include file = "/header.jsp" %>
	
	<div class="container">
		<div id="clickLatlng"></div> <!-- 클릭한 위치의 좌표 찾기 -->
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:700px;"></div>
	</div>
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	
	<!-- 카카오 지도 js -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<!-- 사용자정의 js -->
	<script src="/jsp_web/js/api/api3.js" type="text/javascript"></script>
</body>
</html>