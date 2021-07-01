package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JobDetails {

	@Column(name = "DESIGNATION",length = 40)
	@Type(type = "string")
	private String desg;

	@Column(name = "COMPANY_NAME",length = 50)
	@Type(type = "string")
	private String company;

	@Column(name = "SALARY")
	@Type(type = "float")
	private Float salary;
	
}
