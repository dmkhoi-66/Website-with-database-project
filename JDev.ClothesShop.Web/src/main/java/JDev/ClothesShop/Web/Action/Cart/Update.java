/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Cart;

import JDev.ClothesShop.Web.Action.Action;

/**
 *
 * @author Jeremy
 */
public class Update extends Action {

    public String execute() {
        String s_index = request.getParameter("index");

        int index = Integer.parseInt(s_index);

        request.setAttribute("contentname", "cartupdate");
        request.setAttribute("index", index);

        return "SUCCESS";
    }
}
