package com.nguyenchunghuu.Entity;

import java.util.Set;

public class Json_SanPham {
	
	int idSP;
	DoiTuong doiTuong;
	Loaisp loaisp;
	Set<ChiTietSP> chiTietSPs;
	Set<KhuyenMai> khuyenMais;

	String tenSP;
	int giaTien;
	String moTa;
	String hinhSP;
	
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
