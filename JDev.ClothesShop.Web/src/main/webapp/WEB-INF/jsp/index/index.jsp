<%--
    Document   : index
    Created on : Oct 6, 2013, 7:54:23 AM
    Author     : Jeremy
--%>

<%@page import="JDev.ClothesShop.BLL.SanPhamBLL"%>
<%@page import="JDev.ClothesShop.DAO.SanPham"%>
<%@page import="JDev.ClothesShop.DAO.TaiKhoan"%>
<%@page import="JDev.ClothesShop.DAO.DanhMuc"%>
<%@page import="JDev.ClothesShop.BLL.DanhMucBLL"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <!-- Set the viewport width to device width for mobile -->
        <meta name="viewport" content="width=device-width" />
        <title>Epic</title>

        <!-- Included CSS Files (Uncompressed) -->
        <!--
        <link rel="stylesheet" href="stylesheets/foundation.css">
        -->

        <!-- Included CSS Files (Compressed) -->
        <link rel="stylesheet" href="../../stylesheets/foundation.min.css">
        <link rel="stylesheet" href="../../stylesheets/main.css">
        <link rel="stylesheet" href="../../stylesheets/app.css">

        <script src="../../javascripts/modernizr.foundation.js"></script>

        <!-- Google fonts 
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display:400italic' rel='stylesheet' type='text/css' /> 
        -->

        <!-- IE Fix for HTML5 Tags -->
        <!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>
    <body>

        <div class="row page_wrap">
            <!-- page wrap -->
            <div class="twelve columns">
                <!-- page wrap -->

                <div class="row">
                    <div class="twelve columns header_nav">

                        <div class="twelve columns">
                            <ul id="menu-header" class="nav-bar horizontal">

                                <li><a href="../index/"><img src="../../images/logo.png" alt="desc" style="border:none" /></a></li>

                                <li class=""><a href="../index/">Trang Chủ</a></li>

                                <li class="has-flyout">
                                    <a href="../product/view?catalogue=-1">Sản phẩm</a><a href="#" class="flyout-toggle"></a>

                                    <% List<DanhMuc> danhMucs = DanhMucBLL.getAll();%>
                                    <ul class="flyout">
                                        <%

                                            for (int i = 0; i < danhMucs.size(); i++) {
                                                DanhMuc danhMuc = danhMucs.get(i);
                                        %>
                                        <%="<li class='has-flyout'>"%>
                                        <%="<a href='../product/view?catalogue=" + danhMuc.getMaDanhMuc() + "'>" + danhMuc.getTenDanhMuc() + "</a>"%>
                                        <%="</li>"%>
                                        <%}%>
                                    </ul>
                                </li>

                                <%
                                    HttpSession httpSession = request.getSession();
                                    TaiKhoan taiKhoan = (TaiKhoan) httpSession.getAttribute("login");
                                    if (taiKhoan == null) {
                                %>

                                <%="			   <li class='has-flyout'>"%>
                                <%="                <a href='#'>Tài khoản</a><a href='account' class='flyout-toggle'></a>"%>
                                <%="                <ul class='flyout'>"%>
                                <%="                  <li class='has-flyout'><a href='../account/signup'>Đăng kí</a></li>"%>
                                <%="                  <li class='has-flyout'><a href='../account/login'>Đăng nhập</a></li>"%>
                                <%="                </ul>"%>
                                <%="              </li>"%>

                                <%} else {%>
                                <%="			   <li class='has-flyout'>"%>
                                <%="                <a href='#'>" + taiKhoan.getTenDangNhap() + "</a><a href='account' class='flyout-toggle'></a>"%>;
                                <%="                <ul class='flyout'>"%>
                                <%="                  <li class='has-flyout'><a href='../account/history'>Lịch sử mua hàng</a></li>"%>
                                <%="                  <li class='has-flyout'><a href='../account/logout'>Đăng xuất</a></li>"%>
                                <%="                </ul>"%>
                                <%="              </li>"%>
                                <%                                        }%>

                                <li class=""><a href="../product/search">Tìm kiếm</a></li>

                                <li class=""><a href="../cart/view">Giỏ hàng</a></li>
                            </ul>
                            <script type="text/javascript">
                                //<![CDATA[
                                $('ul#menu-header').nav - bar();
                                //]]>
                            </script>
                        </div>
                    </div>
                </div><!-- END Header -->

                <% String pageLoad = (String) request.getAttribute("page");%>

                <%
                    if (pageLoad == null) {
                %>
                <%@include file="main.jsp" %>
                <%} else {%>

                <%
                    if (pageLoad == "product") {
                %>
                <%@include file="../product/product.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "productview") {
                %>
                <%@include file="../product/view.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "cart") {
                %>
                <%@include file="../cart/view.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "cartupdate") {
                %>
                <%@include file="../cart/cartupdate.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "signup") {
                %>
                <%@include file="../account/signup.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "login") {
                %>
                <%@include file="../account/login.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "history") {
                %>
                <%@include file="../account/history.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "viewhistory") {
                %>
                <%@include file="../account/viewhistory.jsp" %>
                <%}%>

                <%
                    if (pageLoad == "search") {
                %>
                <%@include file="../product/search.jsp" %>
                <%}%>

                 <%
                    if (pageLoad == "searchresult") {
                %>
                <%@include file="../product/searchresult.jsp" %>
                <%}%>
                
                <%}%>
                <div class="row">
                    <div class="twelve columns">
                        <ul id="menu3" class="footer_menu horizontal">
                            <li class=""><a href="../index/">Home</a></li>
                        </ul>
                    </div>
                </div>

            </div>

        </div><!-- end page wrap) -->
        <!-- Included JS Files (Compressed) -->
        <script src="../../javascripts/foundation.min.js" type="text/javascript">
        </script> <!-- Initialize JS Plugins -->
        <script src="../../javascripts/app.js" type="text/javascript">
        </script>

    </body>
</html>
