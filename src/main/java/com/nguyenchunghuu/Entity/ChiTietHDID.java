package com.nguyenchunghuu.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHDID implements Serializable{

	int idHD;
	int idChiTietSP;
	public int getIdHD() {
		return idHD;
	}
	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}
	public int getIdChiTietSP() {
		return idChiTietSP;
	}
	public void setIdChiTietSP(int idChiTietSP) {
		this.idChiTietSP = idChiTietSP;
	}
	
	
}
