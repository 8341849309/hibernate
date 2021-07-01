package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("CHEQUE")
@Table(name = "INH_ANNO_DESCR_CHEQUE_PAYMENT_TPSCH")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID", referencedColumnName = "PID")
public class ChequePayment extends Payment {

	private Long chequeNo;

	@Column(length = 50)
	private String chequeType;

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", getPid()=" + getPid()
				+ ", getAmount()=" + getAmount() + ", getDt()=" + getDt() + "]";
	}

}
