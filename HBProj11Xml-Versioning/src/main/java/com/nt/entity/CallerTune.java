package com.nt.entity;

import lombok.Data;

@Data
public class CallerTune {
	private Integer callerId;
	private String callerTune;
	private String provider;
	private Long phone;
	private Integer changeCount; //Versioning
	
}
