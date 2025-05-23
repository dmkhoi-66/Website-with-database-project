<%-- 
    Document   : product
    Created on : Oct 6, 2013, 3:02:16 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>${sanphamProduct.tenSanPham}</span></h1></div>
    </div>
</div><!-- end row -->

<div class='row'>
    <div class='six columns'>
        <img src="../${sanphamProduct.anh}" alt='Product Image Description'>
    </div>
    <div class='six columns'>
        <div class='panel'>
            <h3>Bảng giá</h3>
            <p style='font-style: italic; font-family: Georgia'>Đã bao gồm thuế VAT</p>
            <form name='product_list' action='addtocart'>
                <label style='font-weight:bold'>Màu sắc</label>
                <select name='color'>
                    <option value="${sanphamProduct.mauSac.maMauSac}">${sanphamProduct.mauSac.loaiMau}</option>
                </select>
                <label style='font-weight:bold'>Kích thước</label>
                <select name='size'>
                    <option value="${sanphamProduct.kichThuoc.maKichThuoc}">${sanphamProduct.kichThuoc.kichThuoc}</option>
                </select>
                <label style='font-weight:bold'>Số lượng</label>
                <input name='stock' id='stock' value='1' class='input_title_invoice' type='number' min='1'>
                <p style='font-size: 24px'>Giá: <span id='grandTotal'><fmt:formatNumber value="${sanphamProduct.gia}"></fmt:formatNumber> VND</span></p>
                <input class='button small radius' type='submit' value='Đưa vào giỏ hàng'>
                <input id='productid' name = 'productid' type='hidden' value="${sanphamProduct.maSanPham}">
                </button>
            </form>
        </div> <!-- end panel -->
    </div>
</div><!-- end row -->
<h4>Thông tin chi tiết</h4>
<div class='row'>
    <div class='twelve columns'>
        <dl class='tabs three-up'>
            <dd class='active'><a href='#simple1'>Overview</a></dd>
            <dd><a href='#simple2'>Spesifications</a></dd>
            <dd><a href='#simple3'>Customer Reviews</a></dd>
        </dl>
        <ul class='tabs-content'>
            <li class='active' id='simple1Tab'>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dictum porttitor lacus, eget commodo turpis laoreet at. Donec pretium, enim ut tempor mattis, nisi nunc dapibus dui, et ultricies odio justo a elit.</p>
                <ul>
                    <li>Lorem</li>
                    <li>Ipsum</li>
                    <li>Dolor</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dictum porttitor lacus, eget commodo turpis laoreet at. Donec pretium, enim ut tempor mattis, nisi nunc dapibus dui, et ultricies odio justo a elit.</p> 
            </li>
            <li id='simple2Tab'>Some content</li>
            <li id='simple3Tab'><p><strong>John Doe:</strong> Amazing Product</p> <p><strong>Jane Doe:</strong> Ok Product</p> <p><strong>Doe Doe:</strong> Cool</p></li>
        </ul>
    </div>
</div>