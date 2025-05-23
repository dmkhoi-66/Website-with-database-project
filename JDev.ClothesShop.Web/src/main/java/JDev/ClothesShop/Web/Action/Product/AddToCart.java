/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Product;

import JDev.ClothesShop.BLL.SanPhamBLL;
import JDev.ClothesShop.DAO.SanPham;
import JDev.ClothesShop.Web.Action.Action;
import JDev.ClothesShop.Web.DAO.Cart;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeremy
 */
public class AddToCart extends Action {

    private String productid;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String execute() {

        HttpSession httpSession = request.getSession();
        Cart cart = (Cart) httpSession.getAttribute("CART");
        if (cart == null) {
            cart = new Cart();
            httpSession.setAttribute("CART", cart);
        }

        String s_productid = request.getParameter("productid");
        String s_stock = request.getParameter("stock");

        int productid = Integer.parseInt(s_productid);
        int stock = Integer.parseInt(s_stock);

        SanPham sanPham = SanPhamBLL.get(productid);

        if (sanPham == null) {
            return "PRODUCT NOT FOUND";
        } else {
            cart.Add(sanPham, stock);
            //response.sendRedirect("product?id=" + sanPham.getMaSanPham() + "&addtocart=oke");
        }
        
        setProductid(s_productid);

        return "SUCCESS";
    }
}
