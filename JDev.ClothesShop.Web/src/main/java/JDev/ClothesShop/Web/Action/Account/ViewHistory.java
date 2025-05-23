/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.BLL.PhieuMuaHangBLL;
import JDev.ClothesShop.DAO.PhieuMuaHang;
import JDev.ClothesShop.DAO.TaiKhoan;
import JDev.ClothesShop.Web.Action.Action;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class ViewHistory extends Action {

    public String execute() {
        HttpSession t_httpSession = request.getSession();
        TaiKhoan t_taiKhoan = (TaiKhoan) t_httpSession.getAttribute("login");
        String s_id = request.getParameter("id");
        int id = 0;
        if (s_id != null) {
            id = Integer.parseInt(s_id);
        }

        if (t_taiKhoan == null) {
            return "REDIRECT TO LOGIN";
        } else {
            PhieuMuaHang phieuMuaHang = PhieuMuaHangBLL.get(id);

            request.setAttribute("contentname", "viewhistory");
            request.setAttribute("phieumuahangViewHistory", phieuMuaHang);
            request.setAttribute("idViewHistory", id);
        }

        return "SUCCESS";
    }
}
