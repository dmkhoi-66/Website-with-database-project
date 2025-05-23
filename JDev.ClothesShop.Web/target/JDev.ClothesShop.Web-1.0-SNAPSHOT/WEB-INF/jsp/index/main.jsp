
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="show-for-large-up">
    <div class="row">
        <div class="twelve columns">
            <div id="featured">
                <img src="../images/ao-da-banh-tu-thiet-ket-nike.jpg" alt="desc" /> 
                <img src="../images/ao-tennis-tu-thiet-ke.jpg" alt="desc" /> 
                <img src="../images/ao-patin-tu-thiet-ke.jpg" alt="desc" />
                <img src="../images/quan-ao-the-thao-tu-thiet-ke-ring.jpg" alt="desc" />
            </div>
        </div>
    </div>
</div>

<div class="row hide-for-small">
    <div class="twelve columns">
        <div class="heading_dots"><h1 class="heading_supersize" style="margin-bottom:10px"><span class="heading_center_bg">Sản phẩm nổi bật</span></h1></div>
    </div>
</div><!-- end row -->

<div class="row" style="padding-top: 20px">
    <c:forEach var="item" items="${sanPhams}">
        <div class='four columns'>
            <img src= "../${item.anh}" alt='desc' />
            <center>
                <h3><a href="../product/detail.do?id=${item.maSanPham}">${item.tenSanPham} </a></h3>
            </center>
        </div>
    </c:forEach> 
</div><!-- end row -->

<script type="text/javascript">
    //<![CDATA[
    $('ul#menu3').nav - bar();
    //]]>
</script>