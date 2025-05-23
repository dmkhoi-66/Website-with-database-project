/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.BLL.TaiKhoanBLL;
import JDev.ClothesShop.DAO.TaiKhoan;
import JDev.ClothesShop.Web.Action.Action;

/**
 *
 * @author Jeremy
 */
public class Save extends Action {

    public String execute() {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");

        if (userName.equals("") || password.equals("")) {
            return "USERNAME OR PASSWORD EMPTY";
        }

        if (TaiKhoanBLL.exists(userName)) {
            return "USERNAME EXIST";
        } else {
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setMatKhau(password);
            taiKhoan.setTenDangNhap(userName);

            TaiKhoanBLL.add(taiKhoan);
        }
        return "SUCCESS";
    }
}
