<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.servletContext.contextPath }/">
<title>Send email</title>
</head>
<body>
	${message }
	<form action="mailer/send.htm" method ="post">
	<p><input name="form" placeholder="Form"></p>
	<p><input name="to" placeholder="To"></p>
	<p><input name="subject" placeholder="Subject"></p>
	<p><textarea name="body" placeholder="Body" rows="3" cols="30">
	</textarea></p>
	<p>
	<button>Send</button>
	</form>

</body>
</html>