package com.nguyenchunghuu.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "chitietkm")
public class ChiTietKM implements Serializable{
	
	@Id
	int idKM;
	@Id
	int idSP;
	
	public int getIdKM() {
		return idKM;
	}
	public void setIdKM(int idKM) {
		this.idKM = idKM;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	
	
}
