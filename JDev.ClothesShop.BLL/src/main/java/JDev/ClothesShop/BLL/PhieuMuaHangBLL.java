/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.ChiTietPhieuMuaHang;
import JDev.ClothesShop.DAO.PhieuMuaHang;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class PhieuMuaHangBLL {

    @Transactional(readOnly = true)
    public static List<PhieuMuaHang> get(String userName, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from PhieuMuaHang where KhachHang = :userName");
        sQLQuery.setParameter("userName", userName);
        sQLQuery.addEntity(PhieuMuaHang.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);

        List<PhieuMuaHang> list = sQLQuery.list();

        return list;
    }

    @Transactional(readOnly = true)
    public static PhieuMuaHang get(int id) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        PhieuMuaHang phieuMuaHang = (PhieuMuaHang) session.get(PhieuMuaHang.class, id);

        return phieuMuaHang;
    }

    @Transactional
    public static void add(PhieuMuaHang phieuMuaHang) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        session.save(phieuMuaHang);

        List<ChiTietPhieuMuaHang> list = phieuMuaHang.getDanhSachHang();
        Iterator it = list.iterator();

        for (int i = 0; it.hasNext(); i++) {
            ChiTietPhieuMuaHang chiTietPhieuMuaHang = (ChiTietPhieuMuaHang) it.next();

            chiTietPhieuMuaHang.setMaPhieuMuaHang(phieuMuaHang.getMaPhieuMuaHang());

            session.saveOrUpdate(chiTietPhieuMuaHang);
        }
        
        session.flush();
        session.close();
    }
}
