package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class RemoveCache {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		try {
			//Collects from DB
			Actor actor = ses.get(Actor.class, 101);
			//Remove from Cache
			//ses.evict(actor); and ses.close(); also clears cache indirectly
			ses.clear();
			
			Actor actor1 = ses.get(Actor.class, 101);

			
			
			if (actor == null || actor1==null)
				System.out.println("Actor not found");
			else
				System.out.println(actor+"\n"+actor1);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

		finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
