package JDev.ClothesShop.Web.Action;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jeremy
 */
public class Action {

    protected HttpServletRequest request = null;

    public Action() {
        request = ServletActionContext.getRequest();
    }
}
