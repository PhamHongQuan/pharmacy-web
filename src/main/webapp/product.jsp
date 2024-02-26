<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Sản phẩm</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.css" />
</head>
<body>
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
								class="fa fa-language"></i> <fmt:message>menu.vnese</fmt:message></a></li>
						<li class="nav-item"><a class="nav-link" href="?lang=en_US"><i
								class="fa fa-language"></i> <fmt:message>menu.eng</fmt:message></a></li>
						<c:if test="${empty user}">
							<li class="nav-item dropdown"><a class="nav-link "
								href="login.jsp"><i class="fa fa-sign-in"></i><span>
								</span> <fmt:message>head.login</fmt:message></a></li>
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
						<li><a href="index.jsp"><fmt:message>menu.homepage</fmt:message></a></li>
						<li><a href="product.jsp"><span style="color: blue"><fmt:message>menu.product</fmt:message></span></a></li>
						<!-- 	<li><a href="#"><fmt:message>menu.promotion</fmt:message></a></li>
						<li><a href="#"><fmt:message>menu.about</fmt:message></a></li>  -->
					</ul>
				</nav>
				<div class="tools-menu">
					<div class="search-box">
						<form action="FindProductByNameServlet" method="get"
							id="search-box">
							<input type="text" name="productName" id="search-text"
								placeholder="search...">
							<button id="search-btn" value="">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</form>

					</div>

					<a href="#" class="nav-link"> <i class="fa-solid fa-bell"></i></a>
					<a href="customer/cartCustomer.jsp" class="nav-link"><i
						class="fa-solid fa-cart-shopping"></i></a>
				</div>
			</div>
		</header>

		<div id="content" class="container">

			<div class="head-content">
				<hr>
				<p>
					<fmt:message>marketting.deal</fmt:message>
				</p>
				<hr>
			</div>
			<form action="AscendingOrder">
				<button type="submit" class="btn btn-outline-primary">
					<fmt:message>product.asc</fmt:message>
				</button>
			</form>
			<form action="DescendingOrder">
				<button type="submit" class="btn btn-outline-primary">
					<fmt:message>product.desc</fmt:message>
				</button>
			</form>

			<!-- Category -->
			<div id="contentProducts" class="grid-custom grid-col-4">
				<c:forEach items="${listP}" var="p">
					<div class=" product body-content">
						<div class="product-card">
							<a href="product-detail?productID=${p.productID}"><img
								src="${p.img}" class="card-improduct-top card-img-top "
								alt="hình ảnh sản phẩm"></a>
							<div class="card-body">
								<h5 class="price">${p.formatPrice(p.getPriceSale()) }</h5>
								<p class="text"
									style="max-height: 3em; overflow: hidden; text-overflow: ellipsis;">
									<a href="product-detail?productID=${p.productID}">${p.productName}</a>
								</p>
								<div class="options">
									<c:if test="${not empty user}">
										<a
											href="add-cart?productID=${p.productID}&customerID=${user.customerID}"
											class="btn btn-primary"><fmt:message>product.add</fmt:message></a>
									</c:if>
									<c:if test="${empty user}">
										<span><fmt:message>product.need</fmt:message></span>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- Category End-->
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>