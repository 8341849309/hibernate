package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		// Create Session
		Session ses = HibernateUtils.getSession();

		Actor actor = new Actor();
		actor.setActorname("Hrithik");
		actor.setActoraddrs("Mumbai");

		Integer id=0;
		
		// Open tx
		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction();
			// save obj
			id=(Integer) ses.save(actor);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// commit or rollback
			if (flag) {
				tx.commit();
				System.out.println("Object is saved..."+id);
			} else {
				tx.rollback();
				System.out.println("Object is not saved..."+id);
			}

			// close objs
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();

		}

	}

}
