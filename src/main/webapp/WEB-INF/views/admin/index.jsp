<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<base href="http://localhost:8090/springtest/" >
	<meta charset="UTF-8">
	<title>Admin dashboard</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<script src="./resources/js/jquery-3.3.1.min.js"></script>
	
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="./resources/css/cssadmin.css">

</head>
<body>

	<nav class="navbar navbar-light bg-light justify-content-between">
		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>
	<br>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<br>
				<h4>Admin Dashboard</h4>
				<br>
				<div class="vertical-menu">
				  <a href="./admin" class="active"><i class="fa fa-home" aria-hidden="true"> </i> Home</a>
				  <a href="./admin/product"><i class="fa fa-product-hunt" aria-hidden="true"> </i> Management Product</a>
				  <a href="./admin/deletedPr" class="menu">Product deleted</a>
				  <a href="./">Link 3</a>
				  <a href="./">Link 4</a>
				</div>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
			<!-- Start content page -->
			<div class="col-sm-10">
				<h5>
					<small>Home</small>
				</h5>
				<hr>
				
			<!-- End content page -->
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
	<script src='<c:url value="/resources/js/customadmin.js" />'></script>
</body>
</html>