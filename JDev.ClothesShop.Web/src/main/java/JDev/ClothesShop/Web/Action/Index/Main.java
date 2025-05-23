package JDev.ClothesShop.Web.Action.Index;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import JDev.ClothesShop.BLL.DanhMucBLL;
import JDev.ClothesShop.BLL.SanPhamBLL;
import JDev.ClothesShop.DAO.DanhMuc;
import JDev.ClothesShop.DAO.SanPham;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jeremy
 */
public class Main {

    private List<SanPham> sanPhams = null;
    private List<DanhMuc> danhMucs = null;

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public List<DanhMuc> getDanhMucs() {
        return danhMucs;
    }

    public void setDanhMucs(List<DanhMuc> danhMucs) {
        this.danhMucs = danhMucs;
    }

    public String execute() {
        sanPhams = SanPhamBLL.get(0, 3);
        danhMucs = DanhMucBLL.getAll();


        HttpServletRequest myRequest = ServletActionContext.getRequest();
        myRequest.setAttribute("contentname", "main");

        return "SUCCESS";
    }
}
