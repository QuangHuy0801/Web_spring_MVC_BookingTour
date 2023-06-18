<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="insert.htm" modelAttribute="user">
	<div>
		<label>Username</label>
		<form:input path="username"/>
	</div>
	<br>
	<div>
		<label>Password</label>
		<form:input path="password"/>
	</div><br>
	<div>
		<label>Fullname</label>
		<form:input path="fullname"/>
	</div><br>
		<div>
	<button class="btn btn-default">insert</button>
	</div>
</form:form>
</body>
</html>