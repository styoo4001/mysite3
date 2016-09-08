  
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%

//   List<GuestbookVo> list= (List<GuestbookVo>)request.getAttribute("list");

%>


<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery/jquery-1.9.0.js" ></script>


<script>

$(function(){
	
$("#checkout").click( function() {
		
		alert('test');
		
		var data={
				name:$("input[name='name']").val(),
				message:$("textarea[name='message']").val(),
				password:$("input[name='password']").val()
		}

 

			  $.ajax( {
			    url : "${pageContext.request.contextPath}/guestbook/api/insert",
			    type: "post",
			    dataType: "json",
			    data: JSON.stringify(data),
			//  contentType: "application/json",
			    success: function( response ){
			    	alert(response);
			  //     console.log( response );
			    },
			    error: function( jqXHR, status, error ){
			    	alert('faile');
			       console.error( status + " : " + error );
			    }

			   });

			 
	});
	
	/*
	$("iput[type='submit']").click( function(event) {
		
		event.preventDefault();
		alert('test');
	});
	


$("#check-email").click( function(){

	  $.ajax( {
	    url : "/api/checkEmail",
	    type: "get",
	    dataType: "json",
	    data: "",
	//  contentType: "application/json",
	    success: function( response ){
	       console.log( response );
	    },
	    error: function( jqXHR, status, error ){
	       console.error( status + " : " + error );
	    }

	   });

	});
	
	*/
});



</script>

</head>
<body>
	<div id="container">
		<div id="header">
			<h1>MySite</h1>
			<ul>
				<li><a href="">로그인</a><li>
				<li><a href="">회원가입</a><li>
				<li><a href="">회원정보수정</a><li>
				<li><a href="">로그아웃</a><li>
				<li>님 안녕하세요 ^^;</li>
			</ul>
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite3/guestbook/write" method="post">
			 
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="button"  id="checkout" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<%
				/*	
					int count = list.size();
					
					int index= 0;
					
					for( GuestbookVo vo : list){
						*/	
					 
						
					%>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach  items= "${list }"  var ="vo"  varStatus="status"> 
					
				
							<li>
							<table>
								<tr>
									<td>[${count-status.index }]</td>
									<td>${vo.name}</td>
									<td>${vo.regDate}</td>
									<td><a href="guestbook?a=deleteform&no=${vo.no}">삭제</a></td>
								</tr>
								<tr>
									<td colspan=4>
									${vo.message}	
									</td>
								</tr>
							</table>
							<br>
						</li>
				
					</c:forEach>
					<%	
					//}
					 %>
					
				</ul>
			</div>
		</div>
			<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<div id="footer">
			<p>(c)opyright 2014 </p>
		</div>
	</div>
</body>
</html>