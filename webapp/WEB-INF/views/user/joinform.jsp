<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/user.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/jquery/jquery-1.9.0.js"></script>

<script>


 
$(function(){
	   
//	$("input[type='button']").click(function(){
	$("#emailcheck").click(function(){
		
		 
		
		var email= $("#email").val();
		
		if(email==""){
			
			return;
		}
		
		$.ajax({
			
		 
			url: "${pageContext.request.contextPath}/user/api/checkemaildto?email="+email,
			type: "get",
			dataType: "json",
			data: "",
			//contentType: "applicatipn/json"
			success: function(response){
				
				if(response.result=="fail"){
				
					console.error( response.message);
					return;
					
				}
				if(response.data==false){
				
					alert("사용중입니다");
					return;
				
				}
			},
			error: function(jqXHR, status, error){
				console.log(status+ ":" +error);
			}
		});
		
	 
	});
	
});


</script>



</head>
<body>
	<div id="container">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		
		
		
		<div id="content">
		
		
		
		
			<div id="user">

				<form id="join-form" name="joinForm" method="post"
					action="${pageContext.request.contextPath }/user/join">

					<label class="block-label" for="name">이름1</label> <input id="name"
						name="name" type="text" value="">

					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('name') }">
							<p style="text-align: left; color: red">
								<strong>${errors.getFieldError( 'name' ).defaultMessage }</strong>
							</p>
						</c:if>
					</spring:hasBindErrors>


					<label class="block-label" for="email">이메일</label> <input
						id="email" name="email" type="text" value="">
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('email') }">
							<c:set var="errorName"
								value="${errors.getFieldError( 'email' ).codes[0] }" />
							<strong style="color: red"> <spring:message
									code="${errorName }"
									text="${errors.getFieldError( 'email' ).defaultMessage }" />
							</strong>


						</c:if>
					</spring:hasBindErrors>
					<input type="button" id="emailcheck" value="email 중복체크"> <label
						class="block-label">패스워드</label> <input name="password"
						type="password" value="">
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('password') }">
							<p style="text-align: left; color: red">
								<strong>${errors.getFieldError( 'password' ).defaultMessage }</strong>
							</p>
						</c:if>
					</spring:hasBindErrors>

					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="FEMALE"
							checked="checked"> <label>남</label> <input type="radio"
							name="gender" value="MALE">
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">

				</form>
			</div>
		</div>
		<div id="navigation">
			<ul>
				<li><a href="">안대혁</a></li>
				<li><a href="">방명록</a></li>
				<li><a href="">게시판</a></li>
			</ul>
		</div>
		<div id="footer">
			<p>(c)opyright 2015</p>
		</div>
	</div>
</body>
</html>