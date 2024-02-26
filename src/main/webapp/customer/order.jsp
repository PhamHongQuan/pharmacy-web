<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@include file="../includes/head.jsp"%>
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>
	
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />
<h2>Đặt hàng</h2>
<p>Vì lí do hạn chế khu vực, vui lòng kiểm tra kĩ trong quá trinh đặt hàng.</p>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="AddNewOrder" method="post">
      
        <div class="row">
          <div class="col-50">
            <h3>Thông tin người nhận</h3>
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="vui lòng chọn email trùng khớp với email tài khoản*">
            <label for="adr"><i class="fa fa-address-card-o"></i> Địa chỉ</label>
            <input type="text" id="adr" name="address" placeholder="">
            

        
          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Phương thức thanh toán</label>
            
            <h4 style="color: red;"> Thanh toán khi nhận hàng*</h4>
            <h6>(*)Hiện tại chỉ cung cấp phương thức thanh toán trực tiếp khi nhận hàng(miễn phí)</h6>
            
            
          </div>
          
        </div>
       
        <input type="submit" value="Đặt hàng" class="btn">
      </form>
    </div>
  </div>
  <div class="col-25">
    <div class="container">
    
      <h4>Giỏ hàng<span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b></b></span></h4>
      <c:set var="totalPrice" value="0" />
       <c:set var="totalPrice" value="${ item.getSingleP()}" />
                                <c:set var="totalPriceFormat" value="${item.product.formatPrice(totalPrice)}" />
                            <c:forEach items="${order.orderDetails}" var="item">
      <p><img src="${item.product.img }" class="d-block ui-w-40 ui-bordered mr-4" alt=""> <a href="">${item.product.productName } x ${item.quantity }</a> <span class="price">${item.getSingleP()}</span></p>
      
        </c:forEach>
      
     
      <hr>
      
                                
      <p>Tổng <span class="price" style="color:black"><b>
      
             
	                   <c:if test="${not empty totalPriceFormat}">
	                <div>
	                    <p style="text-align: right; font-size:x-large;"><fmt:message>cart.total</fmt:message>: ${ totalPriceFormat} </p>
	                </div>
                </c:if>
	            
               
      </b></span></p> 
      <div class="float-right">
                   
              Cảm thấy cần thay đổi?      <a href="cartCustomer.jsp"><button type="button" class="btn btn-lg btn-primary mt-2">quay lại giỏ hàng</button></a> 
                </div>
       
       
       
       
       
                        
    </div>
  </div>
</div>

</body>
</html>
