/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import org.hibernate.SessionFactory;

/**
 *
 * @author Jeremy
 */
public class HibernateSupport {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateSupport() {
        sessionFactory = HibernateSupportFactory.sessionFactory;
    }
}
