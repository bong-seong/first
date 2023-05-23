<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<center>
			<h3> 성적입력 </h3>
			<form name="scoreform" method="post" action="/HRD_0001/score" class="scoreform">
				<table border="1" style="border-collapse: collapse;">
					<tr><th> 학번 </th> <th> <input type="text" class="sno" id="sno" name="sno"> </th></tr>
					<tr><th> 국어점수 </th> <th> <input type="text" class="ekor" id="ekor" name="ekor"> </th></tr>
					<tr><th> 수학점수 </th> <th> <input type="text" class="emath" id="emath" name="emath"> </th></tr>
					<tr><th> 영어점수 </th> <th> <input type="text" class="eeng" id="eeng" name="eeng"> </th></tr>
					<tr><th> 역사점수 </th> <th> <input type="text" class="ehist" id="ehist" name="ehist"> </th></tr>
					<tr><th colspan="2"> <button type="button" onclick="scoreAdd()"> 등록하기 </button></th></tr>
				</table>
			</form>
		</center>
		
	<%@ include file="footer.jsp" %>
	
	<script src="index.js" type="text/javascript"></script>
	
</body>
</html>