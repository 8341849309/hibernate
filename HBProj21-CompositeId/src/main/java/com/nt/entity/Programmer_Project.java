package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Programmer_Project implements Serializable {
	private PgmrProjId id;
	private String pgmrName;
	private Integer age;
	private String projName;
}
