package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class LoadObjectTest {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		try {
			//Returns Proxy obj so we can not check value
			Actor actor = ses.load(Actor.class, 101);
			System.out.println(actor);

		} catch (HibernateException he) {
			System.out.println("Actor not found");
		}

		finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
