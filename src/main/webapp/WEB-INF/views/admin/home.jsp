<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<base href="http://localhost:8090/springtest/" >
	<meta charset="UTF-8">
	<title>Admin</title>
	<script src="./resources/js/jquery-3.3.1.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="./resources/css/css.css">
</head>
<body>
	<div class="page-wrapper chiller-theme toggled">
		<!-- sidebar -->
		<%@include file="common/sidebarmenu.jsp" %>
		<!-- sidebar-wrapper  -->
		<main class="page-content">
			<%@include file="common/header.jsp" %>
		
			<div class="container">
				 <div class="row">
			          <div class="col-lg-3 col-6">
			            <!-- small box -->
			            <div class="small-box bg-info card">
			              <div class="inner">
			                <h3>150</h3>
			
			                <p>New Orders</p>
			              </div>
			              <div class="icon">
			                <i class="fa fa-shopping-bag" aria-hidden="true"></i>
			              </div>
			              <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
			            </div>
			          </div>
			          
			          <div class="col-lg-3 col-6">
			            <!-- small box -->
			            <div class="small-box bg-success card">
			              <div class="inner">
			                <h3>53<sup style="font-size: 20px">%</sup></h3>
			
			                <p>Product total</p>
			              </div>
			              <div class="icon">
			                <i class="fa fa-male" aria-hidden="true"></i>
			              </div>
			              <a href="./admin/product" class="small-box-footer">More info <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
			            </div>
			          </div>
		          <!-- ./col -->
		          <div class="col-lg-3 col-6">
		            <!-- small box -->
		            <div class="small-box bg-warning card">
		              <div class="inner">
		                <h3>44</h3>
		
		                <p>User Registrations</p>
		              </div>
		              <div class="icon">
		                <i class="fa fa-user-o" aria-hidden="true"></i>
		              </div>
		              <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
		            </div>
		          </div>
		          <!-- ./col -->
		          <div class="col-lg-3 col-6">
		            <!-- small box -->
		            <div class="small-box bg-danger card">
		              <div class="inner">
		                <h3>65</h3>
		
		                <p>Unique Visitors</p>
		              </div>
		              <div class="icon">
		                <i class="fa fa-users" aria-hidden="true"></i>
		              </div>
		              <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
		            </div>
		          </div>
          		</div>
				<div class="row">
				
				</div>
			</div>
		</main>
		<!-- page-content" -->
	</div>
	<!-- page-wrapper -->

	<script src='<c:url value="/resources/js/customadmin.js" />'></script>
</body>
</html>