<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<<div class="alert alert-danger" role="alert" style='    text-align: center;'>${message}</div>
	<table class= "table table-hover table-bordered ">
	<tr class="bg-info">
		<th >Username</th>
		<th>Password</th>
		<th>Fullname</th>
		<th></th>
		<th></th>
		</tr>
		<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.username }</td>
			<td>${u.password }</td>
			<td>${u.fullname }</td>
			<td><a href="update/${u.username}.htm">Update</a></td>
			<td><a href="delete/${u.username}.htm">Delete</a></td>
		</tr>
		
		</c:forEach>
		
	
	</table>
</body>
</html>