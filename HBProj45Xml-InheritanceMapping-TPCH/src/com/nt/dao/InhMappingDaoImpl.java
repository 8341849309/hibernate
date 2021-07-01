package com.nt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtils;

public class InhMappingDaoImpl implements IInhMappingDao {

	Transaction tx = null;

	@Override
	public void save() {

		try (Session ses = HibernateUtils.getSession()) {
			tx = ses.beginTransaction();

			Person per = new Person("Venkateswarlu", "MPL");
			Employee emp = new Employee("PA", "CTS", 30000F);
			emp.setPname("Neeraja");
			emp.setAddrs("Palakkad");

			Customer cust = new Customer(1000F, 100F);
			cust.setPname("Venkateswarlu");
			cust.setAddrs("Kerala");

			ses.save(per);
			ses.save(emp);
			ses.save(cust);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void load() {

		try (Session ses = HibernateUtils.getSession()) {

			Query query1 = ses.createQuery("from Person");
			List<Person> list1 = query1.getResultList();

			list1.forEach(System.out::println);

			System.out.println("============================");
			
			Query query2 = ses.createQuery("from Customer");
			List<Person> list2 = query2.getResultList();

			list2.forEach(System.out::println);

			System.out.println("============================");

			Query query3 = ses.createQuery("from Employee");
			List<Person> list3 = query3.getResultList();

			list3.forEach(System.out::println);

			System.out.println("============================");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
