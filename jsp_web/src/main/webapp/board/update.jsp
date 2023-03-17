<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : 글 쓰기 </title>
</head>
<body>

	<%@ include file = "/header.jsp" %>
	
	
	<%
		// jsp 로그인 여부 제어
		Object o = request.getSession().getAttribute("login");
		if( o == null ){
			response.sendRedirect("/jsp_web/member/login.jsp");
		}
		// 2. HTTP URL 안에 있는 매개변수 bno 호출
		String bno = request.getParameter("bno");
	%>
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
	
		<h3> 글 수정 </h3>
		
		<!--  -->
		<form class="updateForm">
			<div>
		카테고리 : <select name="cno" class="cno">
					<option value="1">공지사항</option>
					<option value="2">커뮤니티</option>
					<option value="3">QnA</option>
					<option value="4">노하우</option>
				</select>
			</div>
			<div>
		제목 : <input name="btitle" class="btitle" type="text">
			</div>
			<div>
		내용 : <textarea name="bcontent" class="bcontent" rows="3" cols="3"></textarea>
			</div>
			<div class="bfilebox">
		
			</div>
			<div>
		첨부파일 : <input name="bfile" type="file">
			</div>
			<button onclick="bupdate()" type="button"> 수정 </button>
		</form>
	</div>
	
	<script src="/jsp_web/js/board/update.js" type="text/javascript"></script>
</body>
</html>

<!--

	HTML ---- > form [ 동기식 : 페이지전환이 있음 ]
	<form action="통신할URL" method="HTTP메소드">
		1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송타입
		2. enctype="multipart/form-data"
	- 주의, form 태그 안에 있는 <button> type 생략시 type="submit"( 폼보내기 )
	
	vs JS ---- > AJAX [ 비동기 , 동기 ] 	
	
 -->