package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Bank;
import com.nt.utils.HibernateUtils;

public class InsertTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory(); 
				Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();

			Bank bank=ses.get(Bank.class, 5L);
			
			if(bank!=null) {
				ses.delete(bank);
				tx.commit();
				System.out.println("Account is Closed..");
			}else
				System.out.println("Account not found..");

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
