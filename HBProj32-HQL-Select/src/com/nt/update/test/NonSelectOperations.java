package com.nt.update.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utils.HibernateUtils;

public class NonSelectOperations {

	public static void main(String[] args) {

		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			tx=ses.beginTransaction();
			
			Query query=ses.createQuery("UPDATE Actor SET remuneration=remuneration+111111 WHERE remuneration>10000");
			
			int count=query.executeUpdate();
			System.out.println("No of records effected:: "+count);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
