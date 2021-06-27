package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Update {

	public static void main(String[] args) {

		Transaction tx=null;
		// Create Session
		Session ses = HibernateUtils.getSession();

		//it will commit all changes one time only
		try {
			tx=ses.beginTransaction();
			Actor actor = ses.get(Actor.class, 101);
			
			if (actor == null)
				System.out.println("Actor not found");
			else {
				actor.setPhone(8341849309L);
				ses.update(actor);
				System.out.println(actor);
				actor.setRemuneration(10000000F);
				tx.commit();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}

		finally {
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
