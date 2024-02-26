<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body  class="form-bg" style="background-color: rgb(140,202,204) !important;">
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />
	
	<div class="container ">
	<a href="./index.jsp" id="logo">Pharmacy</a>
		<div class="card w-50 mx-auto my-5">
		
			<div class="card-header">
				<div class="tab-group resize">
					<h3><fmt:message>login.title</fmt:message></h3>
				</div>
			</div>
			<div class="card-body">
			
				<div class="tab-content">
				
					<!-- Login begin -->
					<div id="login" class="card-body">
						<form action="login" method="post">
							<div class="mb-3">
								<input type="email" name="email" class="form-control"
									id="InputEmail" aria-describedby="emailHelp" autofocus="autofocus"
									placeholder=<fmt:message>login.email</fmt:message> required="required">
							</div>
							<div class="mb-3">
								<input type="password" name="password" class="form-control"
									id="InputPassword" placeholder="<fmt:message>login.pwd</fmt:message>" required="required">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1"><fmt:message>login.save</fmt:message></label>
							</div>
							<p class="forgot">
								<a href="#"><fmt:message>login.forgot</fmt:message></a>
							</p>
							
							<div id="top-header" class="btn-group" role="group" aria-label="Basic example">
								<button type="submit" class="btn btn-primary btn-block"><fmt:message>login.title</fmt:message></button>
								<a href="signUp.jsp" class=" px-5 btn btn-primary"><fmt:message>signUp.title</fmt:message></a>
							</div>
						</form>
					</div>
					<!-- Login end -->
					
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="../js/script.js"></script>

</body>

</html>