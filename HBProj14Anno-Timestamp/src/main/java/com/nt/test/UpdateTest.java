package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utils.HibernateUtils;

public class UpdateTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory()) {

			try (Session ses = HibernateUtils.getSession()) {
				tx = ses.beginTransaction();

				CallerTune tune=ses.get(CallerTune.class, 1);
				tune.setCallerTune("Love Song");
				
				System.out.println("Object is update::");
				tx.commit();

			}
		}

		catch (HibernateException he) {
			he.getMessage();
			tx.rollback();
		} catch (Exception e) {
			e.getMessage();
			tx.rollback();
		}

	}

}
