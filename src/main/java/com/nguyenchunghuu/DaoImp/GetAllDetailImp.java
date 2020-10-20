package com.nguyenchunghuu.DaoImp;

import java.util.List;

import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;
import com.nguyenchunghuu.Entity.MauSP;
import com.nguyenchunghuu.Entity.SizeSP;

public interface GetAllDetailImp {
	
	public List<MauSP> getListMauSP();
	public List<SizeSP> getListSizeSP();
	public List<DoiTuong> getListDoituong();
	public List<Loaisp> getListLoaiSP();

}
