package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "GET_ALL_ACTORS", query = "FROM Actor")
@NamedQuery(name = "INCREASE_REMUNERATION", query = "UPDATE Actor SET remuneration=remuneration+:bonus")
public class Actor {
	
	@Id
	@GeneratedValue
	private Integer actorid;
	private String actorname;
	private String actoraddrs;
	private Long phone;
	private Float remuneration;

	public Integer getActorid() {
		return actorid;
	}

	public void setActorid(Integer actorid) {
		this.actorid = actorid;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public String getActoraddrs() {
		return actoraddrs;
	}

	public void setActoraddrs(String actoraddrs) {
		this.actoraddrs = actoraddrs;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Float remuneration) {
		this.remuneration = remuneration;
	}

	@Override
	public String toString() {
		return "Actor [actorid=" + actorid + ", actorname=" + actorname + ", actoraddrs=" + actoraddrs + ", phone="
				+ phone + ", remuneration=" + remuneration + "]";
	}

}
