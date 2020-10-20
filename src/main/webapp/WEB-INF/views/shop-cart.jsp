<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8090/springtest/">
<meta charset="UTF-8">
<meta name="keywords" content="Ashion, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Shop</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cookie&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<%@include file="comon/head.jsp"%>
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Offcanvas Menu Begin -->
	<%@include file="comon/menu.jsp"%>
	<!-- Header Section End -->

	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb__links">
						<a href="./"><i class="fa fa-home"></i> Home</a> <span>Shop-cart</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Content main start-->
	<c:choose>
		<c:when test="${listprd != null && listprd.size() > 0}">
			<section class="shop-cart spad">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="shop__cart__table">
								<table>
									<thead>
										<tr>
											<th>Product</th>
											<th>Price</th>
											<th colspan="2">Size - Color</th>
											<th>Quantity</th>
											<th>Total</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<!-- Start Product -->
										<c:forEach var="listItems" items="${listprd}">
											<tr>
												<td class="cart__product__item"><img
													src="resources/img/shop-cart/cp-3.jpg" alt="">
													<div class="cart__product__item__title">
														<h6>
															<a class="idSP" style='color: black;'
																href="./product-details/${listItems.getIdSP()}"
																data-idSP="${listItems.getIdSP()}">${listItems.getTenSP()}</a>
														</h6>
														<div class="rating">
															<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i>
														</div>
													</div></td>
												<td class="cart__price price_prd price"
													data-price="${listItems.getGiaSP()}">VNĐ
													${listItems.getGiaSP()}</td>
												<td class="cart__price color_pr"
													data-mau="${listItems.getIdMau()}">${listItems.getTenMau()}</td>
												<td class="cart__price size_pr"
													data-size="${listItems.getIdSize()}">${listItems.getTenSize()}</td>
												<td class="cart__quantity">
													<div class="pro-qty">
														<input class="price_total sl" type="number"
															value="${listItems.getSoluongSP()}" min="0" max="5" />
													</div>
												</td>
												<td class="cart__total total-pr price">VNĐ
													${listItems.getGiaSP() * listItems.getSoluongSP()}</td>
												<td class="cart__close"><span
													class="icon_close btn-del"></span></td>
											</tr>
										</c:forEach>

										<!-- End Product -->
										<tr>
											<td colspan="3"></td>
											<td colspan="2" style="text-align: center;">Total:</td>
											<td class="cart__total price" id="total1">VNĐ ${tong}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="cart__btn">
								<a href="./shop">Continue Shopping</a>
							</div>
						</div>
					</div>

					<div class="checkout-info"></div>
					<div class="row" style="margin-top: 5px; padding-left: 55px;">
						<form style="width: 95%;" method="post" accept-charset="utf-8">
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Number phone</label>
								<div class="col-sm-5">
									<input type="text" name="soDT" class="form-control"
										placeholder="Phone number..." required>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Full name</label>
								<div class="col-sm-10">
									<input type="text" name="tenKH" class="form-control"
										placeholder="Full name..." required>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Address</label>
								<div class="col-sm-10">
									<input type="text" name="diaChi" class="form-control"
										placeholder="Address..." required>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">Note</label>
								<textarea class="form-control" name="ghiChu"
									id="exampleFormControlTextarea1" rows="3"></textarea>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<div class="discount__content">
										<h6>Discount codes</h6>
										<div>
											<input type="text" placeholder="Enter your coupon code">
											<button type="button" class="site-btn">Apply</button>
										</div>
									</div>
								</div>
								<div class="col-lg-4 offset-lg-2">
									<div class="cart__total__procced">
										<h6>Cart total</h6>
										<ul>
											<li>Subtotal <span class="price" id="total">VNĐ
													${tong}</span></li>
											<li>Total <span class="price" id="totals">VNĐ
													${tong}</span></li>
										</ul>
										<button type="submit" class="site-btn">Checkout</button>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="checkout-info"></div>
					<br>

				</div>
			</section>
		</c:when>

		<c:otherwise>
			<section class="shop-cart spad">
			<div class="container">
				<p>No product in cart!</p>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<div class="cart__btn">
							<a href="./shop">Continue Shopping</a>
						</div>
					</div>
				</div>
			</div>
			</section>
		</c:otherwise>
	</c:choose>

	<!-- Content main end-->


	<!-- Instagram Begin -->
	<div class="instagram">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-1.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-2.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-3.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-4.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-5.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 col-sm-4 p-0">
					<div class="instagram__item set-bg"
						data-setbg="resources/img/instagram/insta-6.jpg">
						<div class="instagram__text">
							<i class="fa fa-instagram"></i> <a href="#">@ ashion_shop</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Instagram End -->

	<!-- Footer Section Begin -->
	<%@include file="comon/footer.jsp"%>
	<!-- Footer Section End -->

	<!-- Search Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search End -->

	<!-- Js Plugins -->
	<%@include file="comon/foot.jsp"%>
</body>
</html>