<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản lí sản phẩm</title>
<%@include file="../includes/head.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />

	<div id="wrapper">
		<c:set var="user" value="${sessionScope.user}" />

		<!-- 	<header>
			<div class="inner-header container">
				<h6>
					<fmt:message>head.hotline</fmt:message> <span id="button"> 1900 8080</span>
				</h6>

				<nav>
					<ul id="top-header" class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="?lang=vi_VN"><i class="fa fa-language"></i><fmt:message>menu.vnese</fmt:message></a></li>
						<li class="nav-item"><a class="nav-link" href="?lang=en_US"><i class="fa fa-language"></i><fmt:message>menu.eng</fmt:message></a></li>
						<c:if test="${empty user}">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="login.jsp"><i
									class="f a fa-sign-in"></i><fmt:message>head.login</fmt:message></a></li>
						</c:if>
						<c:if test="${not empty user}">
							<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> 
								<i class=" fa fa-user px-1"></i> ${user.getEmail()}
							</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="cart.jsp">Giỏ hàng</a></li>
									<li><a class="dropdown-item" href="changePassword.jsp">Đổi mật khẩu</a></li>
									<li><a class="dropdown-item" href="sign_out">Đăng xuất</a></li>
								</ul></li>
						</c:if>

					</ul>
				</nav>
			</div>
			
			<div class="grid container">
				<a href="product-manage.jsp" id="logo">Pharmacy(ad)</a>
				<nav>
					<ul id="main-menu">
						<li><a href="index.jsp"><span style="color: blue"><fmt:message>menu.homepage</fmt:message></span></a></li>
						<li><a href="product.jsp"><fmt:message>menu.product</fmt:message></a></li>
						<li><a href="#"><fmt:message>menu.promotion</fmt:message></a></li>
						<li><a href="#"><fmt:message>menu.about</fmt:message></a></li>
					</ul>
				</nav>
				<div class="tools-menu">
					<form action="" id="search-box">
						<input type="text" name="" id="search-text"
							placeholder="search" required>
						<button id="search-btn">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</form>
					<a href="#" class="nav-link"> <i class="fa-solid fa-bell"></i></a>
					<a href="cart.jsp" class="nav-link"><i
						class="fa-solid fa-cart-shopping"></i></a>
				</div>
			</div>
		</header>
