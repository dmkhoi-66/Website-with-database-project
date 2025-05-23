/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Cart;

import JDev.ClothesShop.BLL.PhieuMuaHangBLL;
import JDev.ClothesShop.DAO.ChiTietPhieuMuaHang;
import JDev.ClothesShop.DAO.PhieuMuaHang;
import JDev.ClothesShop.DAO.SanPham;
import JDev.ClothesShop.DAO.TaiKhoan;
import JDev.ClothesShop.Web.Action.Action;
import JDev.ClothesShop.Web.DAO.Cart;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class Pay extends Action {

    public String execute() {
        HttpSession httpSession = request.getSession();
        TaiKhoan taiKhoan = (TaiKhoan) httpSession.getAttribute("login");

        if (taiKhoan == null) {
            return "REDIRECT TO LOGIN";
        } else {
            Cart cart = (Cart) httpSession.getAttribute("CART");

            PhieuMuaHang phieuMuaHang = new PhieuMuaHang();
            phieuMuaHang.setKhachHang(taiKhoan);
            phieuMuaHang.setNgayMua(new Date());

            for (int i = 0; i < cart.count(); i++) {
                SanPham sanPham = cart.getProduct(i);
                int stock = cart.getStock(i);

                ChiTietPhieuMuaHang chiTietPhieuMuaHang = new ChiTietPhieuMuaHang();
                chiTietPhieuMuaHang.setGia(sanPham.getGia());
                chiTietPhieuMuaHang.setMaSanPham(sanPham.getMaSanPham());
                chiTietPhieuMuaHang.setSoLuong(stock);

                phieuMuaHang.getDanhSachHang().add(chiTietPhieuMuaHang);
            }

            PhieuMuaHangBLL.add(phieuMuaHang);

            httpSession.removeAttribute("CART");

            return "SUCCESS";
        }
    }
}
