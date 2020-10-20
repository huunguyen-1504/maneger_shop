package com.nguyenchunghuu.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenchunghuu.DaoImp.GetAllDetailImp;
import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;
import com.nguyenchunghuu.Entity.MauSP;
import com.nguyenchunghuu.Entity.SizeSP;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GetAllDetailDAO implements GetAllDetailImp{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public List<MauSP> getListMauSP() {
		Session session = mysessionFactory.getCurrentSession();
		List<MauSP> listMau = session.createQuery("from mausp").getResultList();
		return listMau;
	}

	@Override
	@Transactional
	public List<SizeSP> getListSizeSP() {
		Session session = mysessionFactory.getCurrentSession();
		List<SizeSP> listSize = session.createQuery("from sizesp").getResultList();
		return listSize;
	}

	@Override
	@Transactional
	public List<DoiTuong> getListDoituong() {
		Session session = mysessionFactory.getCurrentSession();
		List<DoiTuong> listDoituong = session.createQuery("from doituong").getResultList();
		return listDoituong;
	}

	@Override
	@Transactional
	public List<Loaisp> getListLoaiSP() {
		Session session = mysessionFactory.getCurrentSession();
		List<Loaisp> listLoai = session.createQuery("from loaisp").getResultList();
		return listLoai;
	}

}
