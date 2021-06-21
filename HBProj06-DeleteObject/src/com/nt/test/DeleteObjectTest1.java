package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtils;

public class DeleteObjectTest1 {

	public static void main(String[] args) {

		// Create Session
		Session ses = HibernateUtils.getSession();

		Transaction tx = null;
		boolean flag=false;

		try {
			//Here If u apply not-null constraint on property us 
			//should also fill that attribute in order to delete the record
			tx = ses.beginTransaction();
			
			Actor actor=new Actor();
			actor.setActorid(101);
			
			ses.delete(actor);
			System.out.println("Actor deleted ");
			
			flag=true;

		} catch (HibernateException he) {
			System.out.println("Actor not found");
		}

		finally {
			
			if(flag)
				tx.commit();
			else
				tx.rollback();
			
			HibernateUtils.closeSession(ses);
			HibernateUtils.closeSessionFactory();
		}

	}

}
