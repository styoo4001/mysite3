<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<div id="header">
			<h1><a href="/mysite">MySite</a></h1>
			<ul>
					<c:choose>
				<c:when test="${not empty authUser }">
					<li><a href="">회원정보수정</a><li>
					<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a><li>
					<li>${authUser.name }님 안녕하세요 ^^;</li>
				</c:when>
				
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a><li>
					<li><a href="${pageContext.request.contextPath }/user/joinform">회원가입</a><li>
				</c:otherwise>
			</c:choose>
				
			</ul>
		</div>