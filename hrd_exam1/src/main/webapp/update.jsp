<%@page import="hrd_기출문제1.controller.Dao"%>
<%@page import="hrd_기출문제1.model.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
	
	<%
		int custno = Integer.parseInt( request.getParameter("custno") );
		
		Dao dao = new Dao();
		MemberDto dto = dao.getM( custno );
		
	%>
	
	<div class="body_color">
		<center>
			<h1 class="title"> 홈쇼핑 회원 정보 수정 </h1>
			
			<!--  -->
			
			<form name="updateform" method="get" action="/hrd_exam1/join" class="joinform">
				<table border="1" class="join_table">
					<tr>
						<td class="table_text"> 회원번호(자동발생) </td>
						<td>
							<input name="custno" class="custno" type="text" value="<%=dto.getCustno()%>" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원성명 </td>
						<td>
							<input name="custname" class="custname" type="text" value="<%=dto.getCustname()%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원전화 </td>
						<td>
							<input name="phone" class="phone" type="text" value="<%=dto.getPhone()%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 회원주소 </td>
						<td>
							<input name="address" class="address" type="text" value="<%=dto.getAddress()%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 가입일자 </td>
						<td>
							<input name="joindate" class="joindate" type="text" value="<%=dto.getJoindate()%>">
						</td>
					</tr>
					<tr>
						<td class="table_text"> 고객등급[ A:VIP, B:일반, C:직원 ] </td>
						<td>
							<input name="grade" class="grade" type="text" value="<%=dto.getGrade()%>">
						</td>
					</tr>
					<tr>
						<td > 도시코드 </td>
						<td>
							<input name="city" class="city" type="text" value="<%=dto.getCity()%>">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<button onclick="onupdate()" type="button"> 수정 </button>
								<a href="view.jsp"><button type="button"> 조회 </button></a>
							</center>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	
	<script type="text/javascript">
		
		function onupdate(){
			document.updateform.submit();
			alert('수정 성공');
		}
		
	
	</script>
	
	<%@ include file="footer.jsp" %>

</body>
</html>