package com.nguyenchunghuu.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSP;
	
	@OneToOne
	@JoinColumn(name = "idDoiTuong")
	DoiTuong doiTuong;
	
	@OneToOne
	@JoinColumn(name = "idLoai")
	Loaisp loaisp;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "idSP")
	Set<ChiTietSP> chiTietSPs;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "chitietkm",
				joinColumns = {@JoinColumn(name="idSP", referencedColumnName = "idSP")}, 
				inverseJoinColumns = {@JoinColumn(name="idKM",referencedColumnName = "idKM")})
	Set<KhuyenMai> khuyenMais;
	
	
	
	String tenSP;
	int giaTien;
	String moTa;
	String hinhSP;
	int status;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<ChiTietSP> getChiTietSPs() {
		return chiTietSPs;
	}
	public void setChiTietSPs(Set<ChiTietSP> chiTietSPs) {
		this.chiTietSPs = chiTietSPs;
	}
	public Set<KhuyenMai> getKhuyenMais() {
		return khuyenMais;
	}
	public void setKhuyenMais(Set<KhuyenMai> khuyenMais) {
		this.khuyenMais = khuyenMais;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	public DoiTuong getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(DoiTuong doiTuong) {
		this.doiTuong = doiTuong;
	}

	public Loaisp getLoaisp() {
		return loaisp;
	}
	public void setLoaisp(Loaisp loaisp) {
		this.loaisp = loaisp;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhSP() {
		return hinhSP;
	}
	public void setHinhSP(String hinhSP) {
		this.hinhSP = hinhSP;
	}
	
	
}
