package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class NativeSQLTest2 {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			NativeQuery query = ses.createNativeQuery("SELECT * FROM ACTOR WHERE REMUNERATION>:start", Actor.class);
			query.setParameter("start", 100000000F);

			List<Actor> list = query.getResultList();

			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
