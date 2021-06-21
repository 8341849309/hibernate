package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class RefreshTest {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		try {
			// need not to call update(-) seperately if any update is happened
			// during tx automatically updates data
			tx = ses.beginTransaction();

			Actor actor = ses.get(Actor.class, 102);
			System.out.println(actor);
			
			Thread.sleep(30000);
			
			ses.refresh(actor);
			
			System.out.println(actor);
			
			flag = true;

		} catch (HibernateException he) {
			System.out.println("Actor not found");
		} catch (InterruptedException e) {
			e.printStackTrace();
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
