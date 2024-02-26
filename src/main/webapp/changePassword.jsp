<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Đổi mật khẩu</title>
<!-- Link to Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<!-- Link to your custom CSS file -->
<link rel="stylesheet" href="css/style.css">

<style>
body {
	background-color: #f8f9fa;
	padding: 50px;
	text-align: center;
}

#logo {
	font-size: 24px;
	font-weight: bold;
	text-decoration: none;
	color: #000;
}

h3 {
	margin-top: 20px;
	margin-bottom: 30px;
}

.card {
	max-width: 50%;
	margin: 0 auto;
	padding: 20px;
}

.form-control {
	margin-bottom: 15px;
}

#message {
	margin-top: 5px;
	display: block;
}

.btn-primary {
	margin-top: 20px;
}
</style>
</head>
<body class="form-bg">

	<div class="container">
		<a href="index.jsp" id="logo">Pharmacy</a>
		<c:set var="notify" value="${notify}" />

		<!-- change password begin -->
		<h3>Đổi mật khẩu</h3>

		<div class="card">
			<span style="color: red">${notify}</span>
			<form action="change-password" method="post">
				<!-- send request to changePassword.java -->
				<div class="mb-3">
					<input type="password" name="currentPassword" class="form-control"
						id="currentPassword" aria-describedby="emailHelp"
						placeholder="Mật khẩu hiện tại" required="required">
				</div>
				<div class="mb-3">
					<input type="password" name="newPassword" class="form-control"
						id="newPassword" placeholder="Mật khẩu mới" required="required">
				</div>
				<div class="mb-3">
					<input type="password" name="reNewPassword" class="form-control"
						id="reNewPassword" placeholder="Nhập lại mật khẩu"
						required="required" onkeyup="checkPwd()"> <span
						id="message" style="color: red"></span>
				</div>
				<div class="btn-group" role="group" aria-label="Basic example">
					<button type="submit" class="btn btn-primary btn-block">Đổi
						mật khẩu</button>
				</div>
			</form>
		</div>
		<!-- change password end -->

		<a href="index.jsp"><button class="btn btn-primary btn-block">Trang
				chủ</button></a>
	</div>

	<script>
		function checkPwd() {
			pwd = document.getElementById("newPassword").value;
			rePwd = document.getElementById("reNewPassword").value;
			if (pwd != rePwd) {
				document.getElementById("message").innerHTML = "Mật khẩu không khớp!";
				return false;
			} else {
				document.getElementById("message").innerHTML = "";
				return true;
			}
		}
	</script>

	<!-- Link to Bootstrap JS and Popper.js (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="../js/script.js"></script>
</body>
</html>
