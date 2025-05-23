/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Product;

import JDev.ClothesShop.BLL.DanhMucBLL;
import JDev.ClothesShop.BLL.KichThuocBLL;
import JDev.ClothesShop.BLL.MauSacBLL;
import JDev.ClothesShop.DAO.DanhMuc;
import JDev.ClothesShop.DAO.KichThuoc;
import JDev.ClothesShop.DAO.MauSac;
import JDev.ClothesShop.Web.Action.Action;
import java.util.List;

/**
 *
 * @author Jeremy
 */
public class Search extends Action {

    public String execute() {

        List<DanhMuc> danhMucs = DanhMucBLL.getAll();
        List<MauSac> mauSacs = MauSacBLL.getAll();
        List<KichThuoc> kichThuocs = KichThuocBLL.getAll();

        request.setAttribute("contentname", "search");
        request.setAttribute("danhMucs", danhMucs);
        request.setAttribute("mauSacs", mauSacs);
        request.setAttribute("kichThuocs", kichThuocs);

        return "SUCCESS";
    }
}
