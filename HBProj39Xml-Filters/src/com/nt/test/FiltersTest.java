package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Bank;
import com.nt.utils.HibernateUtils;

public class FiltersTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory(); 
				Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();

			Filter filter1 = ses.enableFilter("IGNORE_ACCOUNTS_FILTER");
			filter1.setParameter("accountType1", "BLOCKED");
			filter1.setParameter("accountType2", "SUSPENDED");
			filter1.setParameter("accountType3", "CLOSED");

			Query query = ses.createQuery("FROM Bank");

			List<Bank> list = query.getResultList();

			list.forEach(System.out::println);
			
			
			//update Govt fund to active accounts
			Query query1=ses.createQuery("UPDATE Bank SET balance=balance+:govtFund");
			query1.setParameter("govtFund", 111111F);
			
			int count=query1.executeUpdate();
			
			System.out.println("No of Records Updated!!! "+count);
			
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
