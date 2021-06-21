package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;

public class SaveObjectTest {

	public static void main(String[] args) {
		// Loads and activates HB
		Configuration cfg = new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");

		// Creates pre-SQL,cache,Con Pool etc
		SessionFactory factory = cfg.buildSessionFactory();

		// Create Session
		Session ses = factory.openSession();

		Actor actor = new Actor();
		actor.setActorid(101);
		actor.setActorname("Allu Arjun");
		actor.setActoraddrs("Hyderabad");
		actor.setPhone(99999999L);
		actor.setRemuneration(150000000F);

		// Open tx
		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction();
			// save obj
			ses.save(actor);
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
				System.out.println("Object is saved...");
			} else {
				tx.rollback();
				System.out.println("Object is not saved...");
			}
			
			// close objs
			ses.close();
			factory.close();

		}

	}

}
