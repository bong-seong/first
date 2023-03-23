<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP 수업 : 채팅 </title>
<link href="/jsp_web/css/chatting.css" rel="stylesheet">
</head>
<body>

	<%@ include file="/header.jsp" %>
	
	<div class="container chattingwrap">
	
		<div class="conlistbox"> <!-- 접속 명단 표시 구역 -->
			
		</div>
		
		<div class="chattingbox">
		
			<div class="contentbox"> <!-- 채팅창 -->
			
			</div>
			
			<textarea onkeyup="enterkey()" class="msgbox" rows="3" cols=""></textarea>
			<div class="chattingbtnbox">
				
				<!-- 드롭다운 버튼 -->
				<button class="emobtn" type="button" data-bs-toggle="dropdown"> <i class="far fa-smile"></i> </button>
				
				<!-- 드롭다운 버튼 클릭시 보이는 구역 -->
				<div class="dropdown-menu emolist">
					
				</div>
				
				<button class="sendbtn" onclick="clientSend()" type="button"> 보내기 </button>
			</div>
		</div>
	
	</div>
	
	
	<script src="/jsp_web/js/board/chatting.js" type="text/javascript"></script>
	 
</body>
</html>

<!--

				
				<div class="sendcontent">
					<div class="date"> 오전 10:02 </div>
					<div class="content"> 안녕하세요 </div>
				</div>
				
				<div class="alarm">
					<span> 강호동님이 입장하셨습니다. </span>
				</div>
				
				<div class="recvcontent">
					<div> <img src="/jsp_web/member/mimg/default.png" class="hpimg"></div>
					<div class="rcontent">
						<div class="name"> 강호동 </div>
						<div class="contentdate">
							<div class="content"> 안녕 </div>
							<div class="date"> 오전 10:20 </div>
						</div>
					</div>
				</div>
 
 -->