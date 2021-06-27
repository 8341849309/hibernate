package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class DeleteObjectTest1 {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction();

			Query query = ses.getNamedQuery("GET_ALL_ACTORS");

			List<Actor> list = query.getResultList();

			list.forEach(System.out::println);
			
			System.out.println("======================================");
			
			Query query1=ses.getNamedQuery("INCREASE_REMUNERATION");
			query1.setParameter("bonus", 1001F);
			
			int count=query1.executeUpdate();
			
			System.out.println("No of records updated:: "+count);
			flag=true;
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
