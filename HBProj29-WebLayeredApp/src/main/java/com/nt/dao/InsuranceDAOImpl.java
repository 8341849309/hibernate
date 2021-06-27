package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtils;

public class InsuranceDAOImpl implements IInsuranceDAO {

	public InsurancePolicy getDetails(int id) throws Exception {

		Session ses=HibernateUtils.getSession();
		Session ses1=HibernateUtils.getSession();
		
		System.out.println("ThreadLocal "+ses.hashCode()+" "+ses1.hashCode());
		
		InsurancePolicy policy= ses.get(InsurancePolicy.class, id);
		System.out.println("Policy "+policy);
		return policy;
	}

}
