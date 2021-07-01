package com.nt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory = null;

	static {
		
		try {
			// Boot strapping of Hibernate
			Configuration cfg = new Configuration();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			StandardServiceRegistry registry = builder.configure("/com/nt/cfgs/hibernate.cfg.xml").build();
			factory = cfg.buildSessionFactory(registry);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static Session getSession() {
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();
		return ses;
	}

	// close session
	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	// close SessionFactory
	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
