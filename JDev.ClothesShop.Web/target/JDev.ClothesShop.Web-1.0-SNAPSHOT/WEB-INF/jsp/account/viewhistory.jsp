<%-- 
    Document   : history
    Created on : Oct 6, 2013, 10:08:56 PM
    Author     : Jeremy
--%>

<%@page import="JDev.ClothesShop.BLL.SanPhamBLL"%>
<%@page import="JDev.ClothesShop.DAO.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Danh sách hàng</span></h1></div>
    </div>
</div><!-- end row -->

<div style='clear: both'></div>
<div id='container'>
    <c:forEach var="item" items="${phieumuahangViewHistory.danhSachHang}" varStatus="status">
        <c:set var="index" value="${status.index}"></c:set>
        <c:set var="maSanPham" value="${item.maSanPham}"></c:set>
        <%
            int maSanPham = (Integer) pageContext.getAttribute("maSanPham");
            SanPham sanPham = SanPhamBLL.get(maSanPham);

            pageContext.setAttribute("sanPham", sanPham);
        %>

        <div class='box photo col2'>
            <a href='#'><img src="../${sanPham.anh}" /></a>
            <h4 style='text-align:center'><strong><a href="../product/detail?id=${sanPham.maSanPham}">${sanPham.tenSanPham}</a></strong></h4>
            <p>Giá: <fmt:formatNumber value="${sanPham.gia}"></fmt:formatNumber> VND
                <br/>Số lượng: ${item.soLuong} Cái
                <br/>Tổng tiền: <fmt:formatNumber value="${sanPham.gia * item.soLuong}"></fmt:formatNumber> VND
                </p>
            </div>
    </c:forEach>

</div> <!-- end Masonry container -->

