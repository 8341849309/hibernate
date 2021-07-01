package com.nt.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Traveller;
import com.nt.utils.HibernateUtils;

public class TravellerDAOImpl implements ITravellerDAO {

	@Override
	public void save() {
		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			System.out.println(ses.hashCode());

			tx = ses.beginTransaction();

			LocalDate dob = LocalDate.of(1998, 05, 16);
			Set<Long> phones = Set.of(8341849309L, 9618265905L, 9346168470L);
			Map<String, String> placesVisited = Map.of("Benguluru Tour", "Chikmanglore", "Marraiage Tour", "Kochi",
					"Love Tour", "Palakkad");

			Traveller tr = new Traveller("Rama", dob, phones, placesVisited);

			ses.save(tr);
			tx.commit();
			System.out.println("TRaveller is saved!!!");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Problem in saving...");
		}

	}

	@Override
	public void load() {

		try (Session ses = HibernateUtils.getSession()) {

			Transaction tx = ses.beginTransaction();

			System.out.println(ses.hashCode());

			Query query = ses.createQuery("from Traveller");
			List<Traveller> list = query.getResultList();

			list.forEach(tr -> {
				
				System.out.println("Traveller Id:: "+tr.getTravellerId()+" Traveller Name:: "+tr.getTavellerName()+" DOB:: "+tr.getDob());
				
				Set<Long> phones=tr.getPhones();
				phones.forEach(System.out::println);

				Map<String, String> map=tr.getPlacesVisited();
				
				map.forEach(
						
						(k,v)->{
							System.out.println("Tour Name:: "+k+" Tour Place:: "+v);
						}
						
						);
				
			});

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in loading...");
		}

	}

}
