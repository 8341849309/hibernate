package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory = null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();

	static {
		try {
			Configuration cfg = new Configuration();

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

			StandardServiceRegistry registry = builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();

			factory = cfg.buildSessionFactory(registry);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		
		return factory;
	}
	
	public static Session getSession() {
		
		Session ses=threadLocal.get();
		
		if(ses==null) {
			if(factory!=null) {
				ses=factory.openSession();
				threadLocal.set(ses);
			}
		}
			
		return ses;
	}

	public static void closeSession() {
		
		Session ses=threadLocal.get();
		
		if(ses!=null) {
			ses.close();
			threadLocal.remove();
		}
				
	}
	
	public static void closeSessionFactory() {
		
		if(factory!=null)
			factory.close();
		
	}
	
}
