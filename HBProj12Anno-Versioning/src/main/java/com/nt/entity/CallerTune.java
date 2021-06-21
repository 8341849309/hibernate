package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "CALLER_TUNE_VERSIONING_ANNO")
public class CallerTune {
	@Id
	@GeneratedValue
	@Column(name = "CALLER_ID")
	private Integer callerId;
	
	@Column(name = "CALLER_TUNE",length = 25)
	private String callerTune;
	
	@Column(name = "PROVIDER",length = 25)
	private String provider;
	
	@Column(name = "PHONE_NUMBER")
	private Long phone;
	
	@Version
	private Integer changeCount; //Versioning
	
}
