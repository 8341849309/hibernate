package com.nt.get.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class Lazy {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			Query query=ses.createQuery("FROM Actor WHERE actorname like 'Allu%'");
			Iterator<Actor> itr=query.iterate();
			
			itr.forEachRemaining(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
