<%-- 
    Document   : login
    Created on : Oct 6, 2013, 3:47:53 PM
    Author     : Jeremy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="JDev.ClothesShop.DAO.TaiKhoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession t_httpSession = request.getSession();
    TaiKhoan t_taiKhoan = (TaiKhoan) t_httpSession.getAttribute("login");

    if (t_taiKhoan != null) {
        t_httpSession.removeAttribute("login");
    }
%>

<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Đăng nhập</span></h1></div>
    </div>

</div><!-- end row -->
<div class='row'>
    <div class='twelve columns'>

        <div class='blog_post'><!-- Begin Blog Post --> 
            <div class='six columns'>
                <form name='input' action='sendlogin' method='post'>
                    <label style='font-weight:bold'>Tên đăng nhập</label>
                    <input type='text' name='user'>
                    <label style='font-weight:bold'>Mật khẩu</label>
                    <input type='password' name='password'/>
                    <!-- 		<label style='font-weight:bold'>Nhắc lại mật khẩu</label>
                                    <input type='text' name='repassword'> -->
                    <input type='submit' value='Đăng nhập' class='button small radius' />
                </form>
                <p><a href='signup'>Đăng kí nếu chưa có</a></p>
            </div> 
        </div><!-- END blog post -->
    </div><!-- END row blog -->

</div>