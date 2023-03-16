<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : 게시물리스트 </title>
<link href="/jsp_web/css/list.css" rel="stylesheet">
</head>
<body>

	<%@ include file = "/header.jsp" %>
	<%
		// HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
		// 2. 표현식을 이용한 input , div 등등 대입
		
	%>
	<!-- cno 숨겨서 js에게 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<div class="container">
	
		<h3 class="cname"></h3>
		<div class="funcbtn">
			<button type="button" onclick="allboard()"> 전체보기 </button>
			<a href="write.jsp"> 글 쓰기 </a>
		</div>
		<div class="searchcount"> 총 게시물수 : </div>
		<select onchange="setListsize()" class="listsize">
			<option value="3">3</option>
			<option value="5">5</option>
			<option value="10">10</option>
		</select>
		<table class="boardTable table table-hover">
		
		</table>
		
		
		<!-- 페이징처리 버튼들 -->
		<div class="pagebox">
		</div>
		
		<!-- 검색창 -->
		<!-- 
			select * from board where 필드명 = 데이터
			select * from board where bno = 1;  
		-->
		<div class="searchbox"> 
			<div class="selectbox">
				<select class="key"> <!-- select 시 사용되는 필드명 -->
					<option value="b.btitle"> 제목 </option>
					<option value="b.bcontent"> 내용 </option>
					<option value="m.mid"> 작성자 </option>
				</select>
			</div>
			<div class="inputbox">
				<input type="text" class="keyword"> <!-- select 시 사용되는 조건의 데이터 -->
				<button onclick="getsearch()" type="button" id="searchbar"> 검색 </button>
			</div>
		</div>
		
	</div>


	<script src="/jsp_web/js/board/list.js" type="text/javascript"></script>
</body>
</html>