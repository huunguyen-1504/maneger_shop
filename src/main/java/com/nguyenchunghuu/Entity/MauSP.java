package com.nguyenchunghuu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "mausp")
public class MauSP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMau;
	String tenMau;
	public int getIdMau() {
		return idMau;
	}
	public void setIdMau(int idMau) {
		this.idMau = idMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	
	
}
