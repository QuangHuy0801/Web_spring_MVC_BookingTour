<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.servletContext.contextPath }/">
<title>Tiêu đề</title>
<style>
	img{
	max-height:500px;
	max-width:500px
	}
</style>
</head>
<body>
	<div>
	<h3>Thông tin cá nhân</h3>
	<img src="files/${photo_name}">
	<br>
	<h3>${param.fullname }</h3>
	</div>
	<div>
		<h3>Hồ sơ xin việc</h3>
		<ul>
			<li>File Name :${cv_name }</li>
			<li>File Type : ${cv_type}</li>
			<li>File Size: ${cv_size }</li>
		</ul>
	</div>
</body>
</html>