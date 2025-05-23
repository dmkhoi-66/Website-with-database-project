/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Product;

import JDev.ClothesShop.BLL.SanPhamBLL;
import JDev.ClothesShop.DAO.SanPham;
import JDev.ClothesShop.Web.Action.Action;
import java.util.List;

/**
 *
 * @author Jeremy
 */
public class SearchResult extends Action {

    int NumberOfView = 4;

    public String execute() {

        String s_catalogue = request.getParameter("catalogue");
        String s_color = request.getParameter("color");
        String s_size = request.getParameter("size");
        String s_min = request.getParameter("min");
        String s_max = request.getParameter("max");
        String s_page = request.getParameter("index");

        int catalogue = Integer.parseInt(s_catalogue);
        int color = Integer.parseInt(s_color);
        int size = Integer.parseInt(s_size);
        double min = Double.parseDouble(s_min);
        double max = Double.parseDouble(s_max);
        int page = 0;
        if (s_page != null) {
            page = Integer.parseInt(s_page);
        }

        List<SanPham> list = SanPhamBLL.get(catalogue, color, size, min, max, page * NumberOfView, NumberOfView);
        List<SanPham> temp = SanPhamBLL.get(catalogue, color, size, min, max, (page + 1) * NumberOfView, NumberOfView);
        String pre = String.format("searchresult?catalogue=%d&color=%d&size=%d&min=%f&max=%f&index=%d", catalogue, color, size, min, max, page - 1);
        String next = String.format("searchresult?catalogue=%d&color=%d&size=%d&min=%f&max=%f&index=%d", catalogue, color, size, min, max, page + 1);

        request.setAttribute("contentname", "searchresult");
        request.setAttribute("sanphamsResult", list);
        request.setAttribute("tempResult", temp);
        request.setAttribute("preResult", pre);
        request.setAttribute("nextResult", next);
        request.setAttribute("idResult", page);

        return "SUCCESS";
    }
}
