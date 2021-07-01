package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utils.HibernateUtils;

public class InhMappingDaoImpl implements IInhMappingDao {

	@Override
	public void save() {
		Transaction tx=null;
		
		try(Session ses=HibernateUtils.getSession()){
			
			tx=ses.beginTransaction();
			
			Payment card=new CardPayment(12345678L, "CREDIT-CARD", "VISA");
			card.setAmount(10000D);
			
			Payment cheque=new ChequePayment(87654321L, "SELF");
			cheque.setAmount(20000D);
			
			ses.save(card);
			ses.save(cheque);
			
			tx.commit();
			System.out.println("Amount Deducted!!!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			System.out.println("Problem in Paymnet...");
		}

	}

	@Override
	public void load() {
		
		try(Session ses=HibernateUtils.getSession()){
			
			Query query1=ses.createQuery("from CardPayment");
			List<Payment> list1=query1.getResultList();
			
			list1.forEach(System.out::println);
			
			System.out.println("============================");
			
			Query query2=ses.createQuery("from ChequePayment");
			List<Payment> list2=query2.getResultList();
			
			list2.forEach(System.out::println);
			
			System.out.println("============================");
			Query query3=ses.createQuery("from Payment");
			List<Payment> list3=query3.getResultList();
			
			list3.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
