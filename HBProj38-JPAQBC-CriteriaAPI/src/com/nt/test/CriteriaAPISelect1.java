package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class CriteriaAPISelect1 {

	/*
	 * Getting the records by applying condition and order by clauses
	 */
	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			CriteriaBuilder builder = ses.getCriteriaBuilder();

			CriteriaQuery<Actor> ctQuery = builder.createQuery(Actor.class);

			Root<Actor> root = ctQuery.from(Actor.class);

			ctQuery.select(root);

			//prepare named parameters
			ParameterExpression<Integer> param1=builder.parameter(Integer.class, "start");
			ParameterExpression<Integer> param2=builder.parameter(Integer.class, "end");
			
			//prepare conditions having the named parameters
			Predicate pdc1=builder.ge(root.get("actorid"), param1);
			Predicate pdc2=builder.ge(root.get("actorid"), param2);
			Predicate pdc3=builder.and(pdc1, pdc2);
			
			ctQuery.where(pdc3);
			
			//Order by
			Order order=builder.desc(root.get("actorname"));
			ctQuery.orderBy(order);
			
			Query query = ses.createQuery(ctQuery);
			query.setParameter("start", 100);
			query.setParameter("end", 120);

			List<Actor> list = query.getResultList();
			System.out.println(list.size());
			list.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
