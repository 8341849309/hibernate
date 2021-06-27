package com.nt.service;

import com.nt.entity.InsurancePolicy;

public interface IInsuranceService {

	public InsurancePolicy getDetails(int id) throws Exception;
	
}
