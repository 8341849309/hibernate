package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class CriteriaAPISelect {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			CriteriaBuilder builder = ses.getCriteriaBuilder();

			CriteriaQuery<Actor> ctQuery = builder.createQuery(Actor.class);

			Root<Actor> root = ctQuery.from(Actor.class);

			ctQuery.select(root);

			Query query = ses.createQuery(ctQuery);

			List<Actor> list = query.getResultList();
			
			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
