<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div style="margin: 50px auto; width: 500px;">
				<h1 style="margin-bottom: 20px">파일 업로드 예제</h1>
				<form method="post" action="<%=request.getContextPath() %>/fileupload/upload" enctype="multipart/form-data">
					<label>email:</label> <input type="text" name="email"
						value="kickscar@gmail.com"> <br>
					<br> <label>파일1:</label> <input type="file" name="file1">
					<br>
					<br> <label>파일2:</label> <input type="file" name="file2">
					<br>
					<br> <br> <input type="submit" value="upload">
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>
