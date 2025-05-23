/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.Web.Action.Action;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class Logout extends Action {

    public String execute() {
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        
        return "SUCCESS";
    }
}
