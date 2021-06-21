package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.InsurancePolicy;
import com.nt.utils.HibernateUtils;

public class ReadTest {

	public static void main(String[] args) {

		try(SessionFactory factory=HibernateUtils.getSessionFactory()){	
			
				try (Session ses = HibernateUtils.getSession()) {
					
					InsurancePolicy ip = ses.get(InsurancePolicy.class, 101);
					System.out.println("Object is :: " + ip);
		
				} catch (HibernateException he) {
					System.out.println("Record not found");
					he.printStackTrace();
				}
	
		}

	}
}
