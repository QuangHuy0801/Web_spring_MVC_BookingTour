<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<div>
		<form:form action="validate2.htm" modelAttribute="student">
		<div class="text-danger">
		${message}
		</div>
			<div>Họ và tên</div>
			<form:input path="name" />
			<form:errors path="name" />
			<div>Điểm</div>
			<form:input path="mark" />
			<form:errors path="mark" />
			<div>Chuyên ngành</div>
			<form:radiobutton path="major" value="APP" label="Ứng dụng phần mềm" />
			<form:radiobutton path="major" value="WEB" label="Thiết kế trang web" />
			<form:errors path="major" />
			
			<div>
				<button>Validate 2</button>
			</div>
		</form:form>
	</div>
</body>
</html>