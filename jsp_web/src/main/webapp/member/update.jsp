<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : UPDATE </title>
</head>
<body>

	<%@ include file="/header.jsp" %>
	
	<div class="container">
		<h3> 회원정보 수정 </h3>
		<form class="updateForm">
			<div>
				<div>
					<img class="mimg" alt="" src="/jsp_web/member/mimg/default.png"> <br/>
					프로필 변경 : <input type="file" name="newmimg"> <br/>
					<input name="defaultimg" class="defaultimg" type="checkbox"> 기본프로필 사용
					 
				</div>
				<div>
					<div> 아이디 </div>
					<input name="mid" class="mid" disabled="disabled"></input>
				</div>
				<div>
					<div> 현재비밀번호 </div>
					<input name="mpwd" class="mpwd" type="password"></input>
				</div>
				<div>
					<div> 새 비밀번호 </div>
					<input name="newmpwd" class="newmpwd" type="password"></input>
				</div>
				<div>
					<div> 새 비밀번호 확인</div>
					<input class="newmpwdconfirm" type="password"></input>
				</div>
				<div>
					<div> 새 이메일 </div>
					<input name="memail" class="memail"></input>
					<button type="button">인증</button>
				</div>
				
				<button onclick="setUpdate()" type="button"> 회원수정 </button>			
			</div>
		</form>
		
		<div class="modal_wrap">
			<div class="modal_box">
				<div class="modal_title">
					<h4> 회원정보가 수정되었습니다. </h4>
				</div>
				<div class="modal_content">
					<p> 비밀번호 변경으로, 재로그인이 필요합니다. </p>
				</div>
				<div>
					<button onclick="closeModalPlus()" type="button" class="close"> 확인 </button>
				</div>
			</div>
		</div>
		
	</div>
	

	<script src="/jsp_web/js/member/update.js" type="text/javascript"></script>
</body>
</html>

