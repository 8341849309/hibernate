package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtils;

public class InsuranceDAOImpl implements IInsuranceDAO {

	private Transaction tx=null;
	
	public InsurancePolicy getDetails(int id) throws Exception {
		
		Session ses=HibernateUtils.getSession();
		Session ses1=HibernateUtils.getSession();
		Session ses2=HibernateUtils.getSession();
		
		tx=ses.beginTransaction();
		
		System.out.println("ThreadLocal "+ses.hashCode()+" "+ses1.hashCode()+" "+ses2.hashCode());
		
		InsurancePolicy policy= ses.get(InsurancePolicy.class, id);
		System.out.println("Policy "+policy);
		
		return policy;
	}

}
