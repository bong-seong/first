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
	
	<div class="container">
	
		<div class="chattingbox">
		
			<div class="contentbox"> <!-- 채팅창 -->
			
				
						
			</div>
			
			<textarea onkeyup="enterkey()" class="msgbox" rows="3" cols=""></textarea>
			<div class="chattingbtnbox">
				<div>이모티콘</div>
				<div>첨부파일</div>
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