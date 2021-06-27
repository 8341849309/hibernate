package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class NativeSQLTest {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			NativeQuery query = ses.getNamedNativeQuery("GET_ALL_ACTORS");
			query.addEntity(Actor.class);
			
			List<Actor> list = query.getResultList();

			list.forEach(System.out::println);
			
			System.out.println("=====================================");
			
			NativeQuery query1 = ses.getNamedNativeQuery("GET_ACTORS_GREATER_THAN_LIMIT");
			query1.addEntity(Actor.class);
			query1.setParameter("start", 100000000F);

			List<Actor> list1 = query1.getResultList();

			list1.forEach(System.out::println);


		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
