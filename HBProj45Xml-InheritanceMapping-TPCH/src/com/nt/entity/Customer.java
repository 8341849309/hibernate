package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
	private Float billAmt;
	private Float discount;

	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", discount=" + discount + ", getPid()=" + getPid() + ", getPname()="
				+ getPname() + ", getAddrs()=" + getAddrs() + "]";
	}

}
