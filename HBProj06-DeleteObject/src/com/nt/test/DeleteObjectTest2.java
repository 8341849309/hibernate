package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class DeleteObjectTest2 {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		try {
			// load obj and delete
			tx = ses.beginTransaction();

			Actor actor = ses.get(Actor.class, 106);

			if (actor != null) {
				ses.delete(actor);
				System.out.println("Actor deleted ");
			}
			flag = true;

		} catch (HibernateException he) {
			System.out.println("Actor not found");
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
