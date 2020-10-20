package com.nguyenchunghuu.DaoImp;

import java.util.List;

import com.nguyenchunghuu.Entity.SanPham;

public interface SaPhamImp {
	public List<SanPham> getListSP(int spStart);
	public List<SanPham> getListSPDel(int spStart);
	public SanPham getListSPByID(int idSP);
	public boolean DelSPByID(int idSP);
	public boolean Addproduct(SanPham sanpham);
	public boolean UpdatePr(SanPham sanpham);
	public Long getSoLuongSP(int idSP);
}
