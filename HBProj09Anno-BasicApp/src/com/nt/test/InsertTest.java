package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utils.HibernateUtils;

public class InsertTest {

	public static void main(String[] args) {

		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag = false;

		try {
			tx = ses.beginTransaction();

			InsurancePolicy ip = new InsurancePolicy();
			ip.setPolicyId(101);
			ip.setPolicyName("Health Insurance");
			ip.setDuration(2.5f);
			ip.setCompanyName("SBI");

			System.out.println("Object is saved:: " + ses.save(ip));
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag)
				tx.commit();
			else
				tx.rollback();

			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
