<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
	<!-- 
		<div id="header">
			<h1><a href="/mysite">MySite</a></h1>
			<ul>
					<c:choose>
				<c:when test="${not empty authUser }">
					<li><a href="">회원정보수정</a><li>
					<li><a href="">로그아웃</a><li>
					<li>${authUser.name }님 안녕하세요 ^^;</li>
				</c:when>
				
				<c:otherwise>
					<li><a href="">로그인</a><li>
					<li><a href="">회원가입</a><li>
				</c:otherwise>
			</c:choose>
				
			</ul>
		</div>
		 -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="<%=request.getContextPath() %>/assets/images/profile.jpg">
					<h2>안녕하세요. 안대혁의  mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는  웹 프로그램밍 실습과제 예제 사이트입니다.<br>
						메뉴는  사이트 소개, 방명록, 게시판이 있습니다.<br>
						JAVA 수업 + 데이터베이스 수업 + Servlet/JSP + Spring MVC + JPA(Hibernate) 수업 배운 거 있는거 없는 거 다 합쳐서
						만들어 놓은 사이트 입니다.<br><br>
						<a href="#">방명록</a>에 글 남기기<br>
					</p>
				</div>
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