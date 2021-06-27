package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {

		try {
			// Boot strapping the hibernate
			Configuration cfg = new Configuration();
			// Programatic..
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql:///hibernate");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.format_sql", "true");

			// add mapping file
			cfg.addFile("src/com/nt/entity/Actor.hbm.xml"); // for mapping file (xml)
			// cfg.addAnnotatedClass(Actor.class);
			// create SessionFactory object
			factory = cfg.buildSessionFactory();

		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}// static

	// To create Session obj
	public static Session getSession() {
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();
		return ses;
	}

	// To close Session obj
	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	// To close SessionFactory object
	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}// class