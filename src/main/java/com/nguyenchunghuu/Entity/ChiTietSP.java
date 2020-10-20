package com.nguyenchunghuu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "chitietsp")
public class ChiTietSP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idChiTietSP;
	
	@OneToOne
	@JoinColumn(name = "idSP")
	SanPham sanPham;
	
	@OneToOne
	@JoinColumn(name = "idSize")
	SizeSP sizeSP;
	
	@OneToOne
	@JoinColumn(name = "idMau")
	MauSP mauSP;
	
	int soLuong;
	String ngayNhap;
	public int getIdChiTietSP() {
		return idChiTietSP;
	}
	public void setIdChiTietSP(int idChiTietSP) {
		this.idChiTietSP = idChiTietSP;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public SizeSP getSizeSP() {
		return sizeSP;
	}
	public void setSizeSP(SizeSP sizeSP) {
		this.sizeSP = sizeSP;
	}
	public MauSP getMauSP() {
		return mauSP;
	}
	public void setMauSP(MauSP mauSP) {
		this.mauSP = mauSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	
}
