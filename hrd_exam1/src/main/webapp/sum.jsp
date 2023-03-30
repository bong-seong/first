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
			<h1 class="title"> 회원 매출 조회 </h1>
			<div class="table_box">
				<table border="1" class="sum_table">
					<tr>
						<th> 회원번호 </th> <th> 회원성명 </th> <th> 고객등급 </th> <th> 매출 </th>
					</tr>
					
					<%
					
						Dao dao = new Dao();
						ArrayList<MemberDto> result = dao.getSum();
						
						for( MemberDto dto : result ){
							
					%>
					
					<tr>
						<td> <%=dto.getCustno()%> </td> <td> <%=dto.getCustname()%> </td> 
						<td> <%=dto.getGrade()%> </td> <td> <%=dto.getSum()%> </td>
					</tr>
					
					<%} %>
				</table>
			</div>
			
		</center>
		
		 
	</div>
	
	<%@ include file="footer.jsp" %>


</body>
</html>