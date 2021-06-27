package com.nt.insert.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Hql_Insert_Test;
import com.nt.utils.HibernateUtils;

public class InsertOperations {

	public static void main(String[] args) {

		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();
			
			Query query = ses.createQuery(
					"INSERT INTO Hql_Insert_Test(id,name,addrs,phone,salary) SELECT a.actorid,a.actorname,a.actoraddrs,a.phone,a.remuneration FROM Actor as a");

			int count = query.executeUpdate();
			System.out.println("No of records transferred:: " + count);
	
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
