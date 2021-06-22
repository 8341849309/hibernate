package com.nt.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleHibernateUtils {

	private static SessionFactory factory;

	static {
		System.out.println("OracleHibernateUtils.enclosing_method()");
		try {
			Configuration cfg = new Configuration();
			cfg.configure("com/nt/cfgs/hibernate-oracle.cfg.xml");

			factory = cfg.buildSessionFactory();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		System.out.println("OracleHibernateUtils.getSessionFactory()");

		return factory;
	}

	public static Session getSession() {
		System.out.println("OracleHibernateUtils.getSession()");
		
		Session ses = null;

		if (factory != null)
			ses = factory.openSession();

		return ses;
	}

	public static void closeSession(Session ses) {
		System.out.println("OracleHibernateUtils.closeSession()");
		
		if (ses != null)
			ses.close();
	}

	public static void closeSessionFactory() {
		System.out.println("OracleHibernateUtils.closeSessionFactory()");
		
		if (factory != null)
			factory.close();
	}

}
