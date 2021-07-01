package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Cheque")
public class ChequePayment extends Payment {

	private Long chequeNo;

	@Column(length = 20)
	private String chequeType;

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", getPid()=" + getPid()
				+ ", getAmount()=" + getAmount() + ", getDt()=" + getDt() + "]";
	}

}
