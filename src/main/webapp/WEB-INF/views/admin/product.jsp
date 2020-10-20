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
				<h5>
					<small>Home > Product</small>
				</h5>
				<hr>
				<div class="row container" >
					<button class="btn btn-primary btn-sm rounded-0" type="button" data-toggle="modal" data-target="#exampleModalLong" id="add"  title="Add"><i class="fa fa-plus" aria-hidden="true"></i></button>
					&nbsp; &nbsp;
					<button id="btnXoa" class="btn btn-danger btn-sm rounded-0" type="button" title="Delete"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
				</div>
				
				<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
				  <div class="modal-dialog modal-lg" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLongTitle">Add </h5> 
							<div id="loader-add" role="status" style="margin-left: 50%;">
								<span class="sr-only">Loading...</span>
							</div>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        <form id="formData" method="post">
				        	<div class="form-group row">
							    <label for="colFormLabelSm" class="col-sm-1 col-form-label col-form-label-sm">Product</label>
							    <div class="col-sm-5">
							      <input type="text" id="tenSP" name="tenSP" class="form-control form-control-sm" placeholder="Name product" required>
							    </div>
							    							   
							    
							    <label for="colFormLabelSm" class="col-sm-1 col-form-label col-form-label-sm">Price</label>
							    <div class="col-sm-5">
							      <input type="number" id="giaTien" name="giaTien" class="form-control form-control-sm"  min="1" placeholder="Price" required>
							    </div>
							</div>
							
							<div class="form-group row">
							     <label for="colFormLabelSm" class="col-sm-1 col-form-label col-form-label-sm">Detail</label>
							    <div class="col-sm-10">
							      <textarea class="form-control" name="moTa" id="moTa" rows="3"></textarea>
							    </div>
							</div>
							
							<div class="form-group row">
							    <label for="colFormLabelSm" class="col-sm-1 col-form-label col-form-label-sm">Categories</label>
							    <div class="col-sm-5">
							      <select class="form-control" name="doiTuong" id="doituong">
							      	<option>Chose...</option>	
							      	<c:forEach var="dt" items="${listDT}">
								      <option value="${dt.getIdDoiTuong()}">${dt.getTenDoiTuong()}</option>
								    </c:forEach>								    
								    </select>
							    </div>
							    
							    <label for="colFormLabelSm" class="col-sm-1 col-form-label col-form-label-sm">Type</label>
							    <div class="col-sm-5">
							      <select class="form-control" name="loaisp" id="loai">
								      <option>Chose...</option>	
								      						      
								    </select>
							    </div>
							    
							</div>

						  <div class="form-group row">
						    <label for="picture-pr">Chose picture</label>
						    <input type="file" name="hinhSP" class="form-control-file" id="picture-pr">
						  </div>
					</form>
				
						  <div class="container_pr row">
						  	<div class="more_detail col-md-6 chitietsanpham" style="width: 320px;">
							   <div class="form-group row">
								    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Size</label>
								    <div class="col-sm-10">
									    <select class="form-control" name ="sizeSP" id="size">
									      <option value="1">XS</option>
										  <option value="2">S</option>
										  <option value="3">M</option>
										  <option value="4">L</option>
										  <option value="5">XL</option>
										  <option value="6">XXL</option>
										  <option value="7">XXS</option>
									    </select>
								    </div>
								</div>
								<div class="form-group row">
								    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Color</label>
								    <div class="col-sm-10">
								       <select class="form-control" name="mauSP" id="color">
									      <option value="1">Red</option>
										  <option value="2">Green</option>
										  <option value="3">Yellow</option>
										  <option value="4">Grey</option>
										  <option value="5">Black</option>
										  <option value="6">White</option>
										  <option value="7">Brown</option>
									    </select>
								    </div>
								</div>
								
								<div class="form-group row">
								    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Quantity</label>
								    <div class="col-sm-10">
								      <input type="number" min="1" id="soluong" name="soluong" class="form-control form-control-sm" required>
								    </div>
								</div>
								<button type="button" class="btn btn-primary btn-chitiet">Thêm chi tiết</button>
						  	</div>
						  </div>
						  
						  <div id="chitietsanpham" class="more_detail col-md-6 chitietsanpham" style="width: 320px;">
						   <div class="form-group row">
							    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Size</label>
							    <div class="col-sm-10">
								    <select class="form-control" name ="sizeSP" id="size">
									      <option value="1">XS</option>
										  <option value="2">S</option>
										  <option value="3">M</option>
										  <option value="4">L</option>
										  <option value="5">XL</option>
										  <option value="6">XXL</option>
										  <option value="7">XXS</option>
									    </select>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Color</label>
							    <div class="col-sm-10">
							       <select class="form-control" name="mauSP" id="color">
									   	<option value="1">Red</option>
										<option value="2">Green</option>
										<option value="3">Yellow</option>
										<option value="4">Grey</option>
										<option value="5">Black</option>
										<option value="6">White</option>
										<option value="7">Brown</option>
									</select>
							    </div>
							</div>
							
							<div class="form-group row">
							    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Quantity</label>
							    <div class="col-sm-10">
							      <input type="number" min="1" id="soluong" name="soluong" class="form-control form-control-sm" required>
							    </div>
							</div>
							<button type="button" class="btn btn-primary btn-chitiet">Thêm chi tiết</button>
						  </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="btnCancel">Cancel</button> 
				        <button type="submit" form="formData" class="btn btn-primary" id="btnAdd">Add new</button>
				        <button type="submit" form="formData" class="btn btn-primary hidden" id="btnCapnhat">Update</button>
				      </div>
				    </div>
				  </div>
				</div>
				<br>
				<table class="table" id="listBody">
					<thead>
						<tr>							
							<th><input type="checkbox" id="checkall" /></th>
							<th scope="col">Picture</th>
							<th scope="col">Name Product</th>
							<th scope="col">Price</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="list" items="${listsp}" >
						<tr>
							<td><input type="checkbox" value="${list.getIdSP() }"/></td>
							<td> <img style="width: 55px;" src="resources/img/product/${list.getHinhSP()}"></td>
							<td>${list.getTenSP()}</td>
							<td class="price">VNĐ ${list.getGiaTien()}</td>		
							<td>
								<ul class="list-inline m-0">
                                    <li class="list-inline-item">
                                        <button class="btn btn-success btn-sm rounded-0 btnUpdate" data-sp="${list.getIdSP() }" type="button" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                                    </li>
                                    <li class="list-inline-item">
                                      	<button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Preview"><i class="fa fa-eye" aria-hidden="true"></i></button>
                                    </li>
                             	</ul>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div>
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item"><a class="page-link">Previous</a></li>
					    <c:forEach var="i" begin="1" end="${page}" >
					    	<c:choose>
						         <c:when test = "${i == 1}">
						            <li class="page-item active page"><a class="page-link">${i}</a></li>
						         </c:when>				         
						      
						         <c:otherwise>
						            <li class="page-item page"><a class="page-link">${i}</a></li>
						         </c:otherwise>
						      </c:choose>
					    </c:forEach>
					    <li class="page-item"><a class="page-link">Next</a></li>
					  </ul>
					</nav>
				</div>
			</div>
		</main>
		<!-- page-content" -->
	</div>
	<!-- page-wrapper -->
	<script src='<c:url value="/resources/js/customadmin.js" />'></script>
</body>
</html>