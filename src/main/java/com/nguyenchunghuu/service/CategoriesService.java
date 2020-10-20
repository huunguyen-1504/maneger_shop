package com.nguyenchunghuu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.CategoriesDAO;
import com.nguyenchunghuu.DaoImp.CateGoriesIMP;
import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;

@Service
public class CategoriesService implements CateGoriesIMP{

	@Autowired
	CategoriesDAO categoriesDAO;
	
	@Override
	public List<DoiTuong> getDoiTuong() {	
		return categoriesDAO.getDoiTuong();
	}

	@Override
	public DoiTuong getDoiTongByName(String categories) {
		return categoriesDAO.getDoiTongByName(categories);
	}

	@Override
	public List<Loaisp> getLoaiByID(int idDT) {
		// TODO Auto-generated method stub
		return categoriesDAO.getLoaiByID(idDT);
	}

	@Override
	public int getSPByDoiTuong(String categories) {
		// TODO Auto-generated method stub
		return 0;
	}

}
