<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<fmt:setLocale value="en_US" />
<fmt:setBundle basename="language.lang" />

<footer class="bg-dark text-center text-white">
	<!-- Grid container -->
	<div class="container p-4">
		<!-- Section: Links -->
		<section class="">
			<!--Grid row-->
			<div class="row">
				<!--Grid column-->
				<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
					<h3 class="text-uppercase">
						<fmt:message>foot.about</fmt:message>
					</h3>

					<ul class="list-unstyled mb-0 px-5" style="text-align: left;">
						<li><a href="#!" class="text-white"><fmt:message>foot.about.introduce</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.about.system</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.about.license</fmt:message></a></li>


					</ul>
				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-lg-2 col-md-6 mb-4 mb-md-0">
					<h3 class="text-uppercase">
						<fmt:message>foot.caterory</fmt:message>
					</h3>

					<ul class="list-unstyled mb-0 px-3" style="text-align: left;">
						<li><a href="#!" class="text-white"><fmt:message>foot.caterory.homepage</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.caterory.product</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.caterory.deal</fmt:message></a></li>
					</ul>
				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-lg-4 col-md-6 mb-4 mb-md-0">
					<h3 class="text-uppercase">
						<fmt:message>foot.followUs</fmt:message>
					</h3>

					<ul class="list-unstyled mb-0 px-5" style="text-align: left;">
						<li><a href="#!" class="text-white"><fmt:message>foot.followUs.fb</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.followUs.zalo</fmt:message></a></li>
						<li><a href="#!" class="text-white"><fmt:message>foot.followUs.ytb</fmt:message></a></li>
					</ul>
				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
					<h3 class="text-uppercase">
						<fmt:message>foot.switchboard</fmt:message>
					</h3>
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

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
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
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	<script>
	$(document).ready(function() {
		//all li có sub menu và thêm vào classs has-child
		$('.sub-menu').parent('li').addClass('has-child');
	});
</script>



<script>
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop()) {
				$('header').addClass('sticky');
			} else {
				$('header').removeClass('sticky');
			}
		});
	});
</script>


 





</html>