<%-- 
    Document   : signup
    Created on : Oct 6, 2013, 3:43:59 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class='row hide-for-small'>
    <div class='twelve columns'>
        <div class='heading_dots'><h1 class='heading_supersize'><span class='heading_center_bg'>Đăng kí</span></h1></div>
    </div>

</div><!-- end row -->
<div class='row'>
    <div class='twelve columns'>
        <div class='blog_post'><!-- Begin Blog Post --> 
            <div class='six columns'>
                <form name='input' action='save' method='post'>
                    <label style='font-weight:bold'>Tên đăng nhập</label>
                    <input type='text' name='user'>
                    <label style='font-weight:bold'>Mật khẩu</label>
                    <input type='password' name='password'>
                    <!-- 		<label style='font-weight:bold'>Nhắc lại mật khẩu</label>
                                    <input type='text' name='repassword'> -->
                    <input class='button small radius' type='submit' value='Đăng kí'>
                </form>
            </div> 
        </div><!-- END blog post -->
    </div><!-- END row blog -->
</div>