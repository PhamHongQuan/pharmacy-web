<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Pharmacy-Beta</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<!-- đặt ngôn ngữ cho trang -->
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />


	<div id="wrapper">
		<c:set var="user" value="${sessionScope.user}" />
		<header>
			<div class="inner-header container">
				<h6>
					<fmt:message>head.hotline</fmt:message>
					<span id="button"> 1900 8080</span>
				</h6>

				<nav>
					<ul id="top-header" class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="?lang=vi_VN"><i
								class="fa fa-language"></i>
							<fmt:message>menu.vnese</fmt:message></a></li>
						<li class="nav-item"><a class="nav-link" href="?lang=en_US"><i
								class="fa fa-language"></i>
							<fmt:message>menu.eng</fmt:message></a></li>
						<c:if test="${empty user}">
							<li class="nav-item dropdown"><a class="nav-link "
								href="login.jsp"><i class="fa fa-sign-in"></i><span
									style="padding-right: 5px"></span>
								<fmt:message>head.login</fmt:message></a></li>
						</c:if>
						<c:if test="${not empty user}">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <i
									class=" fa fa-user px-1"></i> ${user.getEmail()}
							</a>
								<ul class="dropdown-menu">
									<c:if test="${user.getAccountRole() eq 'admin'}">
										<li><a class="dropdown-item"
											href="admin/product-manage.jsp">Quản lí sản phẩm</a></li>
									</c:if>
									<li><a class="dropdown-item"
										href="customer/cartCustomer.jsp">Giỏ hàng</a></li>
									<li><a class="dropdown-item" href="changePassword.jsp">Đổi
											mật khẩu</a></li>
									<li><a class="dropdown-item" href="sign_out">Đăng xuất</a></li>
								</ul></li>
						</c:if>

					</ul>
				</nav>
			</div>

			<div class="grid container">
				<a href="index.jsp" id="logo">Pharmacy</a>
				<nav>
					<ul id="main-menu">
						<li><a href="index.jsp"><span style="color: blue"><fmt:message>menu.homepage</fmt:message></span></a></li>
						<li><a href="product.jsp"><fmt:message>menu.product</fmt:message></a></li>
						<!-- <li><a href="#"><fmt:message>menu.promotion</fmt:message></a></li>
						<li><a href="#"><fmt:message>menu.about</fmt:message></a></li> -->
					</ul>
				</nav>
				<div class="tools-menu">
					<form action="FindProductByNameServlet" method="get"
						id="search-box">
						<input type="text" name="productName" id="search-text"
							placeholder="search...">
						<button id="search-btn" value="">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</form>
					<a href="#" class="nav-link"> <i class="fa-solid fa-bell"></i></a>
					<a href="customer/cartCustomer.jsp" class="nav-link"><i
						class="fa-solid fa-cart-shopping"></i></a>
				</div>
			</div>
		</header>


		<div id="banner" class="grid-custom grid-col-3"
			style="padding-top: 20%">
			<img class="img" src="./img/chatVSds.png">
			<div class="resize">
				<h2>
					<fmt:message>contain.support</fmt:message>
					<br>
					<fmt:message>contain.advise</fmt:message>
					<br>
					<fmt:message>contain.free</fmt:message>
				</h2>
			</div>
			<div class="resize">
				<button type="button">
					<a href="product.jsp"><fmt:message>try</fmt:message></a>
				</button>
			</div>
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>