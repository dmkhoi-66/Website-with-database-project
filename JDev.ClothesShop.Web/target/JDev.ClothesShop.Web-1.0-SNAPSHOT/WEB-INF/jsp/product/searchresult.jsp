<%-- 
    Document   : searchresult
    Created on : Oct 6, 2013, 11:24:12 PM
    Author     : Jeremy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <c:if test="${0 < fn:length(sanphamsResult)}">
            <div class='heading_dots'>
                <h1 class='heading_supersize'><span class='heading_center_bg'>Kết quả</span></h1>
            </div>
        </c:if>
        <c:if test="${0 >= fn:length(sanphamsResult)}">
            <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Không tìm thấy sản phẩm</span></h1></div>
        </c:if>
    </div>
</div>

<p>
    <c:if test="${0 < fn:length(tempResult)}">
        <c:if test="${0 < idResult}">
            <a href="${preResult}">Trang Trước</a> - 
        </c:if>
        <c:if test="${0 >= idResult}">
            <a href="${nextResult}">Trang Tiếp</a>
        </c:if>
        <c:if test="${0 < idResult}">
            <a href="${nextResult}">Trang Tiếp</a>
        </c:if>
    </c:if>
    <c:if test="${0 >= fn:length(tempResult)}">
        <c:if test="${0 < idResult}">
            <a href="${preResult}">Trang Trước</a>
        </c:if>
    </c:if>
</p>

<c:forEach var="item" items="${sanphamsResult}">
    <div class='box photo col2'>
        <a href='#'><img src="../${item.anh}" /></a>
        <h4 style='text-align:center'><strong><a href="../product/detail?id=${item.maSanPham}">${item.tenSanPham}</a></strong></h4>
        <p>Màu sắc: ${item.mauSac.loaiMau}
            <br/>Kích thước:  ${item.kichThuoc.kichThuoc}
            <br/>Giá: <fmt:formatNumber value="${item.gia}" ></fmt:formatNumber>VND
            </p>
        </div>
</c:forEach>