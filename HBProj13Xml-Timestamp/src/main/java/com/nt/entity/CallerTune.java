package com.nt.entity;

import java.util.Date;

import lombok.Data;

@Data
public class CallerTune {
	private Integer callerId;
	private String callerTune;
	private String provider;
	private Long phone;
	private Date lastModified; //timestamp
	
}
