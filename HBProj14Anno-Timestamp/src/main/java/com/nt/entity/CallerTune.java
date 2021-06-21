package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CALLER_TUNE_TIMESTAMP_ANNO")
public class CallerTune {
	
	@Id
	@Column(name = "CALLER_ID")
	@GeneratedValue
	@Type(type = "integer")
	private Integer callerId;
	
	@Column(name = "CALLER_TUNE", length = 50)
	@Type(type = "string")
	private String callerTune;
	
	@Column(name = "PROVIDER",length = 50)
	@Type(type = "string")
	private String provider;
	
	@Column(name = "PHONE_NUMBER")
	@Type(type = "long")
	private Long phone;
	
	@Version
	@Type(type = "integer")
	private Integer changeCount; //Versioning
	
	@CreationTimestamp
	private Timestamp createdOn;
	
	@UpdateTimestamp
	private Timestamp changedOn;
	
}
