/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.Web.Action.Product;

import JDev.ClothesShop.BLL.SanPhamBLL;
import JDev.ClothesShop.DAO.SanPham;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jeremy
 */
public class View {

    int NumberOfView = 4;

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();

        String s_catalogue = request.getParameter("catalogue");

        int catalogue = Integer.parseInt(s_catalogue);

        String s_page = request.getParameter("pageindex");

        int page = 0;
        if (s_page != null) {
            page = Integer.parseInt(s_page);
        }

        List<SanPham> list = SanPhamBLL.getByCatalogue(catalogue, page * NumberOfView, NumberOfView);
        List<SanPham> temp = SanPhamBLL.getByCatalogue(catalogue, (page + 1) * NumberOfView, NumberOfView);

        String pre = String.format("view.do?catalogue=%d&pageindex=%d", catalogue, page - 1);
        String next = String.format("view.do?catalogue=%d&pageindex=%d", catalogue, page + 1);

        request.setAttribute("contentname", "view");
        request.setAttribute("sanphamsView", list);
        request.setAttribute("tempView", temp);
        request.setAttribute("preView", pre);
        request.setAttribute("nextView", next);
        request.setAttribute("pageView", page);

        return "SUCCESS";
    }
}
