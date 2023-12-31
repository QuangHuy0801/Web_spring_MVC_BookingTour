<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
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
	left: -800px;
	background-color: aliceblue;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row flex-nowrap">
			
			<%@ include file="../includes/Navbarc1.jsp"%>
			
			
			<div class="col py-3">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand " href="themtuyenduong.htm"> <button type="button" class="btn btn-success"
																data-dismiss="modal">Thêm Tuyến đường</button></a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
       
      </li>
    </ul>
    <form action = "dstuyenduong.htm" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Tên" name = "timkiem" >
      <button style="
    margin: 20px;
" class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
      
    
    </form>
      <button onclick="location.href = 'dstuyenduong.htm'"  class="btn btn-outline-success my-2 my-sm-0" type="submit">Bỏ lọc</button>
  </div>
</nav>
				<c:if test="${message==1}">
				
					
					<div class="alert alert-success fade show" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>xóa tuyến đường thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>xóa tuyến đường thất bại</p>
						<hr>
					</div>
				</c:if>
				
            <c:set var="message" value="0" />
				<div class="container form-dang-nhap">
					
					<h2>Danh sách tuyến đường</h2>
					<br>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">STT</th>
								<th scope="col">Thông tin tuyến đường</th>
								<th scope="col">Danh sách xe</th>
								<th scope="col">Chi tiết tuyến đường</th>
								<th scope="col">Xử lý</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="counter" value="${offset+1 }" />
							<c:forEach var="tuyenduong" items="${tuyenduongs}">

								<tr>
									<th scope="row">${counter}</th>
									<td ><h4>${tuyenduong.ten}</h4>
									<h6 class="font-weight-normal"> Giản cách :${tuyenduong.gianCach}</h6><h6 class="font-weight-normal">Thời gian hoạt động ${tuyenduong.thoiGianHD}</h6>
									
									<h6 class="font-weight-normal">Thời gian một chuyến: ${tuyenduong.thoiGianChuyen} </h6>
									<h6 class="font-weight-normal">Cự ly: ${tuyenduong.cuLy} </h6>
									<h6 class="font-weight-normal">Giá vé : HSSV :${tuyenduong.giaVe.giaVeHSSV} - Bình thường :${tuyenduong.giaVe.giaVeBT}- Tập :${tuyenduong.giaVe.giaVeTap}</h6>
												<h6 class="font-weight-normal">Loại hình :
												<c:if test="${tuyenduong.giaVe.loaiHinh.trim().toLowerCase()=='tg'}">
									Trợ giá
									</c:if>
									<c:if test="${tuyenduong.giaVe.loaiHinh.trim().toLowerCase()=='ktg'}">
									Không trợ giá
									</c:if></h6></td>
											<td><a
										href="dsxetrongtuyen/${tuyenduong.id}.htm"><button
												class="btn btn-primary">DS</button> </a></td>
									<td><a
										href="cttuyenduong/${tuyenduong.id}.htm"><button
												class="btn btn-primary">Chi tiết trạm</button> </a></td>
																	<td style='display: flex; justify-content: flex-start;'>
									
				
									
										<a
										href="suatuyenduong/${tuyenduong.id}.htm"><button
												class="btn btn-primary">chỉnh sửa</button> </a> 

										<button
											onclick="if(confirm('bạn có chắc chắn muốn xóa tuyến đường này không ?')){location.href='xoatuyenduong/${tuyenduong.id}.htm'}"
											class="btn btn-danger" style='margin-left: 7px;'>Xóa</button>
</td>
								</tr>
<c:set var="counter" value="${counter+1}" />
							</c:forEach>
						</tbody>
					</table>
					<div style="
    margin: 50px;
">
					<ul class="pagination" style="position: absolute; bottom: 0; right: 0;width:400px;">
			    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
			        <a class="page-link" href="dstuyenduong.htm?page=${currentPage - 1}">Trước</a>
			    </li>
			    <c:forEach begin="0" end="${totalPages - 1}" var="i">
			        <li class="page-item ${currentPage == i ? 'active' : ''}">
			            <a class="page-link" href="dstuyenduong.htm?page=${i}">${i + 1}</a>
			        </li>
			    </c:forEach>
			    <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
			        <a class="page-link" href="dstuyenduong.htm?page=${currentPage + 1}">Sau</a>
			    </li>
			</ul>
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