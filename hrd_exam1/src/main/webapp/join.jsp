<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="hrd_기출문제1.controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="join_body">

	<%@ include file="header.jsp" %>
	
	<%
		// JSP 이용한 서블릿 대체
		Dao dao = new Dao();
		int custno = dao.getcustno();
		
		// 2. 오늘날짜
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(date);
		
	%>
	
	<div class="body_color">
		<center>
			<h1 class="title"> 홈쇼핑 회원 등록 </h1>
			
			<!--  -->
			
			<form name="joinform" method="post" action="http://192.168.17.34:8080/hrd_exam1/join" class="joinform">
				<table border="1" class="join_table">
					<tr>
						<td class="table_text"> 회원번호(자동발생) </td>
						<td>
							<input name="custno" class="custno" type="text" value="<%=custno%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원성명 </td>
						<td>
							<input name="custname" class="custname" type="text">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원전화 </td>
						<td>
							<input name="phone" class="phone" type="text">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원주소 </td>
						<td>
							<input name="address" class="address" type="text">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 가입일자 </td>
						<td>
							<input name="joindate" class="joindate" type="text" value="<%=now%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 고객등급[ A:VIP, B:일반, C:직원 ] </td>
						<td>
							<input name="grade" class="grade" type="text">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 도시코드 </td>
						<td>
							<input name="city" class="city" type="text">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<button onclick="join()" type="button"> 등록 </button>
								<a href="view.jsp"><button type="button"> 조회 </button></a>
							</center>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	
	
	
	
	<%@ include file="footer.jsp" %>



	<script src="join.js" type="text/javascript"></script>
</body>
</html>