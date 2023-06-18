<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<base href="${ pageContext.servletContext.contextPath}/">

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
<title>Admin quản lý du lịch</title>
<style>
	img{
	max-height:500px;
	max-width:1200px
	}
</style>
 <style>
          * {
            box-sizing:border-box
          }
          h2 {
            text-align: center;
          }
          /* Slideshow container */
          .slideshow-container {
            max-width: 1200px;
            position: relative;
            margin: auto;
            max-heigth:500px;
          }
          /* Ẩn các slider */
          .mySlides {
              display: none;
          }
          /* Định dạng nội dung Caption */
          .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
          }

          /* định dạng các chấm chuyển đổi các slide */
          .dot {
            cursor:pointer;
            height: 13px;
            width: 13px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
          }
          /* khi được hover, active đổi màu nền */
          .active, .dot:hover {
            background-color: #717171;
          }

          /* Thêm hiệu ứng khi chuyển đổi các slide */
          .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 3s;
            animation-name: fade;
            animation-duration: 3s;
          }

          @-webkit-keyframes fade {
            from {opacity: .4} 
            to {opacity: 1}
          }

          @keyframes fade {
            from {opacity: .4} 
            to {opacity: 1}
          }
        </style>
</head>
<body>
<div class="container-fluid">
		<div class="row flex-nowrap">
		<c:if test="${sessionScope.TaiKhoan.isAdmin==1}">
   <%@ include file="../includes/Navbarc1.jsp" %>	
   </c:if>	
   <c:if test="${sessionScope.TaiKhoan.isAdmin==0}">
   <%@ include file="../includes/Navbarnvc1.jsp" %>	
   </c:if>	
	 
	 
	 
	 <div class="col py-3">
	
	<marquee style="border:#007bff 1px SOLID">${company.slogan }</marquee>
	<%-- <div class="col">
	<div class="row">
</div>
<div class="row">
<label for="recipient-name" class="col-form-label">${company.name }</label> 
<label for="recipient-name" class="col-form-label">${company.slogan }</label>
<img src="${company.logo1}">
<img src="${company.logo2}">
<img src="${company.logo3}">
</div>
	<div class="row">
	</div>
	</div>


</div> --%> 
<c:if test="${sessionScope.TaiKhoan.isAdmin==1}">
<div     style="
    text-align: center;
">
		<p style="
    display: inline;margin: 10px;
"
"><a href="#submenuphoto1" style="display: inline;"
										data-bs-toggle="collapse"
										class="nav-link text-white px-0 align-middle "> <i
											class="fa-solid fa-map-location-dot"></i>
											<button style="
    margin-bottom: 10px;
"class="btn btn-success">Photo 1</button>
									</a></p>
			
										
		<p style="
    display: inline;margin: 10px;
"><a href="#submenuphoto2" style="display: inline;"
										data-bs-toggle="collapse"
										class="nav-link text-white px-0 align-middle "> <i
											class="fa-solid fa-map-location-dot"></i>
											<button style="
    margin-bottom: 10px;
"class="btn btn-success">Photo 2</button>
									</a></p>
		<p style="
    display: inline;margin: 10px;
"><a href="#submenuphoto3" style="display: inline;"
										data-bs-toggle="collapse"
										class="nav-link text-white px-0 align-middle "> <i
											class="fa-solid fa-map-location-dot"></i>
											<button style="
    margin-bottom: 10px;
"class="btn btn-success">Photo 3</button>
									</a></p>
       
       <ul class="collapse nav flex-column ms-1" id="submenuphoto1" data-bs-parent="#menu">
                            <li class="w-100">
                               
	<form action="homeshow1.htm" method="post" enctype="multipart/form-data" style="
   max-width: 400px;
    margin: auto;
    border: #00d5ff 3px SOLID;
    padding: 10px;
    margin-top:5px;
    margin-bottom:10px;
">
							<div class="form-group">
							<div class="form-group">
			<div>Hình ảnh 1</div>
			<input type="file" name="photo">
		</div>				
								</div>
								
							
							 <button class="btn btn-success">thêm </button>
						</form>
                           
                        </ul>
                         <ul class="collapse nav flex-column ms-1" id="submenuphoto2" data-bs-parent="#menu">
                            <li class="w-100">
                              
	<form action="homeshow2.htm" method="post" enctype="multipart/form-data" style="
   max-width: 400px;
    margin: auto;
    border: #00d5ff 3px SOLID;
    padding: 10px;
    margin-top:5px;
    margin-bottom:10px;
">
							<div class="form-group">
							<div class="form-group">
			<div>Hình ảnh 2</div>
			<input type="file" name="photo">
		</div>				
								</div>
								
							
							 <button class="btn btn-success">thêm </button>
						</form>
                           
                        </ul> 
                         <ul class="collapse nav flex-column ms-1" id="submenuphoto3" data-bs-parent="#menu">
                            <li class="w-100">
                               
	<form action="homeshow3.htm" method="post" enctype="multipart/form-data" style="
   max-width: 400px;
    margin: auto;
    border: #00d5ff 3px SOLID;
    padding: 10px;
    margin-top:5px;
    margin-bottom:10px;
">
							<div class="form-group">
							<div class="form-group">
			<div>Hình ảnh 3</div>
			<input type="file" name="photo">
		</div>				
								</div>
								
							
							 <button class="btn btn-success">thêm </button>
						</form>
                           
                        </ul>  </div>
                        </c:if>
                         ${message1}
<div class="row">
<div class="slideshow-container">

        <div class="mySlides fade">
          <img src="${company.logo1}" style="width:100%">
          <!-- <div class="text">Nội dung caption của slide đầu tiên!</div> -->
        </div>
        
        <div class="mySlides fade">
          <img src="${company.logo2}" style="width:100%">
          <!-- <div class="text">Nội dung caption của slide thứ 2!</div> -->
        </div>

        <div class="mySlides fade">
          <img src="${company.logo3}" style="width:100%">
         <!--  <div class="text">Nội dung caption của slide thứ 3!</div> -->
        </div>
      </div>
      <br>
</div>
<div class="row">
      <div style="text-align:center;margin: auto;">
        <span class="dot" onclick="currentSlide(0)"></span> 
        <span class="dot" onclick="currentSlide(1)"></span> 
        <span class="dot" onclick="currentSlide(2)"></span> 
      </div>  
</div>
</div>
</div>


		</div>
    </body>
    <script>
      //khai báo biến slideIndex đại diện cho slide hiện tại
      var slideIndex;
      // KHai bào hàm hiển thị slide
      function showSlides() {
          var i;
          var slides = document.getElementsByClassName("mySlides");
          var dots = document.getElementsByClassName("dot");
          for (i = 0; i < slides.length; i++) {
             slides[i].style.display = "none";  
          }
          for (i = 0; i < dots.length; i++) {
              dots[i].className = dots[i].className.replace(" active", "");
          }

          slides[slideIndex].style.display = "block";  
          dots[slideIndex].className += " active";
          //chuyển đến slide tiếp theo
          slideIndex++;
          //nếu đang ở slide cuối cùng thì chuyển về slide đầu
          if (slideIndex > slides.length - 1) {
            slideIndex = 0
          }    
          //tự động chuyển đổi slide sau 5s
          setTimeout(showSlides, 5000);
      }
      //mặc định hiển thị slide đầu tiên 
      showSlides(slideIndex = 0);


      function currentSlide(n) {
        showSlides(slideIndex = n);
      }
    </script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</html>