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
<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: italic;
}</style>


</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<c:if test="${sessionScope.TaiKhoan.isAdmin==1}">
			<%@ include file="../includes/Navbarc1.jsp"%></c:if>
			<c:if test="${sessionScope.TaiKhoan.isAdmin==0}">
			<%@ include file="../includes/Navbarnvc1.jsp"%></c:if>
			<div class="col py-3">
					<c:if test="${message==1}">
					<div class="alert alert-success fade show" role="alert"style='position: fixed; width:50%; margin-left:300px; z-index: 100 '>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>Thêm địa lưu trú viên thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
					<div class="alert alert-danger fade show"" role="alert"style='position: fixed; width:50%; margin-left:230px;'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>Thêm địa lưu trú thất bại</p>
						<hr>
					</div>
					</c:if>
					<c:if test="${message==3}">
					<div class="alert alert-danger fade show" role="alert"style='position: fixed; width:50%; margin-left:300px; z-index: 100 '>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>Tên địa lưu trú đã tồn tại</p>
						<hr>
					</div>
				</c:if>
					<c:set var="message" value="0" />
					<button onclick="location.href = 'dsdiemluutru.htm'"
					class="btn btn-outline-secondary my-2 my-sm-0" type="submit">
					<< Trở lại</button>
				<div class="container form-dang-nhap">
					<div class="modal-body">
						<form:form action="insertdiemluutru.htm" modelAttribute="diemluutru1" >
							<div class="form-group">
							<div>
									<h1>Thêm địa điểm lưu trú</h1>
								</div>
								<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label" >Loại lưu trú :</label> 
											 <form:select path="loaiLuuTru.id" class="form-select" aria-label="Default select example">
											<c:forEach var="loailuutru" items="${loailuutrus}">
 
     <form:option  value="${loailuutru.id}">${loailuutru.ten}</form:option>
  
  </c:forEach>
  
 </form:select>
 </div>
 <div class="col">
 <div id="div1" style="display:block">	
 <label for="recipient-name" class="col-form-label" >Hạng :</label> 
											 <form:select path="chatLuong" class="form-select" aria-label="Default select example">
  <form:option  value="1">1 sao</form:option>
 <form:option value="2"> 2 sao</form:option>
 <form:option  value="3">3 sao</form:option>
  <form:option value="4">4 sao</form:option>
  <form:option  value="5">5 sao</form:option>
  
 </form:select>
 </div>
 </div>
									 
									</div>
								<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Tên điểm :</label> 
											<form:input path="tenNLT" type="text" class="form-control"  />
											<form:errors path="tenNLT" />
											 
									</div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Địa chỉ :</label> 
											<form:input path="diaChi" type="text" class="form-control"  />
											<form:errors path="diaChi" />
											
											
									</div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Số điện thoại liên hệ :</label> 
											<form:input path="sDT"  type="tel" class="form-control"
											id="phone"  />
											<form:errors path="sDT" />
											
									</div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Email liên hệ :</label> 
											<form:input path="email"  type="email"  class="form-control"
											  />
											
									</div>
									</div>
									<div class="row">
									<div class="col">
										<label for="recipient-name" class="col-form-label">Mô tả :</label> 
										<textarea name="moTa" class="form-control"></textarea>
											
											 
									</div>
									</div>
									
									
								</div>
								
							
							 <form:button class="btn btn-primary">thêm </form:button>
						</form:form>
					</div>
				</div>
				<%-- <div class="modal-footer">
					<div style='display: block;'>
						<input type="text" name="timkiem" placeholder=" Tìm kiếm"
							style='padding: 3px'>
					</div>

					<br>
	<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Tên</th>
								<th scope="col">Xử lý</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach var="diemluutru" items="${diemluutrus}">

								<tr>
									<th scope="row">${diemluutru.id}</th>
									<td>${diemluutru.tenNLT}</td>
																	<td style='display: flex; justify-content: flex-start;'>
									<div class="dropdown" style="margin-right: 10px;">
											<button class="btn btn-primary dropdown-toggle"
												data-toggle="dropdown">Chi tiết</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<div class="container">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Thông
															tin địa điểm</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close"></button>
													</div>
													<div class="modal-body" style="width: 500px;">

														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Tên :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${diemluutru.tenNLT}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Loại hình :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${diemluutru.loaiLuuTru.ten}</label>
															</div>
														</div>
														<c:if test="${diemluutru.chatLuong !=0}">
														<div class="row">
															<div class="col">
															
																<label for="recipient-name" class="col-form-label">Hạng
																	:</label>
																	
																	
										<c:choose>
   <c:when test="${diemluutru.chatLuong ==1}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==2}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i><i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==3}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==4}">
     
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==5}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:otherwise>

   </c:otherwise>
</c:choose>
															</div>
														</div>
														</c:if>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Địa chỉ :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.diaChi}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Số điện thoại :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.sDT}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Email :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.email}</label>
															</div>
														</div>
														
														
														
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Mô tả
																	:</label> <label for="recipient-name" class="col-form-label">
																	${diemluutru.moTa}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Hình ảnh
																	:</label> <label for="recipient-name" class="col-form-label">
																	${diemdulich.hinhAnh}</label>
															</div>
														</div>
								
													

														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
														</div>


													</div>
												</div>
											</div>
										</div>
									
									
											
						
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div> --%>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    // Bắt sự kiện onchange của select element
    $('select[name="loaiLuuTru.id"]').on('change', function() {
        // Lấy giá trị của option được chọn
        var selectedValue = $(this).val();
        
        // Kiểm tra nếu giá trị là 1 thì hiển thị div, ngược lại ẩn div
        if (selectedValue != 1) {
        	$('#div1').hide();
        } else {
            
            $('#div1').show();
        }
    });
</script>
	 
	
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