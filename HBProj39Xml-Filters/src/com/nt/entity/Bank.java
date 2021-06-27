package com.nt.entity;

import lombok.Data;

@Data
public class Bank {

	private Long acno;
	private String holderName;
	private Float balance;
	private String status;

}
