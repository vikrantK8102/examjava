package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
    
    private static SessionFactory factory;

    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            factory = config.buildSessionFactory();
            System.out.println("Hibernate SessionFactory created...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
