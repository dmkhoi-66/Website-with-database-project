<%-- 
    Document   : search
    Created on : Oct 6, 2013, 11:11:16 PM
    Author     : Jeremy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Tìm kiếm</span></h1></div>
    </div>
</div><!-- end row -->
<div class='row'>
    <div class='twelve columns'>
        <div class='blog_post'><!-- Begin Blog Post --> 
            <div class='six columns'>
                <form name='input' action='searchresult' method='get'>

                    <label style='font-weight:bold'>Danh Mục</label>
                    <select name='catalogue'>
                        <option value='-1'> Tất cả</option>
                        <c:forEach var="item" items="${danhMucs}">
                            <option value="${item.maDanhMuc}">${item.tenDanhMuc}</option>
                        </c:forEach>
                    </select>

                    <label style='font-weight:bold'>Màu sắc</label>
                    <select name='color'>
                        <option value='-1'> Tất cả</option>
                        <c:forEach var="item" items="${mauSacs}">
                            <option value="${item.maMauSac}">${item.loaiMau}</option>
                        </c:forEach>
                    </select>

                    <label style='font-weight:bold'>Kích thước</label>
                    <select name='size'>
                        <option value='-1'> Tất cả</option>
                        <c:forEach var="item" items="${kichThuocs}">
                            <option value="${item.maKichThuoc}">${item.kichThuoc}</option>
                        </c:forEach>
                    </select>

                    <label style='font-weight:bold'>Giá nhỏ nhất</label>
                    <input type='number' value='0' min='0' name='min'>
                    <label style='font-weight:bold'>Giá lớn nhất</label>
                    <input type='number' value='1000000' min='0' name='max' >
                    <br/>
                    <input type='submit' value='Tìm kiếm' class='button small radius' >
                </form>
            </div> 
        </div><!-- END blog post -->

    </div><!-- END row blog -->
    
</div>