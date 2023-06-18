<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
     integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"> 
     <script src="https://kit.fontawesome.com/ee36f81461.js" crossorigin="anonymous"></script>
<title>Admin quản lý tour du lịch</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-primary">
				<div
					class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
					<a href="/"
						class="d-flex align-items-center pb-5 pt-5 mb-md-0 me-md-auto text-white text-decoration-none">
						<span class="fs-5 d-none d-sm-inline">ADMIN</span>
					</a>
					<ul
						class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
						id="menu">
						<li class="nav-item"><a href="home.htm"
							class="nav-link text-white align-middle px-0"><i
								class="fa-solid fa-house"></i> <span
								class="ms-1 d-none d-sm-inline">Home</span>
						</a></li>
						<li><a href="#submenu1" data-bs-toggle="collapse"
							class="nav-link text-white px-0 align-middle">
							<i class="fa-regular fa-calendar-days"></i> <span
								class="ms-1 d-none d-sm-inline">Danh sách nhân viên</span>
						</a>
							
								<li class="w-100"><a href="thevao.htm"
									class="nav-link text-white px-0"><i class="fa-solid fa-map-location-dot"></i> <span
										class="d-none d-sm-inline">Địa điểm du lịch</span></a></li>
								<li><a href="thera.htm" class="nav-link text-white px-0">
								<i class="fa-solid fa-hotel"></i>
										<span class="d-none d-sm-inline">Điểm lưu trú</span>
								</a></li>
								<li><a href="lichsugui.htm"
									class="nav-link text-white px-0">
									<i class="fa-solid fa-rectangle-list"></i> <span
										class="d-none d-sm-inline">Danh sách đặt tour</span></a></li>
							
						<li><a href="lich.htm"
							class="nav-link text-white px-0 align-middle"><i class="fa-solid fa-people-group"></i> <span
								class="ms-1 d-none d-sm-inline">Danh sách khách hàng</span>
						</a></li>
						<li><a href="lich.htm"
							class="nav-link text-white px-0 align-middle"> <i class="fa-solid fa-ticket"></i><span
								class="ms-1 d-none d-sm-inline">Giá vé</span>
						</a></li>
						<li><a href="#submenu2" data-bs-toggle="collapse"
							class="nav-link text-white px-0 align-middle "> <i class="fa-solid fa-sack-dollar"></i><span
								class="ms-1 d-none d-sm-inline">Khuyến mãi</span></a>
</ul>

							<ul class="collapse nav flex-column ms-1" id="submenu2"
								data-bs-parent="#menu">
								<li class="w-100"><a href="doanhthu.htm"
									class="nav-link px-0"> <span class="d-none d-sm-inline">Doanh
											thu</span></a></li>
								<li><a href="nhanvien.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Nhân viên</span></a></li>
								<li><a href="quanlithethang.htm" class="nav-link px-0">
										<span class="d-none d-sm-inline">Nhân viên</span>
								</a></li>
								<li><a href="quanlilich.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Lịch</span></a></li>

								<li><a href="chucvu.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Chức vụ</span></a></li>
								<li><a href="quanlitaikhoan.htm" class="nav-link px-0">
										<span class="d-none d-sm-inline">Tài khoản</span>
								</a></li>
								<li><a href="bangluong.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Bảng lương</span></a></li>

								<li><a href="chinhsuaphi.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Phí gửi xe</span></a></li>

							</ul>

						<hr>

						<div class="dropdown pb-4">
							<a href="#"
								class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
								id="dropdownUser1" data-bs-toggle="dropdown"
								aria-expanded="false"> <img src="https://github.com/mdo.png"
								alt="hugenerd" width="30" height="30" class="rounded-circle">
								<span class="d-none d-sm-inline mx-1">Tài khoản</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark text-small shadow">

								<li><a class="dropdown-item" href="nhanvien-thongtin.htm">Chỉnh
										sửa thông tin cá nhân</a></li>
								<li><a class="dropdown-item" href="doimatkhau.htm">Đổi
										mật khẩu</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="logout.htm">Đăng
										xuất</a></li>
							</ul>
						</div>
				</div>
			</div>
			<div class="" col py-3 d-flex justify-content-centeralign-items-center"">

			</div>
		</div>
	</div>
	
	   <div class="container form-dang-nhap">
    <div style='display: flex;
  justify-content: space-between;'>
    
     <button type="button" class="btn btn-success" onclick="location.href = './themtaikhoan.htm'">Thêm nhân viên mới</button>
    <input type="text" name="timkiem"  placeholder=" Tìm kiếm" style='padding:3px'>
   
    </div>
    <br>
    <table class="table">
  <thead>
    <tr>
    <th scope="col">Mã</th>
      <th scope="col">Họ tên</th>
      <th scope="col">Chức vụ</th>
      <th scope="col">Xử lý</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="nhanvien" items="${nhanviens}" >
        
         <tr>
      <th scope="row">${nhanvien.maNV}</th>
      <td>${nhanvien.hoNV} ${nhanvien.tenNV}</td>
       <td>${nhanvien.chucVu.tenCV}</td> 
       <td style='display: flex;
  justify-content:  flex-start;'>
        <form action="suattnhanvien.htm" method="post">
       <button name="manv" value="${nhanvien.maNV}" class="btn btn-primary">chỉnh sửa</button>
       </form>
        <form action="suattnhanvien.htm" method="post">
       <button type="button" class="btn btn-danger" style='margin-left: 7px;' >xóa</button>
       </form>
       </td>
      
    </tr>
        
        </c:forEach>
  </tbody>
</table>
       

    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>