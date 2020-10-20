package com.nguyenchunghuu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.ChiTietHDDao;
import com.nguyenchunghuu.DaoImp.ChiTietHDImp;
import com.nguyenchunghuu.Entity.ChiTietHD;

@Service
public class ChiTietHDService implements ChiTietHDImp{

	@Autowired
	ChiTietHDDao cthddao;
	
	@Override
	public boolean addCTHD(ChiTietHD cthd) {		
		return cthddao.addCTHD(cthd);
	}
	
}
