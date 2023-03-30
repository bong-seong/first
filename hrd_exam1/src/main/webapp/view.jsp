<%@page import="hrd_기출문제1.model.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hrd_기출문제1.controller.Dao"%>
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
	<div class="body_color">
		<center>
			<h1 class="title"> 회원목록조회/수정 </h1>
			<form class="joinform">
				<table border="1" class="view_table">
					<tr>
						<th> 회원번호 </th> <th> 회원성명 </th> <th> 전회번호 </th>
						<th> 주소 </th> <th> 가입일자 </th> <th> 고객등급 </th>
						<th> 거주지역 </th>
					</tr>
					
					<%
						Dao dao = new Dao();
						ArrayList<MemberDto> result = dao.getMember(); 
						
						for( MemberDto dto : result ){
							
					%>
					<tr> <!--  -->
						<td> <a href="update.jsp?custno=<%=dto.getCustno()%>"><%=dto.getCustno()%></a> </td> <td> <%=dto.getCustname()%> </td> <td> <%=dto.getPhone()%> </td>
						<td> <%=dto.getAddress()%> </td> <td> <%=dto.getJoindate()%> </td> <td> <%=dto.getGrade()%> </td>
						<td> <%=dto.getCity()%> </td>
					</tr>
					
					<%} %>
				</table>
			</form>
		</center>
	</div>
	
	<%@ include file="footer.jsp" %>

</body>
</html>