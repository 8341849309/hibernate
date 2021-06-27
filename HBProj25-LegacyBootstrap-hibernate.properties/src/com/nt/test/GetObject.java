package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;

public class GetObject {

	public static void main(String[] args) {
		// Loads and activates HB
		Configuration cfg = new Configuration();
		cfg.addFile("src/com/nt/entity/Actor.hbm.xml");

		// Creates pre-SQL,cache,Con Pool etc
		SessionFactory factory = cfg.buildSessionFactory();

		try {
			Session ses = factory.openSession();

			Actor a = ses.get(Actor.class, 105);
			System.out.println(a);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
