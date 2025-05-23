/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import JDev.ClothesShop.DAO.TaiKhoan;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeremy
 */
public class TaiKhoanBLL {

    @Transactional(readOnly = true)
    public static boolean logIn(TaiKhoan taiKhoan) {

        Session session = new HibernateSupport().getSessionFactory().openSession();

        TaiKhoan temp = (TaiKhoan) session.get(TaiKhoan.class, taiKhoan.getTenDangNhap());

        session.close();

        boolean result = false;

        result = temp == null ? false : true;

        if (result) {
            result = temp.getMatKhau().equals(taiKhoan.getMatKhau());
        }

        return result;
    }

    @Transactional
    public static void add(TaiKhoan taiKhoan) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        session.save(taiKhoan);
        session.flush();
        session.close();
    }

    @Transactional(readOnly = true)
    public static boolean exists(String userName) {
        Session session = new HibernateSupport().getSessionFactory().openSession();

        TaiKhoan taiKhoan = (TaiKhoan) session.get(TaiKhoan.class, userName);

        if (taiKhoan == null) {
            return false;
        }

        return true;
    }
}
