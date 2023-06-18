<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student-mgr</title>
</head>
<body>
<h1>STUDENT MANAGER</h1>
<form action="student-mgr.htm" method="post">
	<div>Họ và tên</div>
	<input name="name"/>

	<div>Điểm trung bình</div>
	<input name="mark"/>

	<div>Chuyên ngành</div>
	
	<label>
	<input name="major" type ="radio" value ="APP"/>
	Ứng dụng phần mềm
	</label>
	
	<label>
	<input name="major" type ="radio" value ="WEB"/>
	Thiết kế trang web
	</label>

<hr>
<button name="btnInsert">Thêm</button>
<button name="btnUpdate">Cập nhập</button>
<button name="btnDelete">Xóa</button>
<button name="btnReset">Nhập lại</button>
</form>

<hr>
<table border="1" style="width:100%">
	<tr>
		<th>Họ và tên</th>
		<th>Điểm TB</th>
		<th>Chuyên ngành</th>
		<td></td>
	</tr>
	<tr>
		<td>Võ Quang Huy</td>
		<td>9.0</td>
		<td>CNTT</td>
		<td> <a href="student-mgr.htm?lnkEdit">Sửa</a></td>
		<tr>
		<td>Nguyễn Văn A</td>
		<td>7.5</td>
		<td>MUL</td>
		<td> <a href="student-mgr.htm?lnkEdit">Sửa</a></td>
	</tr>			
</table>
</body>
</html>