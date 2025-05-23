/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDev.ClothesShop.BLL;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jeremy
 */
public abstract class HibernateSupportFactory {

    public static SessionFactory sessionFactory;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-hibernate.xml");
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }
}
