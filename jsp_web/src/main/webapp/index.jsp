<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <!-- 가로/세로 사이즈 생략시 auto( 내용물 크기만큼 ) -->
<head>
	<meta charset="UTF-8">
	<title> JSP 수업 : INDEX </title>
</head>
<body>

	<%@ include file="/header.jsp" %> <!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="search_box">
		검색창
	</div>
	
	
	<div class="contentbox">
		<div id="map" style="width:75%;height:100%;"></div>
	
		<!-- 사이드바 -->	
		<div class="productlistbox">
			
		</div>
		
	</div>
	
	
	
	<%@ include file="/footer.jsp" %> 
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<script src="/jsp_web/js/index.js" type="text/javascript"></script>
</body>
</html>

<%-- 

		<% // 스크립트 태그
			String str = "유재석";
		%>
		<!--
		<h3> <%= str %> </h3>
  		-->
 --%>
 
 			<!-- 
 			<div class="productbox">
				<div class="pimgbox">
					<img src="/jsp_web/product/pimg/default.png">
				</div>
				<div class="pcontentbox">
					<div class="pdate"> 2023-03-28 </div>
					<div class="pname"> 노트북 팔아요 노트북 팔아요 노트북 팔아요 노트북 팔아요</div>
					<div class="pprice"> 2,000,000원 </div>
					<div class="petc">
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2
					</div>
				</div>
			</div>
			
			-->
			
			
			<!-- 
			<div class="pviewbox">
			
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jsp_web/member/mimg/default.png" class="hpimg">
						qweqwe
					</div>
					<div>
						<button class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
			
				
				<div id="carouselExampleControls" class="carousel carousel-dark slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/jsp_web/product/pimg/default.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jsp_web/product/pimg/default.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jsp_web/product/pimg/default.png" class="d-block w-100" alt="...">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				
				
				<div class="pdate"> 2023-03-28 </div>
				<div class="pname"> 물건팔아요 </div>
				<div class="pstate"> 판매중 </div>
				<div class="pcomment"> 물건이 아주 좋아요 </div>
				<div class="pprice"> 100,000원 </div>
				<div class="petc">
					<i class="far fa-eye"></i> 30
					<i class="far fa-thumbs-up"></i> 5
					<i class="far fa-comment-dots"></i> 2 
				</div>
				<div class="pviewbtnbox"> 
					<button type="button" class="likebtn"> <i class="far fa-heart"></i> </button>
					<button type="button" class="notebtn"> <i class="far fa-paper-plane">  </i> </button> 
				</div>
				
			</div>
			-->
			
			<!-- 
			<div class="chatbox">
						
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jsp_web/product/pimg/default.png" class="hpimg">
						<span class="pname"> 물건팝니다. </span>
					</div>
					<div>
						<button onclick="productlistprint( )" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				
				<div class="chatcontent">
					<div class="sendbox"> 구매 가능할까요 ? </div>
					<div class="recvbox"> 네 구매 가능합니다. </div>
				</div>
				
				<div class="chatbtn">
					<textarea rows="" cols=""></textarea>
					<button type="button"> Send </button>
				</div>
				
			</div>
			-->
			
			
			<!-- 해당 제품으로부터 채팅을 받은 목록 
			<div class="chatlist">
				<div class="frommimg">
					<img scr="/jsp_web/member/mimg/default.png" class="hpimg">
				</div>
				<div class="frominfo">
					<div class="fromndate"> 2023-03-29 10:01 </div>
					<div class="frommid"> qweqwe </div> 
					<div class="fromncontent"> 구매할게요 구매할게요 구매할게요 구매할게요 </div>
				</div>
			</div>
			-->