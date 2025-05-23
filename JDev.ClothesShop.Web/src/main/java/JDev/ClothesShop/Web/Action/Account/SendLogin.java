/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.BLL.TaiKhoanBLL;
import JDev.ClothesShop.DAO.TaiKhoan;
import JDev.ClothesShop.Web.Action.Action;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class SendLogin extends Action {

    public String execute() {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");

        if (userName.equals("") || password.equals("")) {
            return "USER OR PASSWORD EMPTY";
        }

        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setMatKhau(password);
        taiKhoan.setTenDangNhap(userName);

        boolean bool = TaiKhoanBLL.logIn(taiKhoan);

        if (bool) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("login", taiKhoan);
        } else {
        }

        return "SUCCESS";
    }
}
