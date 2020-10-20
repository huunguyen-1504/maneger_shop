package com.nguyenchunghuu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.HoaDonDAO;
import com.nguyenchunghuu.DaoImp.HoaDonIMP;
import com.nguyenchunghuu.Entity.HoaDon;

@Service
public class HoaDonService implements HoaDonIMP{

	@Autowired
	HoaDonDAO hdDao;
	
	@Override
	public int addHD(HoaDon hoaDon) {
		return hdDao.addHD(hoaDon);
	}
	
}