*/ -->



		<div id="banner" class="grid-custom grid-col-3">
			<h2>Chào ${user.getEmail()}</h2>

			<!-- <a href="account?action=logout">Đăng xuất</a> -->
			<a class="dropdown-item" href="../sign_out">Đăng xuất</a>
			<a class="dropdown-item" href="../index.jsp">về trang chủ</a>
		</div>


		<div class="container">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-9">
							<h2>
								Quản lí <b>sản phẩm</b>
							</h2>
						</div>
						<div class="col-sm-9">
							<a href="#addNewProductModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th>id</th>
							<th>Ảnh sản phẩm</th>
							<th>Tên sản phẩm</th>
							<th>Nhà phân phối</th>
							<th>Chỉ định</th>
							<th>Giá bán</th>
							<th>Ngày sản xuất</th>
							<th>Hạn sử dụng</th>
							<th>Số lượng trong kho</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listP}" var="p">

							<tr>
								<td><span class="custom-checkbox"> <input
										type="checkbox" id="checkbox1" name="options[]" value="1">
										<label for="checkbox1"></label>
								</span></td>


								<td><a>${p.productID}</a></td>
								<td><a href="product-detail?productID=${p.productID}"><img
										src=".${p.img}" class="card-img-top card-img-top "
										alt="hình ảnh sản phẩm"></a></td>
								<td>${p.productName}</td>
								<td>${p.manufacture.name}</td>
								<td>${p.detailUses}</td>
								<td>${p.formatPrice(p.getPriceSale()) }</td>
								<td>${p.dateOfmanufacture}</td>
								<td>${p.expiry }</td>
								<td>${p.quantityInStock}</td>

								<td><a href="#" class="edit" data-toggle="modal"
									data-target="#editProductModal" data-productid="${p.productID}">
										<i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
								</a> <a href="Admin_DeleteProduct?productID=${p.productID}"
									class="delete" data-toggle="modal"><i
										class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix">
					<div class="hint-text">
						Showing <b>5</b> out of <b>25</b> entries
					</div>

					<ul class="pagination">
						<li class="page-item disabled"><a href="#">Previous</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item"><a href="#" class="page-link">2</a></li>
						<li class="page-item active"><a href="#" class="page-link">3</a></li>
						<li class="page-item"><a href="#" class="page-link">4</a></li>
						<li class="page-item"><a href="#" class="page-link">5</a></li>
						<li class="page-item"><a href="#" class="page-link">Next</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="editProductModal" class="modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="Admin_EditProduct" method="post">

						<input type="hidden" id="productIDInput" name="productID" />

						<div class="modal-header">
							<h4 class="modal-title">Sửa thông tin sản phẩm</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<div>
									<label for="formFileLg" class="form-label">Hình ảnh sản
										phẩm</label> <input name="imgUrl" class="form-control form-control-lg"
										id="formFileLg" type="file">
								</div>
							</div>
							<div class="form-group">
								<label>Tên sản phẩm</label> <input name="productName"
									type="text" class="form-control">
							</div>
							<div class="form-group">
								<label>Công dụng chi tiết</label> <input name="detailUses"
									type="text" class="form-control">
							</div>
							<div class="form-group">
								<label>Giá</label> <input name="importPrice"
									class="form-control"></input>
							</div>
							<div class="form-group">
								<label>Ngày sản xuất</label> <input type="date"
									name="dateOfmanufacture" class="form-control">
								</ipnut>
							</div>
							<div class="form-group">
								<label>Hạn sử dụng</label> <input type="date" name="expiry"
									class="form-control">
								</ipnut>
							</div>
							<div class="form-group">
								<label>Số lượng</label> <input name="quantity"
									class="form-control"></input>
							</div>

						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Hủy"> <input type="submit"
								class="btn btn-success" value="Cập nhật">
						</div>
					</form>
				</div>
			</div>
		</div>




		<div id="addNewProductModal" class="modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="Admin_AddNewProductServlet" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thêm sản phẩm</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<div>
									<label for="formFileLg" class="form-label">Thêm ảnh sản
										phẩm</label> <input name="imgUrl" class="form-control form-control-lg"
										id="formFileLg" type="file">
								</div>
							</div>
							<div class="form-group">
								<label>Tên sản phẩm</label> <input name="productName"
									type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Công dụng</label> <input name="detailUses" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Giá </label> <input name="importPrice"
									class="form-control" required></input>
							</div>
							<div class="form-group">
								<label>Ngày sản xuất</label> <input type="date"
									name="dateOfmanufacture" class="form-control" required>
								</ipnut>
							</div>
							<div class="form-group">
								<label>Hạn sử dụng</label> <input type="date" name="expiry"
									class="form-control" required>
								</ipnut>
							</div>
							<div class="form-group">
								<label>Số lượng</label> <input name="quantity"
									class="form-control" required></input>
							</div>
							<div class="form-group">
								<label>Nhà sản xuất</label> <select name="manufactureName"
									class="form-select" aria-label="Default example">
									<option value="">Chọn nhà phân phối hiện có</option>
									<c:forEach items="${listP}" var="p">
										<option value="${p.manufacture.name}">
											${p.manufacture.name}</option>
									</c:forEach>
								</select> <span id="passwordHelpInline" class="form-text"> Nhà
									phân phối mới </span> <input type="text" name="newManufactureName"
									placeholder="Tên nhà phân phối" class="form-control"></input> <input
									type="text" name="manufactureAddress" placeholder="địa chỉ"
									class="form-control"></input> <input type="date"
									name="dateEstablish" placeholder="Ngày thành lập"
									class="form-control"></input>
							</div>

						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Hủy bỏ"> <input type="submit"
								class="btn btn-success" value="Thêm ">
						</div>
					</form>
				</div>
			</div>
		</div>

		<script src="../js/manager.js" type="text/javascript"></script>


	</div>

	<%@include file="../includes/footer.jsp"%>


	<script>
		$(document).ready(function() {
			$('#editProductModal').on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget); // Nút mở modal
				var productID = button.data('productid'); // Lấy giá trị từ thuộc tính data-productid
				// Đặt giá trị productID vào các trường trong modal
				$("#productIDInput").val(productID);
			});
		});
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>