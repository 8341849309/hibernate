package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class GetObjectTest {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		try {
			Actor actor = ses.get(Actor.class, 100);

			if (actor == null)
				System.out.println("Actor not found");
			else
				System.out.println(actor);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

		finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
