package com.SSSSWeb.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AC_STANDARD_INF")
public class AC_STANDARD_INF {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	private String standard;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
}
