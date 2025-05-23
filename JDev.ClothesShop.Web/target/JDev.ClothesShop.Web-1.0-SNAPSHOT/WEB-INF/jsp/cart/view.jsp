<%-- 
    Document   : cart
    Created on : Oct 6, 2013, 3:26:59 PM
    Author     : Jeremy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Giỏ hàng</span></h1></div>
    </div>
</div><!-- end row -->
<div style='clear: both'></div>

<c:if test="${fn:length(cartCart.list) > 0}">
    <a href='pay'>Thanh toán</a>
    <p></p>
    <div id='container'>

        <c:forEach var="item" items="${cartCart.list}" varStatus="status">
            <c:set var ="stock" value="${cartCart.listStock[status.index]}" ></c:set>
                <div class='box photo col2'>
                    <a href='#'><img src="../${item.anh}" /></a>
                <h4 style='text-align:center'><strong><a href="../product/detail?id=${item.maSanPham}" >${item.tenSanPham} </a></strong></h4>
                <p>Giá: <fmt:formatNumber value="${item.gia}"></fmt:formatNumber>  VND
                    <br/>Số lượng: <fmt:formatNumber value="${stock}"></fmt:formatNumber> Cái
                    <br/>Tổng tiền: <fmt:formatNumber value="${item.gia * stock}" groupingUsed="true" ></fmt:formatNumber> VND                    
                    </p>

                    <p style='text-align:center'>
                        <a href="update?index=${status.index}" class='button small radius'>Sửa</a>
                        <a href="delete?index=${status.index}" class='button small radius'>Xóa</a>
                    </p>
                </div>
        </c:forEach>

    </div> <!-- end Masonry container -->
</c:if>