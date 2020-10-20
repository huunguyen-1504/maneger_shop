package com.nguyenchunghuu.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "khuyenmai")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idKM;
	String tenKM;
	String thoigianbatdau;
	String thoigianketthuc;
	String mota;
	String hinhKM;
	int giagiam;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "chitietkm",
				joinColumns = {@JoinColumn(name="idKM", referencedColumnName = "idKM")}, 
				inverseJoinColumns = {@JoinColumn(name="idSP",referencedColumnName = "idSP")}
			)
	Set<SanPham> sanPhams;

	public int getIdKM() {
		return idKM;
	}

	public void setIdKM(int idKM) {
		this.idKM = idKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public String getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public String getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhKM() {
		return hinhKM;
	}

	public void setHinhKM(String hinhKM) {
		this.hinhKM = hinhKM;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}
