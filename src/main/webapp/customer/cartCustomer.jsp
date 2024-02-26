<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <%@include file="../includes/head.jsp"%>
    
</head>
<body>
	<fmt:setLocale value="${sessionScope.LANG}" />
	<fmt:setBundle basename="language.lang" />
	
    <style>
        body {
            margin-top: 20px;
            background: #eee;
        }

        .ui-w-40 {
            width: 40px !important;
            height: auto;
        }

        .card {
            box-shadow: 0 1px 15px 1px rgba(52, 40, 104, .08);
        }

        .ui-product-color {
            display: inline-block;
            overflow: hidden;
            margin: .144em;
            width: .875rem;
            height: .875rem;
            border-radius: 10rem;
            -webkit-box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.15) inset;
            box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.15) inset;
            vertical-align: middle;
        }
    </style>

    <div class="container px-3 my-5 clearfix">
    
        <!-- Shopping cart table -->
        <div class="card">
            <div class="card-header">
                <h2><fmt:message>cart.title</fmt:message></h2>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered m-0">
                        <thead>
                            <tr>
                                <!-- Set columns width -->
                                <th class="text-center py-3 px-4" style="min-width: 400px;"><fmt:message>cart.name</fmt:message></th>
                                <th class="text-center py-3 px-4" style="width: 100px;"><fmt:message>cart.price</fmt:message></th>
                                <th class="text-center py-3 px-4" style="width: 120px;"><fmt:message>cart.amount</fmt:message></th>
                                <th class="text-center py-3 px-4" style="width: 125px;"><fmt:message>cart.total</fmt:message></th>
                                <th class="text-center align-middle py-3 px-0"
                                    style="width: 40px;">
                                    <a href="#"
                                        class="shop-tooltip float-none text-light" title=""
                                        data-original-title="Clear cart"><i
                                            class="ino ion-md-trash"></i></a>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="totalPrice" value="0" />
                            <c:forEach items="${order.orderDetails}" var="item">
                                <tr>
                                    <td class="p-4">
                                        <div class="media align-items-center">
                                            <img src="${item.product.img }"
                                                class="d-block ui-w-40 ui-bordered mr-4" alt="">
                                            <div class="media-body">
                                                <a href="#" class="d-block text-dark">${item.product.productName }</a> <small>
                                                    <span class="text-muted">Ships from: </span> ${item.product.manufacture.address }
                                                </small>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right font-weight-semibold align-middle p-4">${item.product.formatPrice(item.product.getPriceSale())}</td>
                                    <td class="align-middle p-4"><input type="text" 
                                        class="form-control text-center" value="${item.quantity }"></td>
                                    <td class="text-right font-weight-semibold align-middle p-4">${item.getSingleP()}</td>
                                    <td class="text-center align-middle px-0">
                                        <a href="remove-product?productId=${item.product.productID}"
                                            class="shop-tooltip close float-none text-danger" title=""
                                            data-original-title="Remove">×</a>
                                    </td>
                                </tr>
                                <c:set var="totalPrice" value="${totalPrice + (item.product.priceSale* item.quantity)}" />
                                <c:set var="totalPriceFormat" value="${item.product.formatPrice(totalPrice)}" />
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- / Shopping cart table -->
                <c:if test="${not empty totalPriceFormat}">
	                <div>
	                    <p style="text-align: right; font-size:x-large;"><fmt:message>cart.total</fmt:message>: ${ totalPriceFormat} </p>
	                </div>
                </c:if>
                <div class="float-right">
                    <a href="../product.jsp"><button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3"><fmt:message>cart.back</fmt:message></button></a>
                    <a href="order.jsp"><button type="button" class="btn btn-lg btn-primary mt-2"><fmt:message>cart.button.checkout</fmt:message></button></a> 
                </div>
            </div>
        </div>
    </div>
    <%@include file="../includes/footer.jsp"%>
</body>
</html>
