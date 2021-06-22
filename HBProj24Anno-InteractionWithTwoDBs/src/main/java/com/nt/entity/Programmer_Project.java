package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TWO_DB_INTERACTION")
public class Programmer_Project implements Serializable {
	@EmbeddedId
	private PgmrProjId id;
	@Column(length = 25)
	private String pgmrName;
	private Integer age;
	@Column(length = 25)
	private String projName;
}
