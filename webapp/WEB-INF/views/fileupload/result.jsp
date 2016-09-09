<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

 
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"/>
		</div>
		<div id="content">
			<div style="margin:50px auto; width:500px;">
				<h1 style="margin-bottom:20px">Upload completed</h1>
				<div class="result-images">
					<img src="${pageContext.request.contextPath }/${urlImage1 }" style="width:150px"><br>
				</div>
				<p>
					<a href='${pageContext.request.contextPath }/fileupload/form'> 다시 업로드 하기 </a>
				</p>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp"/>
		</div>
		<div id="footer">
			<p>(c)opyright 2014 </p>
		</div>
	</div>	
</body>
</html>
