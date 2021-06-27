package com.nt.idelete.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Hql_Insert_Test;
import com.nt.utils.HibernateUtils;

public class DeleteOperation {

	public static void main(String[] args) {

		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();
			
			Query query = ses.createQuery(
					"DELETE Hql_Insert_Test WHERE id=1");
			int count = query.executeUpdate();
			System.out.println("No of records transferred:: " + count);
	
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
