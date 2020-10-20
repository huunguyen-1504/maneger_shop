package com.nguyenchunghuu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.GetAllDetailDAO;
import com.nguyenchunghuu.DaoImp.GetAllDetailImp;
import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;
import com.nguyenchunghuu.Entity.MauSP;
import com.nguyenchunghuu.Entity.SizeSP;

@Service
public class GetAllDetailService implements GetAllDetailImp{

	@Autowired
	GetAllDetailDAO getAllDetailDao;
	
	
	@Override
	public List<MauSP> getListMauSP() {
		// TODO Auto-generated method stub
		return getAllDetailDao.getListMauSP();
	}

	@Override
	public List<SizeSP> getListSizeSP() {
		// TODO Auto-generated method stub
		return getAllDetailDao.getListSizeSP();
	}

	@Override
	public List<DoiTuong> getListDoituong() {
		// TODO Auto-generated method stub
		return getAllDetailDao.getListDoituong();
	}

	@Override
	public List<Loaisp> getListLoaiSP() {
		// TODO Auto-generated method stub
		return getAllDetailDao.getListLoaiSP();
	}

}
