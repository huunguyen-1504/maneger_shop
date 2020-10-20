package com.nguyenchunghuu.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "doituong")
public class DoiTuong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idDoiTuong;
	String tenDoiTuong;
	String hinhDT;
	String tag;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "idDoiTuong")
	Set<SanPham> sanPhams;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "idDoiTuong")
	Set<Loaisp> loaisps;

	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<Loaisp> getLoaisps() {
		return loaisps;
	}

	public void setLoaisps(Set<Loaisp> loaisps) {
		this.loaisps = loaisps;
	}

	public int getIdDoiTuong() {
		return idDoiTuong;
	}

	public void setIdDoiTuong(int idDoiTuong) {
		this.idDoiTuong = idDoiTuong;
	}

	public String getTenDoiTuong() {
		return tenDoiTuong;
	}

	public void setTenDoiTuong(String tenDoiTuong) {
		this.tenDoiTuong = tenDoiTuong;
	}

	public String getHinhDT() {
		return hinhDT;
	}

	public void setHinhDT(String hinhDT) {
		this.hinhDT = hinhDT;
	}

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}
