<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__close">+</div>
        <ul class="offcanvas__widget">
            <li><span class="icon_search search-switch"></span></li>
            <li><a href="#"><span class="icon_heart_alt"></span>
                <div class="tip">2</div>
            </a></li>
            <li><a href="#"><span class="icon_bag_alt"></span>
                <div class="tip">2</div>
            </a></li>
        </ul>
        <div class="offcanvas__logo">
            <a href="./index.html"><img src="resources/img/logo.png" alt=""></a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <a href="#">Login</a>
            <a href="#">${ssUser}</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->
    
    <!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2">
                    <div class="header__logo">
                        <a href="./"><img src="resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="./">Home</a></li>
                            <li><a href="./Categories/Men's">Men’s</a></li>
                            <li><a href="./Categories/Women's">Women’s</a></li>                   
                            <li><a href="./shop">Shop</a></li>
                            <li><a href="./Categories">Categories</a>
                                <ul class="dropdown">
                                <c:forEach var="list" items="${listDoiTuong}">
                                    <li><a href="./Categories/${list.getTenDoiTuong()}">${list.getTenDoiTuong()}</a></li>
                                </c:forEach>                         
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                        <c:choose>
                        	<c:when test="${ssUser != null}">
                        		<a>${ssUser}</a>
                        	</c:when>
                        	<c:otherwise>
                        		<a href="login">Login</a>
                        	</c:otherwise>
                        </c:choose>
                            
                        </div>
                        <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <li><a href="#"><span class="icon_heart_alt"></span>
                                <div class="tip">2</div>
                            </a></li>
                            <li id="show_cart"><a href="./shop-cart"><span class="icon_bag_alt"></span>  
                            	<c:if test="${soluongsp > 0}">
                            		<div class="tip soluongSP">${soluongsp}</div>      
                            	</c:if>                      
                            	<c:if test="${soluongsp <= 0 || soluongsp == null}">
                            		<div class="tip soluongSP" style="display: none;"></div>      
                            	</c:if>                  			              
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
</header>

