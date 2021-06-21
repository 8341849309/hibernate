package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_HBM2DDL_TEST")
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Float salary;
	
}
