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
			//Collects from DB
			Actor actor = ses.get(Actor.class, 101);
			//Collects from L1 Cache
			Actor actor1 = ses.get(Actor.class, 101);

			Actor actor2 = ses.get(Actor.class, 102);
	
			
			if (actor == null || actor1==null)
				System.out.println("Actor not found");
			else
				System.out.println(actor+"\n"+actor1+"\n"+actor2);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

		finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
