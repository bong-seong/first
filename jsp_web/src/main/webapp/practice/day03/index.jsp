<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Day03</title>
</head>
<body>

	<h3> 예제 1 : HTTP 메소드</h3>
	<button type="button" onclick="doPOST()"> POST 메소드 </button>
	<button type="button" onclick="doGET()"> GET 메소드 </button>
	<button type="button" onclick="doPUT()"> PUT 메소드 </button>
	<button type="button" onclick="doDELETE()"> DELETE 메소드 </button>
	
	<h3> 예제 2 : 비회원 방문록 </h3>
	<table border="1" class="input_box">
		<tr>
			<td>내용 : </td>
			<td> 
				<input type="text" class = "content">
			</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td> 
				<input type="text" class = "writer">
			</td>
		</tr>
		<tr>
			<td cols="2">
				<button onclick="onwrite()" type="button"> 방문록 등록</button>
			</td>
		</tr>
	</table>
	
	<div class="content_box">
	</div>
	
	<!--
		jsp, js 기존파일 사용
		(dao) , dto , servlet 새로 파일 만들기
		
		과제3
		
			1. 제품등록 [ 제품명 , 가격 ]
			2. 제품출력 [ 테이블에 모두 출력 ]
			3. 제품삭제 [ 제품명 , 가격수정 ]
			4. 제품수정 [ 제품명 , 가격수정 = prompt 수정할 데이터 입력받기 ]
	 -->
	
	<div style="border: solid 1px blue; margin-top: 100px;">
	
	<h3> 과제3 : 제품 [ C , R , U , D ]</h3>
	
		<table border="1" class="input_box">
			<tr>
				<td>제품명 : </td>
				<td> 
					<input type="text" class = "product">
				</td>
			</tr>
			<tr>
				<td>가격 : </td>
				<td> 
					<input type="text" class = "price">
				</td>
			</tr>
			<tr>
				<td cols="2">
					<button onclick="onadd()" type="button"> 제품등록</button>
				</td>
			</tr>
		</table>
		
		<table border="1" style="margin-top: 30px;" class="prod_table">
		</table>
	</div>
	
	
	
	
	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. 사용자 정의 JS ( 위에서부터 아래로 흐르기때문에 사용자정의가 위에있으면 ajax 동작에 이상이 생김 --> 
	<script src="index.js" type="text/javascript"></script>

</body>
</html>