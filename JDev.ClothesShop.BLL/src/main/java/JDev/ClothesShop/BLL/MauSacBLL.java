/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.MauSac;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class MauSacBLL {

    @Transactional(readOnly = true)
    public static List<MauSac> getAll() {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from MauSac");
        sQLQuery.addEntity(MauSac.class);

        List<MauSac> list = sQLQuery.list();

        return list;
    }
}
