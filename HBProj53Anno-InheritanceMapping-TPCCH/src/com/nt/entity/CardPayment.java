package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INH_ANNO_DESCR_CARD_PAYMENT_TPSCH")
public class CardPayment extends Payment {

	private Long cardNo;

	@Column(length = 50)
	private String cardType;

	@Column(length = 50)
	private String gateway;

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway + ", getPid()="
				+ getPid() + ", getAmount()=" + getAmount() + ", getDt()=" + getDt() + "]";
	}

}
