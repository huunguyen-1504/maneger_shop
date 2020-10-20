package com.nguyenchunghuu.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="loaisp")
public class Loaisp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idLoai;
	String tenLoai;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDoiTuong")
	DoiTuong doiTuong;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLoai")
	Set<SanPham> sanPhams;

	public int getIdLoai() {
		return idLoai;
	}

	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public DoiTuong getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(DoiTuong doiTuong) {
		this.doiTuong = doiTuong;
	}

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}
