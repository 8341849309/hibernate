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

			Bank bank = new Bank();
			bank.setHolderName("Rama");
			bank.setBalance(100000000F);
			bank.setStatus("ACTIVE");

			Long acno=(Long) ses.save(bank);
			
			if(acno!=null) {
				System.out.println("Account created!!!"+acno);
				tx.commit();
			}
			

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
