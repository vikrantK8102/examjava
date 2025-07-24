package com.app.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	private static SessionFactory factory;
	static {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		System.out.println("hibernate sessionfac creayed..");
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
		
	}
}
