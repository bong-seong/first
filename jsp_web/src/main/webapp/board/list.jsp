<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : 게시물리스트 </title>
</head>
<body>

	<%@ include file = "/header.jsp" %>
	
	<div class="container">
	
		<h3> 게시물 목록 </h3>
		<a href="write.jsp"> 글 쓰기 </a>
		
		<table class="boardTable table table-hover">
		
		</table>
		
	</div>


	<script src="/jsp_web/js/board/list.js" type="text/javascript"></script>
</body>
</html>