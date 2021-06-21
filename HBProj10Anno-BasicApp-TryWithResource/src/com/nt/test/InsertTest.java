package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utils.HibernateUtils;

public class InsertTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory()) {

			try (Session ses = HibernateUtils.getSession()) {
				tx = ses.beginTransaction();

				InsurancePolicy ip = new InsurancePolicy();
				ip.setPolicyId(102);
				ip.setPolicyName("Health Insurance");
				ip.setDuration(2.5f);
				ip.setCompanyName("SBI");

				System.out.println("Object is saved:: " + ses.save(ip));
				tx.commit();

			}
		}

		catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
