/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Account;

import JDev.ClothesShop.Web.Action.Action;

/**
 *
 * @author Jeremy
 */
public class SignUp extends Action {

    public String execute() {
         request.setAttribute("contentname","signup");
        
        return "SUCCESS";
    }
}
