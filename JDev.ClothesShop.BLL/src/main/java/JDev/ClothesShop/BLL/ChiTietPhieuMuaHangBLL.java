/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.ChiTietPhieuMuaHang;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class ChiTietPhieuMuaHangBLL {

    @Transactional
    public static void add(ChiTietPhieuMuaHang chiTietPhieuMuaHang) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        String sql = "INSERT INTO `doankhoi_clothesshop`.`chitietphieumuahang` "
                + "(`MaPhieuMuaHang`, `MaSanPham`, `Gia`, `SoLuong`) "
                + "VALUES (:maPhieuMuaHang, :maSanPham, :gia, :soLuong);";
        SQLQuery sQLQuery = session.createSQLQuery(sql);
        sQLQuery.setParameter("maPhieuMuaHang", chiTietPhieuMuaHang.getMaPhieuMuaHang());
        sQLQuery.setParameter("maSanPham", chiTietPhieuMuaHang.getMaSanPham());
        sQLQuery.setParameter("gia", chiTietPhieuMuaHang.getGia());
        sQLQuery.setParameter("soLuong", chiTietPhieuMuaHang.getSoLuong());
        sQLQuery.executeUpdate();
    }
}
