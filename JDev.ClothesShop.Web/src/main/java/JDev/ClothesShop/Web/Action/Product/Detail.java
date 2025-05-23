/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Product;

import JDev.ClothesShop.BLL.SanPhamBLL;
import JDev.ClothesShop.DAO.SanPham;
import JDev.ClothesShop.Web.Action.Action;

/**
 *
 * @author Jeremy
 */
public class Detail extends Action {

    public String execute() {

        String s_id = request.getParameter("id");
        int id = Integer.parseInt(s_id);

        SanPham sanPham = SanPhamBLL.get(id);

        request.setAttribute("contentname", "product");
        request.setAttribute("sanphamProduct", sanPham);

        return "SUCCESS";
    }
}
