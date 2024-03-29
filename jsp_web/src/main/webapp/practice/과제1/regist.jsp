<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 과제1 : 인사등록 </title>

<link href="/jsp_web/practice/과제1/css/regist.css" rel="stylesheet">

</head>
<body>
	<div class="reg_wrap">
		<div class="regist">
			<h3> 인사등록 </h3>
			<form class="reg_form">
				<table class="reg_table">
					<tr>
						<td class="table_left"> 사원명 : </td>
						<td>
							<input type="text" class="name" name="name" onkeyup="name_check()" maxlength="10">
							<div class="notice"></div>
						</td>
					</tr>
					<tr>
						<td> 부서 : </td>
						<td>
							<select class="part" name="part">
								
							</select>
						</td>
					</tr>
					<tr>
						<td> 직급 : </td>
						<td>
							<select class="jobgrade" name="jobgrade">
								<option value=""> 직급을 선택하세요 </option>
								<option> 사원 </option>
								<option> 대리 </option>
								<option> 과장 </option>
								<option> 부장 </option>
								<option> 대표이사 </option>
							</select>
						</td>
					</tr>
					<tr>
						<td> 고용형태 : </td>
						<td>
							<select class="type" name="type">
								<option value=""> 고용형태를 선택하세요 </option>
								<option> 정규직 </option>
								<option> 계약직 </option>
								<option> 임원 </option>
							</select>
						</td>
					</tr>
					<tr>
						<td> 미리보기 </td>
						<td>
							<img class="preview" src="/jsp_web/practice/과제1/img/default.png">
						</td>
					</tr>
					<tr>
						<td> 파일 : </td>
						<td>
							<input onchange="preimg(this)" type="file" class="img" name="img">
						</td>
					</tr>
					<tr>
						<td class="button_area" colspan="2">
							<button class="reg_btn1" type="button" onclick="regist()"> 등록 </button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<form>
			<div class="reg_part">
				<h3> 부서등록 </h3>
				<table class="reg_table">
						<tr>
							<td class="table_left"> 부서명 : </td>
							<td>
								<input type="text" class="partname" name="partname" maxlength="10">
								<div class="notice"></div>
							</td>
						</tr>
						<tr>
							<td class="table_left"> 관리자 : </td>
							<td>
								<input type="text" class="manager" name="manager" maxlength="10">
								<div class="notice"></div>
							</td>
						</tr>
						<tr>
							<td class="button_area" colspan="2">
								<button class="reg_btn1" type="button" onclick="regist_part()"> 등록 </button>
							</td>
						</tr>
				</table>
			</div>
		</form>
	</div>
	
	<%@ include file="print.jsp" %>
	


	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jsp_web/practice/과제1/js/regist.js" type="text/javascript"></script>
</body>
</html>