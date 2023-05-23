<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
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
		<h3> 학생성적 </h3>
		<table border="1" style="border-collapse: collapse; text-align: center;" width="700px">
			<tr>
				<th> 학년 </th>
				<th> 반 </th>
				<th> 번호 </th>
				<th> 이름 </th>
				<th> 국어 </th>
				<th> 수학 </th>
				<th> 영어 </th>
				<th> 역사 </th>
				<th> 합계 </th>
				<th> 평균 </th>
				<th> 순위 </th>
			</tr>
			
			<%
				Dao dao = new Dao();
				List<Dto> list = dao.getScore();
				
				DecimalFormat df = new DecimalFormat("#.#");
				
				double count = 0; // 점수가 있는 학생 수 
				
				int korSum = 0;
				int mathSum = 0;
				int engSum = 0;
				int histSum = 0;
				int sumSum = 0;
				double avgSum = 0;
				
				for( int i=0; i<list.size(); i++ ){
					
					Dto dto = list.get(i);
				
			%>
				<tr>
					<td><%=dto.getSno().charAt(0)%></td>
					<td><%=dto.getSno().charAt(1)+""+dto.getSno().charAt(2)%></td>
					<td><%=dto.getSno().charAt(3)+""+dto.getSno().charAt(4)%></td>
					<td><%=dto.getSname()%></td>
					<td><%=dto.getEkor() == 0 ? "" : dto.getEkor()%></td>
					<td><%=dto.getEmath() == 0 ? "" : dto.getEmath()%></td>
					<td><%=dto.getEeng() == 0 ? "" : dto.getEeng()%></td>
					<td><%=dto.getEhist() == 0 ? "" : dto.getEhist()%></td>
					<td><%=dto.getSum() == 0 ? "" : dto.getSum()%></td>
					<td><%=dto.getAvg() == 0 ? "" : df.format( dto.getAvg() )%></td>
					<td><%=dto.getSum() == 0 ? "" : dto.getRank()%></td>
				</tr>
			<%
					korSum += dto.getEkor();
					mathSum += dto.getEmath();
					engSum += dto.getEeng();
					histSum += dto.getEhist();
					sumSum += dto.getSum();
					avgSum += dto.getAvg();
					
					if( dto.getSum() != 0 ){
						count++ ;
					}
					
				}
				
				double korAvg = korSum/count ;
				double mathAvg = mathSum/count ;
				double engAvg = engSum/count ;
				double histAvg = histSum/count ;
				double sumAvg = sumSum/count ;
				double avgAvg = avgSum/count ;
				
			%>
			
			<tr>
				<td colspan="4"> 총합 </td> 
				<td><%=korSum%></td> 
				<td><%=mathSum%></td> 
				<td><%=engSum%></td> 
				<td><%=histSum%></td> 
				<td><%=sumSum%></td> 
				<td><%=df.format(avgSum)%></td> 
				<td> </td>
			</tr>
			
			<tr>
				<td colspan="4"> 총평균 </td> 
				<td><%= df.format(korAvg) %></td> 
				<td><%= df.format(mathAvg) %></td> 
				<td><%= df.format(engAvg) %></td> 
				<td><%= df.format(histAvg) %></td> 
				<td><%= df.format(sumAvg) %></td> 
				<td><%= df.format(avgAvg) %></td> 
				<td> </td>
			</tr>
			
		</table>
	</center>
	
	<%@ include file="footer.jsp" %>
</body>
</html>

<!-- 
	select 
		s.sno , 
		s.sname , 
		e.ekor , 
		e.emath , 
		e.eeng , 
		e.ehist , 
		( e.ekor + e.emath + e.eeng + e.ehist ) as total,
		(( e.ekor + e.emath + e.eeng + e.ehist )/4) as avg
	from student_tbl_03 s , exam_tbl_03 e
	where s.sno = e.sno order by avg desc
	
	
	select sno , sname  , null , null , null , null , null , null from student_tbl_03 
		union
	select
		sno ,
		null,
		ekor , 
		emath , 
		eeng , 
		ehist , 
		( ekor + emath + eeng + ehist ) as total,
		(( ekor + emath + eeng + ehist )/4) as avg 
	from exam_tbl_03 ;
	
	
	select
		s.sno , 
		s.sname , 
		e.ekor , 
		e.emath , 
		e.eeng , 
		e.ehist , 
		( e.ekor + e.emath + e.eeng + e.ehist ) as total,
		(( e.ekor + e.emath + e.eeng + e.ehist )/4) as avg,
		RANK() OVER ( order by ( nvl( e.ekor , 0 )  + nvl( e.emath , 0 ) + nvl( e.eeng , 0 ) + nvl( e.ehist , 0 ) ) desc ) as rank 
	from student_tbl_03 s full outer join exam_tbl_03 e on s.sno = e.sno ; 
	
	
	
 -->