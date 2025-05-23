/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.DanhMuc;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class DanhMucBLL {

    @Transactional(readOnly = true)
    public static List<DanhMuc> getAll() {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from DanhMuc");
        sQLQuery.addEntity(DanhMuc.class);

        List<DanhMuc> list = sQLQuery.list();
        
        return list;
    }
}
