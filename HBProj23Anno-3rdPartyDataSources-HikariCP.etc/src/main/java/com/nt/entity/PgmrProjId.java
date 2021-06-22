package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PgmrProjId implements Serializable {
	private Integer pgmrId;
	private Integer projId;

}
