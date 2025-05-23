/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.BLL.PhieuMuaHangBLL;
import JDev.ClothesShop.DAO.PhieuMuaHang;
import JDev.ClothesShop.DAO.TaiKhoan;
import JDev.ClothesShop.Web.Action.Action;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class History extends Action {

    int NumberOfView = 4;

    public String execute() {
        HttpSession t_httpSession = request.getSession();
        TaiKhoan t_taiKhoan = (TaiKhoan) t_httpSession.getAttribute("login");

        String s_page = request.getParameter("pageindex");
        int page = 0;
        if (s_page != null) {
            page = Integer.parseInt(s_page);
        }

        if (t_taiKhoan == null) {
            return "LOG IN FAIL";
        } else {
            List<PhieuMuaHang> list = PhieuMuaHangBLL.get(t_taiKhoan.getTenDangNhap(), page * NumberOfView, NumberOfView);
            List<PhieuMuaHang> temp = PhieuMuaHangBLL.get(t_taiKhoan.getTenDangNhap(), (page + 1) * NumberOfView, NumberOfView);

            String pre = String.format("history?pageindex=%d", page - 1);
            String next = String.format("history?pageindex=%d", page + 1);

            request.setAttribute("contentname", "history");
            request.setAttribute("phieumuahangsHistory", list);
            request.setAttribute("tempHistory", temp);
            request.setAttribute("preHistory", pre);
            request.setAttribute("nextHistory", next);
            request.setAttribute("pageHistory", page);
        }
        
        return "SUCCESS";
    }
}
