<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : ADMIN INFO </title>
	<link href="/jsp_web/css/admininfo.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>
	<div class="user_list_box">
		<h3> 모든 회원 명단 </h3>
		<p class="total_user"></p> 
		<div class="submenu_box">
			<button type="button" onclick="alluser()"> 전체보기 </button>
			<select class="listsize" onchange="setListsize()">
				<option>3</option>
				<option>5</option>
				<option>10</option>
			</select>
		</div>
		
		<table class="info_table table">
		</table>
		
		<div class="info_page_btn">
			
		</div>
		
		<div class="user_serach_box">
			<select class="key">
				<option value="mno"> 번호 </option>
				<option value="mid"> 아이디 </option>
				<option value="memail"> 이메일 </option>
			</select>
			<div class="search_box">
				<input type="text" class="keyword">
				<button onclick="user_search()" type="button" class="searchinput"> 검색 </button>
			</div>
		</div>
		
	</div>
	
	<script src="/jsp_web/js/admin/info.js" type="text/javascript"></script>
</body>
</html>