package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Pagination {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			Query query = ses.getNamedQuery("GET_ALL_ACTORS");

			// Pagination params gets first 5 records
			query.setFirstResult(0);
			query.setMaxResults(5);

			List<Actor> list = query.getResultList();
			
			if(list.size()!=0)
				list.forEach(System.out::println);
			else
				System.out.println("No Records found");

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
