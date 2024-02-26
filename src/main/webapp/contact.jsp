<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Phamarcy</title>
<link rel="stylesheet" type="text/css"
	href="./Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script src="./Bootstrap/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link
	href="./icon/fontawesome-free-6.4.2-web/fontawesome-free-6.4.2-web/css/all.css"
	rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<c:set var="user" value="${sessionScope.user}" />
	<!-- Navigation -->
	<nav class="sticky-top">
		<nav
			class=" green-color navbar navbar-expand-md navbar-light bg-light  ">
			<div class="container-fluid px-2">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Hotline(Miễn
							phí)</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-phone"></i> 1900 8080</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-language"></i> Tiếng Việt</a></li>
					<c:if test="${empty user}">
						<li class="nav-item"><a class="nav-link" href="login.jsp"><i
								class="fa fa-sign-in"></i> Đăng nhập</a></li>
					</c:if>
					<c:if test="${not empty user}">
						<li class="nav-item">
							<div class="nav-link dropdown">
								<a class="nav-link dropdown-toggle md" href="#"
									id="navbarDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> <i
									class="fa fa-user px-1"></i> ${user.getEmail()}
								</a>
								<div class="dropdown-menu bgcl" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#">Giỏ hàng</a> <a
										class="dropdown-item" href="changePassword.jsp">Đổi mật khẩu</a>
									<!-- Thêm các mục danh mục khác nếu cần -->
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="sign_out">Đăng xuất</a>
								</div>
							</div>
						</li>
					</c:if>
				</ul>
			</div>
		</nav>

		<nav class="navbar navbar-expand-md navbar-light bg-light ">
			<div class="container-fluid">
				<a class="navbar-branch px-2" href="#"> <img
					src="./img/logoPhamarcy.png" height="70px">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive">
					<span class="navbar-toggler-icon"></span>
				</button>
				<form class="d-flex px-5 w-75" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success ms-2 px-3" type="submit">Tìm
						kiếm</button>
				</form>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto ">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Trang
								chủ</a></li>
						<li class="nav-item"><a class="nav-link " href="product.jsp">Sản
								phẩm</a></li>
						<li class="nav-item"><a class="nav-link " href="#">Thực
								phẩm chức năng</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Chăm
								sóc sức khỏe</a></li>
						<li class="nav-item"><a class="nav-link " href="#"><span
								style="color: rgb(51, 174, 89); font-weight: bolder;">Liên
									hệ</span></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</nav>

	<!-- Begin Contact -->

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center"></div>
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="wrapper">
						<div class="row no-gutters mb-5">
							<div class="col-md-7">
								<div class="contact-wrap w-100 p-md-5 p-4">
									<h3 class="mb-4">Contact Us</h3>
									<div id="form-message-warning" class="mb-4"></div>
									<div id="form-message-success" class="mb-4">Your message
										was sent, thank you!</div>
									<form method="POST" id="contactForm" name="contactForm"
										class="contactForm">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">Full Name</label> <input
														type="text" class="form-control" name="name" id="name"
														placeholder="Name">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="email">Email Address</label> <input
														type="email" class="form-control" name="email" id="email"
														placeholder="Email">
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="subject">Subject</label> <input
														type="text" class="form-control" name="subject"
														id="subject" placeholder="Subject">
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="#">Message</label>
													<textarea name="message" class="form-control" id="message"
														cols="30" rows="4" placeholder="Message"></textarea>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<input type="submit" value="Send Message"
														class="btn btn-primary">
													<div class="submitting"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="col-md-5 d-flex align-items-stretch">
								<div id="map" class="py-4">
									<img src="../img/map.png"
										style="max-width: 650px; max-height: auto;">
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- End Contact -->










	<!-- Footer -->
	<footer class="bg-dark text-center text-white">
		<!-- Grid container -->
		<div class="container p-4">
			<!-- Section: Links -->
			<section class="">
				<!--Grid row-->
				<div class="row">
					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h3 class="text-uppercase">Về chúng tôi</h3>

						<ul class="list-unstyled mb-0 px-5" style="text-align: left;">
							<li><a href="#!" class="text-white">Giới thiệu</a></li>
							<li><a href="#!" class="text-white">Hệ thống cửa hàng</a></li>
							<li><a href="#!" class="text-white">Giấy phép kinh doanh</a>
							</li>
							<li><a href="#!" class="text-white">Quy chế hoạt động</a></li>
							<li><a href="#!" class="text-white">Chính sách đổi trả</a></li>
							<li><a href="#!" class="text-white">Chính sách giao hàng</a>
							</li>
							<li><a href="#!" class="text-white">Chinh sách bảo mật</a></li>
							<li><a href="#!" class="text-white">Chính sách thanh
									toán</a></li>
							<li><a href="#!" class="text-white">Thể lệ chương trình
									thẻ thành viên</a></li>
							<li><a href="#!" class="text-white">Trở thành nhà cung
									cấp</a></li>

						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-2 col-md-6 mb-4 mb-md-0">
						<h3 class="text-uppercase">Danh mục</h3>

						<ul class="list-unstyled mb-0 px-3" style="text-align: left;">
							<li><a href="#!" class="text-white">Dược phẩm</a></li>
							<li><a href="#!" class="text-white">Thực phẩm chức năng</a>
							</li>
							<li><a href="#!" class="text-white">Chăm sóc sức khỏe</a></li>
							<li><a href="#!" class="text-white">Thiết bị y tế</a></li>
						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-4 col-md-6 mb-4 mb-md-0">
						<h3 class="text-uppercase">Theo dõi chúng tôi</h3>

						<ul class="list-unstyled mb-0 px-5" style="text-align: left;">
							<li><a href="#!" class="text-white">Facebook</a></li>
							<li><a href="#!" class="text-white">Zalo</a></li>
							<li><a href="#!" class="text-white">Youtube</a></li>
						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h3 class="text-uppercase">Tổng đài CSKH</h3>
						<ul class="list-unstyled mb-0 px-4" style="text-align: left;">
							<li><a href="#!" class="text-white">1900 8080</a></li>
						</ul>
					</div>
					<!--Grid column-->
				</div>
				<!--Grid row-->
			</section>
			<!-- Section: Links -->
		</div>
		<!-- Grid container -->

		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			© 2023 Design my student: <a class="text-white"
				href="https://mdbootstrap.com/">hcmuaf.edu.com</a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->

</body>
</html>