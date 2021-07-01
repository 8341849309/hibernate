package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person {
	private String desg;
	private String company;
	private Float salary;

	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", company=" + company + ", salary=" + salary + ", getPid()=" + getPid()
				+ ", getPname()=" + getPname() + ", getAddrs()=" + getAddrs() + "]";
	}

}
