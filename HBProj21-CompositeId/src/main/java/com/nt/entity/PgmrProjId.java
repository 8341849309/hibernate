package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PgmrProjId implements Serializable {
	private Integer pgmrId;
	private Integer projId;

}
