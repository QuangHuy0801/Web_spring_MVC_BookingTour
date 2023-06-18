<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div>
<form:form action="insert.htm" modelAttribute="record" class="form-horizontal">
	${message}
		<div class="form-group">
			<label>Nhân viên</label>
			 <form:select path="staff.id" items="${staffs}" itemValue="id" itemLabel="name"> </form:select> 
		</div>
		<div class="form-group">
			<label>Loại</label>
			<form:radiobutton path="type" value="true" label="Thành tích"></form:radiobutton>
			<form:radiobutton path="type" value="false" label="Kỷ luật"></form:radiobutton>
		</div>
		<div class="form-group">
			<label>Lý do</label>
			<form:textarea path="reason" rows="3"/>
		
		</div >
		<div class="form-group">
			<button>Insert</button>
		</div>
	</form:form>
	</div>
</body>
</html>