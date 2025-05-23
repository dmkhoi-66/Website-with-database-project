/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.SanPham;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
public class SanPhamBLL {
    @Transactional(readOnly = true)
    public static List<SanPham> get(int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();
        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham");
        sQLQuery.addEntity(SanPham.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);
        List<SanPham> list = sQLQuery.list();
        return list;
    }
    @Transactional(readOnly = true)
    public static SanPham get(int id) {
        Session session = new HibernateSupport().getSessionFactory().openSession();
        SanPham sanPham = (SanPham) session.get(SanPham.class, id);
        return sanPham;
    }
    @Transactional(readOnly = true)
    public static List<SanPham> getByCatalogue(int catalogue, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();
        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham where MaDanhMuc = :catalogue or :catalogue = -1");
        sQLQuery.setParameter("catalogue", catalogue);
        sQLQuery.addEntity(SanPham.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);
        List<SanPham> list = sQLQuery.list();
        return list;
    }

    @Transactional(readOnly = true)
    public static List<SanPham> getByColor(int color, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham where MaMauSac = :color");
        sQLQuery.setParameter("color", color);
        sQLQuery.addEntity(SanPham.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);

        List<SanPham> list = sQLQuery.list();

        return list;
    }

    @Transactional(readOnly = true)
    public static List<SanPham> getBySize(int sizeStart, int sizeEnd, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham where MaKichThuoc >= :sizeStart and MaKichThuoc <= :sizeEnd");
        sQLQuery.setParameter("sizeStart", sizeStart);
        sQLQuery.setParameter("sizeEnd", sizeEnd);
        sQLQuery.addEntity(SanPham.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);

        List<SanPham> list = sQLQuery.list();

        return list;
    }

    @Transactional(readOnly = true)
    public static List<SanPham> getByPrice(double priceStart, double priceEnd, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham where Gia >= :priceStart and Gia <= :priceEnd");
        sQLQuery.setParameter("priceStart", priceStart);
        sQLQuery.setParameter("priceEnd", priceEnd);

        sQLQuery.addEntity(SanPham.class);
        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);

        List<SanPham> list = sQLQuery.list();

        return list;
    }

    @Transactional(readOnly = true)
    public static List<SanPham> get(int catalogue, int colorid, int sizeid, double priceStart, double priceEnd, int start, int limit) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        SQLQuery sQLQuery = session.createSQLQuery("select * from SanPham where "
                + "(Gia >= :priceStart and Gia <= :priceEnd)"
                + " and (MaDanhMuc = :catalogue or :catalogue = -1)"
                + " and (MaMauSac = :colorid or :colorid = -1)"
                + " and (MaKichThuoc = :sizeid or :sizeid = -1)");
        sQLQuery.setParameter("priceStart", priceStart);
        sQLQuery.setParameter("priceEnd", priceEnd);
        sQLQuery.setParameter("catalogue", catalogue);
        sQLQuery.setParameter("colorid", colorid);
        sQLQuery.setParameter("sizeid", sizeid);

        sQLQuery.addEntity(SanPham.class);

        sQLQuery.setFirstResult(start);
        sQLQuery.setMaxResults(limit);

        List<SanPham> list = sQLQuery.list();

        return list;
    }
}
