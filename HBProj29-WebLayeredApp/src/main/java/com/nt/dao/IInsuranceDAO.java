package com.nt.dao;

import com.nt.entity.InsurancePolicy;

public interface IInsuranceDAO {

	public InsurancePolicy getDetails(int id) throws Exception;
}
