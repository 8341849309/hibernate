package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utils.HibernateUtils;

public class CMInsertTest {

	public static void main(String[] args) {
		
		Transaction tx=null;
		
		try(SessionFactory factory=HibernateUtils.getSessionFactory();
				Session ses=HibernateUtils.getSession()){
			
			tx=ses.beginTransaction();
			
			Person per=new Person("Venkateswarlu", 
							new JobDetails("Programmer Analyst", "Cognizant", 30000F));
			
			Integer pid=(Integer) ses.save(per);
			tx.commit();
			
			System.out.println("Person saved "+pid);
			
		}catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
