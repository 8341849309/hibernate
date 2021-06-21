package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Solution {

	public static void main(String[] args) {

		
		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		//gets from DB kepts in cache
		Actor actor1=ses.get(Actor.class, 101);
		System.out.println(actor1);
		
		try {
			tx = ses.beginTransaction();

			//Try to keep in cache found with some other id merge both
			Actor actor = new Actor();
			actor.setActorid(101);
			actor.setActorname("Venkateswarlu");
			actor.setActoraddrs("Kerala");
			
			ses.merge(actor);
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
