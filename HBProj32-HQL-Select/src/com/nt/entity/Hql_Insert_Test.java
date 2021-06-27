package com.nt.entity;

public class Hql_Insert_Test {

	private Integer id;
	private String name;
	private String addrs;
	private Long phone;
	private Float salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Hql_Insert_Test [id=" + id + ", name=" + name + ", addrs=" + addrs + ", phone=" + phone + ", salary="
				+ salary + "]";
	}

}
