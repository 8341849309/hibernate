package com.nt.get.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class GetColumns {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			Query query1 = ses.createQuery("SELECT COUNT(*) FROM com.nt.entity.Actor");
			
			List<Long> count=query1.getResultList();
			
			System.out.println("Total Actors:: "+count.get(0));
			
			Query query2 = ses.createQuery("SELECT COUNT(*),MAX(remuneration),MIN(remuneration),AVG(remuneration),SUM(remuneration) FROM com.nt.entity.Actor");
			
			List<Object[]> lists=query2.getResultList();
			
			Object row[]=lists.get(0);
			
			System.out.println("Count:: "+row[0]+" Max:: "+row[1]+" Min:: "+row[2]+" Avg:: "+row[3]+" Sum:: "+row[4]);
			
			// Prepare HQL query
			Query query = ses.createQuery("SELECT actor.actorid,actor.actorname FROM com.nt.entity.Actor as actor WHERE actor.id<:start");
			query.setParameter("start", 105);
			
			List<Object[]> list= query.getResultList();

			list.forEach(
					a->{
						System.out.println("employee id "+a[0]+" employee name "+a[1]);
					}
					
					);
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
