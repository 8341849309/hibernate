package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Problem {

	public static void main(String[] args) {

		
		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		Actor actor1=ses.get(Actor.class, 101);
		System.out.println(actor1);
		
		try {
			tx = ses.beginTransaction();

			Actor actor = new Actor();
			actor.setActorid(101);
			actor.setActorname("Venkateswarlu");
			actor.setActoraddrs("Kerala");
			
			ses.update(actor);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		}

		finally {

			if (flag)
				tx.commit();
			else
				tx.rollback();

			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
