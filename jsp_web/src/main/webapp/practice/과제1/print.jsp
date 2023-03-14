<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jsp_web/practice/과제1/print.css" rel="stylesheet">
</head>
<body>
	<div class="print_wrap">
		<h3> 인사 관리 </h3>
		<div class="btn_box">
			<div>
				<button type="button" onclick="print(0)" class="reg_btn"> 전체출력 </button>
				<button type="button" onclick="print(1)" class="reg_btn"> 재직 </button>
				<button type="button" onclick="print(2)" class="reg_btn"> 퇴사 </button>
			</div>
			<div>
				검색(이름) : <input type="text" class="search">
				<button type="button" onclick="print(3)" class="reg_btn"> search </button> 
			</div>
		</div>
		<table class="printTable" border="1">
		</table>
	</div>
	
	
	
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button class="modal_check" type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	
	
	
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자정의 js -->
	<script src="/jsp_web/practice/과제1/js/regist.js" type="text/javascript"></script>
	<script src="/jsp_web/practice/과제1/print.js" type="text/javascript"></script>
</body>
</html>