/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Cart;

import JDev.ClothesShop.Web.Action.Action;
import JDev.ClothesShop.Web.DAO.Cart;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class UpdateCart extends Action {

    public String execute() {
        HttpSession httpSession = request.getSession();
        Cart cart = (Cart) httpSession.getAttribute("CART");
        if (cart
                == null) {
            cart = new Cart();
            httpSession.setAttribute("CART", cart);
        }
        String s_productid = request.getParameter("productid");
        String s_stock = request.getParameter("stock");
        int stock = Integer.parseInt(s_stock);
        int productid = Integer.parseInt(s_productid);

        cart.UpdateStock(productid, stock);

        return "SUCCESS";
    }
}
