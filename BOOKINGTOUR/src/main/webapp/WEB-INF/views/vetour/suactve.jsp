
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<link href='assets/css/trangchu.css' rel='stylesheet'>
<link href='assets/css/all.css' rel='stylesheet'>
<head>
<title>Admin quản lý du lịch</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
	integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
	crossorigin="anonymous"></script>
<style>
.dropdown-menu.show {
	left: -400px;
	background-color: aliceblue;
}
</style>


</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<c:if test="${sessionScope.TaiKhoan.isAdmin==1}">
			<%@ include file="../includes/Navbarc3.jsp"%></c:if>
			<c:if test="${sessionScope.TaiKhoan.isAdmin==0}">
			<%@ include file="../includes/Navbarnvc3.jsp"%></c:if>
			<div class="col py-3">
					<c:if test="${message==1}">
					<div class="alert alert-success fade show" role="alert"style='position: fixed; width:50%; margin-left:300px; z-index: 100 '>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>Sửa chi tiết vé viên thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
					<div class="alert alert-danger fade show"" role="alert"style='position: fixed; width:50%; margin-left:230px;'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>Sửa chi tiết vé thất bại</p>
						<hr>
					</div>
					</c:if>
					<c:if test="${message==3}">
					<div class="alert alert-danger fade show" role="alert"style='position: fixed; width:50%; margin-left:300px; z-index: 100 '>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>Tên địa điểm đã tồn tại</p>
						<hr>
					</div>
				</c:if>
					<c:set var="message" value="0" />
<button onclick="location.href = '../../dsve/${ctve.veTour.bookingTour1.id}.htm'"  class="btn btn-outline-secondary my-2 my-sm-0" type="submit"> << Trở lại</button>				<div class="container form-dang-nhap">
					<div class="modal-body">
					<div>
									<h1>Sửa vé</h1>
								</div>
						<form:form action="update.htm" modelAttribute="ctve">
							<div class="form-group">
								<div class="row" style="  display: none;" >
									<div class="col">
										<label for="recipient-name" class="col-form-label">ID  :</label> 
										<form:input path="id" type="text" class="form-control"  readonly="true" />
										</div>
										</div>
								<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">CCCD  :</label> 
										<form:input path="khachHang.cCCD" type="text" class="form-control"  readonly="true" />
										</div>
										</div>
								<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Họ và tên đệm  :</label> 
										<form:input path="khachHang.ho" type="text" class="form-control"   />
										</div>
										<div class="col">
										<label for="recipient-name" class="col-form-label">Tên  :</label> 
										<form:input path="khachHang.ten" type="text" class="form-control"   />
										</div>
										</div>
									
														
								 <div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Số điện thoại  :</label> 
										<form:input path="khachHang.sDT" type="text" class="form-control"   />
										</div>
										</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Email
											</label><form:input path="khachHang.email" type="text" class="form-control"  />
									</div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Ghi chú khách hàng
											</label><form:input path="khachHang.ghiChu" type="text" class="form-control"  />
									</div>
									</div>
									
								
								<div class="row">
									<div class="col">
									<label for="recipient-name" class="col-form-label">Vé tour :
											</label>
								 <form:select path="veTour.id" class="form-select" aria-label="Default select example">
											<c:forEach var="vetour" items="${vetours}">
 
     <form:option  value="${vetour.id}">Giá vé : ${vetour.giaVe} - Phí di chuyển : ${vetour.phiDiChuyen} - ${vetour.loaiVe.ten}</form:option>
  
  </c:forEach>
  
 </form:select></div>
									</div>
									
								<div class="row">
									<div class="col">
									<label for="recipient-name" class="col-form-label">Khuyến mãi :
											</label>
								 <form:select path="khuyenMai.id" class="form-select" aria-label="Default select example">
											<c:forEach var="khuyenMai" items="${dotkhuyenmai}">
 
     <form:option  value="${khuyenMai.id}">${khuyenMai.ten} : giảm : ${khuyenMai.phanTramGiam} % -  Thời gian ${khuyenMai.tGBD}  -  ${khuyenMai.tGKT}</form:option>
  
  </c:forEach>
  
 </form:select></div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">CCCD nhân viên xác nhận
											</label><form:input path="nhanVienXN.cCCD" type="text" class="form-control" readonly="true" />
									</div>
									<div class="col">
										<label for="recipient-name" class="col-form-label">Nhân viên xác nhận : 
											</label>  ${tennvXN }
											
									</div>
									
									</div>
 </div>
							 <form:button class="btn btn-primary">cập nhập </form:button>
						</form:form>
					</div>
				</div>
				<div class="modal-footer">
					<div style='display: block;'>
						<input type="text" name="timkiem" placeholder=" Tìm kiếm"
							style='padding: 3px'>
					</div>

					
				</div>
			</div>
		</div>
	</div>
<script>
  setTimeout(function() {
    document.querySelector('.alert').classList.add('d-none');
  }, 2000);
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>