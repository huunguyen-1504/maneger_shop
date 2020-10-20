package com.nguyenchunghuu.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "hoadon")
public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idHD;
	
	String tenKH;
	int soDT;
	String tinhTrang;
	String diaChi;
	String ghiChu;
	String ngayLap;

	
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idHD")
	Set<ChiTietHD> chiTietHDs;	
	
	public Set<ChiTietHD> getChiTietHDs() {
		return chiTietHDs;
	}
	public void setChiTietHDs(Set<ChiTietHD> chiTietHDs) {
		this.chiTietHDs = chiTietHDs;
	}
	
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getIdHD() {
		return idHD;
	}
	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public int getSoDT() {
		return soDT;
	}
	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
