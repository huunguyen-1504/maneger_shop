package com.nguyenchunghuu.DaoImp;

import java.util.List;

import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;

public interface CateGoriesIMP {
	public List<DoiTuong> getDoiTuong();
	
	public DoiTuong getDoiTongByName(String categories);
	
	public List<Loaisp> getLoaiByID(int idDT);

	public int getSPByDoiTuong(String categories);
}
