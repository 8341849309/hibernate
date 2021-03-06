package com.nt.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.HikariCPConnectionProviderService;

public class HibernateUtils {

	private static SessionFactory factory;

	static {
		
		try {
			Configuration cfg = new Configuration();
			
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder.addService(ConnectionProvider.class, new HikariCPConnectionProviderService());
			
			StandardServiceRegistry registry=builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();

			factory = cfg.buildSessionFactory(registry);

		} catch (HibernateException e) {
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

	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
