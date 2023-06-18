<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<base href="${pageContext.servletContext.contextPath}/">
<style >
	div{
		display:inline-block;
		text-align:center;
		margin:5px;
		padding:5px;
		border:1px dotted orangered;
		border-radius:5px;
	}
	img{
	height: 350px;
  		width: 250px;}
</style>
</head>
<body>
 <h1>EL & JSTL</h1>
 <div>
 	<img src="${applicationScope.photo}">
 	<br>
 	<strong>${applicationScope.name}</strong>
 	<em>${salary*applicationScope.level}</em>
 </div>
  <div>
 	<img src="${sessionScope.photo}">
 	<br>
 	<strong>${sessionScope.name}</strong>
 	<em>${salary*sessionScope.level}</em>
 </div>
  <div>
 	<img src="${requestScope.photo}">
 	<br>
 	<strong>${requestScope.name}</strong>
 	<em>${salary*requestScope.level}</em>
 </div>
 
</body>
</html>