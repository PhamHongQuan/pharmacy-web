<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body class="form-bg" style="background-color: rgb(140,202,204) !important;">
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />
	
	<div class="container ">
		<a href="index.jsp" id="logo">Pharmacy</a>
		<div class="card-header">
			<div class="tab-group resize">
				<h3><fmt:message>signUp.title</fmt:message></h3>
			</div>
			<div class="card w-50 mx-auto my-5">
				<div id="signup" class="resize banner card-body ">

					<form action="sign-up" method="post">
						<div class=" mb-3">
							<div class=" text-center ">
								<div class="row ">
									<div class="col">
										<input id="name" type="text" class="form-control"
											name="lastName" placeholder="<fmt:message>signUp.first</fmt:message>" aria-label="Last name">
									</div>
									<div class="col">
										<input id="name" type="text" class="form-control"
											name="firstName" placeholder="<fmt:message>signUp.last</fmt:message>" aria-label="First name">
									</div>
									<div class="col col-lg-2">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="sex"
												value="Male" id="flexRadioDefault1" checked> <label
												class="form-check-label" for="genderCheck"><fmt:message>signUp.male</fmt:message></label>
										</div>
									</div>
									<div class="col col-lg-2">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="sex"
												value="Female" id="flexRadioDefault2"> <label
												class="form-check-label" for="genderCheck"><fmt:message>signUp.female</fmt:message></label>
										</div>
									</div>

								</div>
							</div>
						</div>

						<div class=" mb-3">
							<input type="text" name="email" class="form-control"
								id="inputEmail" placeholder="<fmt:message>signUp.email</fmt:message>" aria-label="email">
						</div>

						<div class="mb-3">
							<input type="text" name="address" class="form-control"
								id="inputAddress" placeholder="<fmt:message>signUp.address</fmt:message>">
						</div>

						<div class="mb-3">
							<input type="text" name="telephone" class="form-control"
								id="inputPhoneNumber" placeholder="<fmt:message>signUp.phone</fmt:message>">
						</div>

						<div class="row">
							<div class="col">
								<input type="password" name="password" class="form-control"
									id="password" placeholder="<fmt:message>signUp.pwd</fmt:message>" aria-label="password"
									onkeyup="checkPwd()"> <span id="passwordHelpInline"
									class="form-text"><fmt:message>signUp.note</fmt:message></span>
							</div>
							<div class="col">
								<input type="password" name="repassword" class="form-control"
									id="rePassword" placeholder="<fmt:message>signUp.rePwd</fmt:message>"
									aria-label="repassword" onkeyup="checkPwd()"> <span
									id="message" style="color: red"></span>
							</div>
						</div>
						<div class="mb-3">
							<div class="form-check">
								<input class="form-check-input" name="check" type="checkbox"
									value="check" id="gridCheck" required> <label
									class="form-check-label" for="gridCheck"><fmt:message>signUp.accept</fmt:message> </label>
							</div>
						</div>
						<div class="col-12">
							<button type="submit" value="signup" class="button button-block"><fmt:message>signUp.title</fmt:message></button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	function checkPwd() {
		pwd = document.getElementById("password").value;
		rePwd = document.getElementById("rePassword").value;
		if (pwd != rePwd) {
			document.getElementById("message").innerHTML = "Mật khẩu không khớp!"
			return false;
		} else {
			document.getElementById("message").innerHTML = ""
			return true;
		}
	}
</script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="../js/script.js"></script>

</html>