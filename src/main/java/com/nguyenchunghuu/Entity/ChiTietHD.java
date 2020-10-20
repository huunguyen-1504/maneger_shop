package com.nguyenchunghuu.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "chitiethd")
public class ChiTietHD {
	
	@EmbeddedId
	ChiTietHDID chitiethdID;
	
	int soluong;
	int giatien;
	
	public ChiTietHDID getChitiethdID() {
		return chitiethdID;
	}
	public void setChitiethdID(ChiTietHDID chitiethdID) {
		this.chitiethdID = chitiethdID;
	}
	
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	
	
}
