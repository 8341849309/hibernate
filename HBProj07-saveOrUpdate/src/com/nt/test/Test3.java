package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Test3 {

	//generator and un-saved is cfg
	//insert as new record otherwise update if found else exception
	//not given id itself direct insert
	public static void main(String[] args) {

		
		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction();

			Actor actor = new Actor();
			//actor.setActorid(2); //matches with unsaved value 
			actor.setActorname("Venkateswarlu");
			actor.setActoraddrs("Kerala");
			
			ses.saveOrUpdate(actor);
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
