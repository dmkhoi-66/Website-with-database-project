<%-- 
    Document   : history
    Created on : Oct 6, 2013, 10:17:55 PM
    Author     : Jeremy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="JDev.ClothesShop.BLL.SanPhamBLL"%>
<%@page import="JDev.ClothesShop.DAO.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Lịch sử mua hàng</span></h1></div>
    </div>
</div><!-- end row -->

<div style='clear: both'></div>
<p>
    <c:set var="phieuMuaHangs" value="${phieumuahangsHistory}"></c:set>
    <c:set var="temp" value="${tempHistory}"></c:set>
    <c:if test="${fn:length(temp) >  0 }">
        <c:if test="${pageHistory >  0 }">
            <a href="${preHistory}">Trang Trước</a> - 
        </c:if>
        <a href="${nextHistory}">Trang Tiếp</a>
    </c:if>
    <c:if test="${fn:length(temp) <=  0 }">
        <c:if test="${0 < pageHistory && fn:length(phieuMuaHangs) != 0 }">
            <a href="${preHistory}">Trang Trước</a>
        </c:if>
    </c:if>
</p>
<%
    int total = 0;
    pageContext.setAttribute("total", total);
%>

<div id='container'>
    <c:if test="${fn:length(phieuMuaHangs) > 0}" >    
        <c:forEach var="item" items="${phieuMuaHangs}">
            <c:remove var="index" ></c:remove>
            <c:set var="index" value="${item.danhSachHang[0].maSanPham}"></c:set>
            <c:set var="total" value="0" ></c:set>
            <%
                int index = (Integer) pageContext.getAttribute("index");
                SanPham sanPham = SanPhamBLL.get(index);
                pageContext.setAttribute("sanPham", sanPham);
            %>

            <div class='box photo col2'>
                <a href='#'><img src="../${sanPham.anh}" /></a>
                <h4 ><strong>Mã phiếu: <a href="viewhistory?id=${item.maPhieuMuaHang}"> ${item.maPhieuMuaHang} </a></strong></h4>
                <p>Ngày : ${item.ngayMua}<br/>
                    <c:forEach var="chitietphieumuahang" items="${item.danhSachHang}">
                        <c:set var="total" value="${ total + chitietphieumuahang.soLuong * chitietphieumuahang.gia}"></c:set>
                    </c:forEach>
                    Tổng tiền : <fmt:formatNumber value="${total}" groupingUsed="true"></fmt:formatNumber> VND
                    </p>
                </div>
        </c:forEach>
    </c:if>
</div> <!-- end Masonry container -->