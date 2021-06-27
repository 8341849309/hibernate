package com.nt.service;

import com.nt.dao.IInsuranceDAO;
import com.nt.dao.InsuranceDAOImpl;
import com.nt.entity.InsurancePolicy;

public class InsuranceServiceImpl implements IInsuranceService {

	private IInsuranceDAO dao;
	
	public InsuranceServiceImpl() {
		dao=new InsuranceDAOImpl();
	}
	
	public InsurancePolicy getDetails(int id) throws Exception {
		System.out.println("InsuranceServiceImpl.getDetails()");
		return dao.getDetails(id);
	}

}
