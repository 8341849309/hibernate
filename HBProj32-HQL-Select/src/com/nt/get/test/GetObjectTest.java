package com.nt.get.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class GetObjectTest {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			// Prepare HQL query
			//Query query = ses.createQuery("FROM com.nt.entity.Actor");
			//Query query = ses.createQuery("SELECT actor FROM com.nt.entity.Actor as actor");
			//Query query = ses.createQuery("FROM com.nt.entity.Actor as actor WHERE actor.id<?1");
			//query.setParameter(1, 105);
			Query query = ses.createQuery("FROM com.nt.entity.Actor as actor WHERE actor.id<:start");
			query.setParameter("start", 105);
			
			List<Actor> list = query.getResultList();

			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
