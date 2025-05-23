/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.KichThuoc;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class KichThuocBLL {

    @Transactional(readOnly = true)
    public static List<KichThuoc> getAll() {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from KichThuoc");
        sQLQuery.addEntity(KichThuoc.class);

        List<KichThuoc> list = sQLQuery.list();

        return list;
    }
}
