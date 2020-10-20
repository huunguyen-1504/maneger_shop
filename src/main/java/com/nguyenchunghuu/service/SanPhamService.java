package com.nguyenchunghuu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.SanPhamDAO;
import com.nguyenchunghuu.DaoImp.SaPhamImp;
import com.nguyenchunghuu.Entity.SanPham;

@Service
public class SanPhamService implements SaPhamImp{

	@Autowired
	SanPhamDAO sanphamDao;
	
	@Override
	public List<SanPham> getListSP(int spStart) {	
		return sanphamDao.getListSP(spStart);
	}

	@Override
	public SanPham getListSPByID(int idSP) {
		return sanphamDao.getListSPByID(idSP);
	}

	@Override
	public boolean DelSPByID(int idSP) {
		return sanphamDao.DelSPByID(idSP);
	}

	@Override
	public boolean Addproduct(SanPham sanpham) {
		// TODO Auto-generated method stub
		return sanphamDao.Addproduct(sanpham);
	}

	@Override
	public boolean UpdatePr(SanPham sanpham) {
		// TODO Auto-generated method stub
		return sanphamDao.UpdatePr(sanpham);
	}

	@Override
	public Long getSoLuongSP(int idSP) {
		// TODO Auto-generated method stub
		return sanphamDao.getSoLuongSP(idSP);
	}

	@Override
	public List<SanPham> getListSPDel(int spStart) {
		
		return sanphamDao.getListSPDel(spStart);
	}

	
}
