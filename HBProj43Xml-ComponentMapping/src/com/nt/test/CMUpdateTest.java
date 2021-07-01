package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Person;
import com.nt.utils.HibernateUtils;

public class CMUpdateTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory(); Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();

			Person per = ses.get(Person.class, 1);

			if (per != null) {
				per.setPname("V Venkateswarlu");
				per.getDetails().setSalary(36000F);
				tx.commit();
			}

			System.out.println(per);

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
