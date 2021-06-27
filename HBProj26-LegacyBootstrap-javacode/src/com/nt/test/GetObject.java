package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.util.HibernateUtils;

public class GetObject {

	public static void main(String[] args) {

		try {
			Session ses = HibernateUtils.getSession();

			Actor a = ses.get(Actor.class, 105);
			System.out.println(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
