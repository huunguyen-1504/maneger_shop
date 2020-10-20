package com.nguyenchunghuu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sizesp")
public class SizeSP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSize;
	String tenSize;
	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}
	public String getTenSize() {
		return tenSize;
	}
	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

}
