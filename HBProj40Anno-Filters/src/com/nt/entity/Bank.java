package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Table(name = "BANK_ACCOUNT")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@FilterDef(name = "IGNORE_ACCOUNTS_FILTER", 
		parameters = {
				@ParamDef(type = "string",name = "accountType1"),
				@ParamDef(type = "string",name = "accountType2"),
				@ParamDef(type = "string",name = "accountType3"),
					})
@Filter(name = "IGNORE_ACCOUNTS_FILTER",
		condition = "STATUS NOT IN(:accountType1,:accountType2,:accountType3)")
@Entity
public class Bank {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_NUM")
	@Type(type = "long")
	private Long acno;

	@Column(name = "HOLDER_NAME", length = 20)
	@Type(type = "string")
	private String holderName;

	@Column(name = "BALANCE")
	@Type(type = "float")
	private Float balance;

	@Column(name = "STATUS", length = 20)
	@Type(type = "string")
	private String status;

}
