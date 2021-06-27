package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "INSURANCE_POLICY")
public class InsurancePolicy {
	@Id
	@Column(name = "POLICYID")
	private Integer policyId;
	@Column(name = "POLICYNAME", length = 25, nullable = false)
	private String policyName;
	@Column(name = "DURATION")
	private Float duration;
	@Column(name = "COMPANY_NAME", length = 25, nullable = false)
	private String companyName;
}
