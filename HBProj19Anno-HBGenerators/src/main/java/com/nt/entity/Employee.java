package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_GENERATOR_ANNO")
public class Employee {

	@Id
	@GenericGenerator(name = "gen1",strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	@Column(name = "EMP_ID")
	private Long empid;
	
	@Column(name = "EMP_NAME",length = 25)
	private String name;

	@Column(name = "SALARY")
	private Float salary;
	
}
