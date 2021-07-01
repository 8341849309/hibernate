package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "INH_ANNO_DESCR_PAYMENT_TPCH")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {

	@Id
	@GeneratedValue
	private Integer pid;

	private Double amount;

	@CreationTimestamp
	private LocalDateTime dt;

}
