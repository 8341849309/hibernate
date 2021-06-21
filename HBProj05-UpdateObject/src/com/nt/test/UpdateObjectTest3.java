package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class UpdateObjectTest3 {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag=false;

		try {
			//need not to call update(-) seperately if any update is happened 
			//during tx automatically updates data
			tx = ses.beginTransaction();
			
			Actor actor=ses.get(Actor.class, 102);
			
			actor.setPhone(99L);
			
			flag=true;

		} catch (HibernateException he) {
			System.out.println("Actor not found");
		}

		finally {
			
			if(flag)
				tx.commit();
			else
				tx.rollback();
			
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
