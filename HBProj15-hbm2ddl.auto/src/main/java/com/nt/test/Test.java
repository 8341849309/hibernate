package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {

		Transaction tx = null;

		try (SessionFactory factory = HibernateUtils.getSessionFactory()) {

			try (Session ses = HibernateUtils.getSession()) {

				tx = ses.beginTransaction();

				Employee emp = new Employee();
				emp.setName("Venkateswarlu");
				emp.setSalary(30000F);

				ses.save(emp);
				tx.commit();
				System.out.println("Object is saved");
				Thread.sleep(30000);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}

	}

}
