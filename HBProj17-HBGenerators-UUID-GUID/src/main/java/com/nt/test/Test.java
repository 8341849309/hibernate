package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {

		Transaction tx=null;
		
		try (Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();

			Employee emp = new Employee();
			// emp.setEmpid(1);
			emp.setName("Venkateswarlu");
			emp.setSalary(30000F);

			ses.save(emp);
			tx.commit();
			System.out.println("Object is saved");

		} catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("Object is not saved");
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object is not saved");
			tx.rollback();
		}


	}

}
