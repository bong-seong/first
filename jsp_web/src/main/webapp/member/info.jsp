<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : 내프로필 </title>
	<link href="/jsp_web/css/info.css" rel="stylesheet">
</head>
<body>

	<%@ include file="/header.jsp" %>
	
	<div class="container">
		<h3> 회원정보 </h3>
		<div class="info_box">
			<div>
				<img class="mimg" alt="" src="/jsp_web/member/mimg/default.png">
			</div>
			<div class="info_text">
				<div class="text_item">
					<div> 아이디 </div>
					<div class="mid"></div>
				</div>
				<div class="text_item">
					<div> 이메일 </div>
					<div class="memail"></div>
				</div>
				<div class="text_item">
					<div> 보유포인트 </div>
					<div class="mpoint"></div>
				</div>
			</div>
		</div>
		
		<a href="/jsp_web/member/update.jsp"><button type="button" class="modi_button"> 회원수정 </button></a>
		<button onclick="openModal()" type="button" class="cancle"> 회원탈퇴 </button>
			
		<div class="modal_wrap">
			<div class="modal_box">
				<div class="modal_title">
					<p> 회원탈퇴를 계속 진행하시려면 패스워드를 한번 더 입력해주세요 </p>
				</div>
				<div class="modal_content">
					<input type="password" class="mpwd">
				</div>
				<div>
					<button onclick="setDelete()" type="button" class="confirm"> 탈퇴 </button>
					<button onclick="closeModal()" type="button" class="close"> 취소 </button>
				</div>
			</div>
		</div>
		
	</div>
	
	
	
	
	<!-- 사용자정의 js -->
	<script src="/jsp_web/js/member/info.js" type="text/javascript"></script>

</body>
</html>

	<!-- 
		동일한 HTML 에서 열리는 JS 파일은 메모리 공유
		* 단 먼저 호출된 js 순서
		* 주의 ajax	 
			1. $.ajax({})비동기통신 [ 요청보내고 응답의 결과를 기다리지 않음 ]
				
				
				요청				응답
				요청1 -------- >
				|				요청1 처리
				|
				|
				|
				요청2 -------- > 요청2 처리
				|
				|
				|
				|< ----------- 요청2 응답
				
			2. $.ajax({ async : false }) : 동기통신		
				요청				응답
				요청1 -------- >
								요청1 처리
									|
									|
									|
				    < -------- 	요청1 응답 
				|
				|
				|
				요청2 --------- > 요청2 처리
									|
									|
									|
				|	< --------	요청2 응답
				
	 -->