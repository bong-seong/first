<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day02</title>
</head>
<body>

	<div style="border : solid 1px green; margin-bottom: 50px;">
		
		<h3> 예1) [ C ] HTML --document.querySelector--> JS --AJAX--> servlet --메소드--> dao </h3>
		
		data1[ 문자열 ] 	: <input type="text" 			class="data1"> <br/>
		data2[ 패스워드 ] 	: <input type="password" 		class="data2"> <br/>
		data3[ 실수 ] 	: <input type="text" 			class="data3"> <br/>
		data4[ 정수 ] 	: <input type="number" 			class="data4"> <br/>
		data5[ 날짜 ] 	: <input type="date" 			class="data5"> <br/>
		data6[ 날짜/시간 ] : <input type="datetime-local" 	class="data6"> <br/>
		data7[ 선택버튼 ] 	: <input type="radio" name="data7" 	value="남"> 남
						  <input type="radio" name="data7" 	value="여"> 여	<br/>	
		data8[ 체크박스 ] 	: <input type="checkbox"	 	class="data8"> 승인	<br/>
		data9[ 목록상자 ] 	: <select 						class="data9">
								<option>안산</option><option>수원</option><option>성남</option>
						  </select>											<br/>
		data10[ 긴글 ]	: <textarea rows="" cols=""		class="data10"></textarea>
																			<br/>
		<button type="button" onclick="ex1()"> 전송 </button>
		
		<h3> 예1) [ R ] dao --메소드--> servlet --AJAX--> JS --document.querySelector--> HTML </h3>
		<div class="ex1_box">
		</div>
	</div>
	
	<div style="border : solid 1px blue; margin-bottom: 50px;">
		<h3> 과제2 : [ C ] 학생 명단 등록 </h3>
		이름 [ 문자열 ] : <input type="text" 			class="student_name"> <br/>
		전화번호		: <input type="text" 			class="student_phone"> <br/>
		키 [ 실수 ] 	: <input type="text" 			class="student_height"> <br/>
		나이 [ 정수 ] 	: <input type="number" 			class="student_age"> <br/>
		등록일 [ 날짜 ]	: <input type="date" 			class="student_reg_date"> <br/>
		성별 [ 선택버튼 ]	: <input type="radio" name="student_gender" 	value="남"> 남
						  <input type="radio" name="student_gender" 	value="여"> 여		<br/>
		개인정보동의여부[ 체크박스 ] 	: <input type="checkbox"	 	class="student_agreed"> 승인	<br/>
		주소[ 목록상자 ] 	: <select 						class="student_area">
								<option>안산</option><option>수원</option><option>성남</option>
						  </select>															<br/>
		자기소개[ 긴글 ]	: <textarea rows="" cols=""		class="student_about_me"></textarea>
						 																	<br/>
		<button type="button" onclick="add_student_info()"> 등록 </button>
	
		
		<h3> 과제2 : [ R ] : 학생 명단 출력 </h3>
		<div class="student_info_box">
		</div>
			
	</div>
	
	
	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="index.js" type="text/javascript"></script>
	
</body>
</html>