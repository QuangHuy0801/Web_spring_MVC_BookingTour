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
		<th >Mã NV</th>
		<th>Tổng thành tích</th>
		<th>Tổng kỷ luật</th>
		<th>Tổng kết</th>
		</tr>
		<c:forEach var="a" items="${arrays}">
		<tr>
			<td>${a[0]}</td>
			<td>${a[1] }</td>
			<td>${a[2]}</td>
			<td>${a[1]-a[2] }</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
</body>
</html>