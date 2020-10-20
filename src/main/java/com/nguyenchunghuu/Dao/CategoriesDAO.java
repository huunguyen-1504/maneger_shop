package com.nguyenchunghuu.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenchunghuu.DaoImp.CateGoriesIMP;
import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Loaisp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoriesDAO implements CateGoriesIMP{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public List<DoiTuong> getDoiTuong() {
		Session session = mysessionFactory.getCurrentSession();
		List<DoiTuong> doiTuong = session.createQuery("from doituong").getResultList();
		return doiTuong;
	}

	@Override
	@Transactional
	public DoiTuong getDoiTongByName(String categories) {
		Session session = mysessionFactory.getCurrentSession();
		//String test = categories.replace("'", "\\'");
		String sql = "from doituong where tenDoiTuong=:tenDoiTuong";
		DoiTuong dtbyID = (DoiTuong) session.createQuery(sql).setParameter("tenDoiTuong", categories).getSingleResult();	
		return dtbyID;
	}
	
	@Override
	@Transactional
	public int getSPByDoiTuong(String categories) {
		Session session = mysessionFactory.getCurrentSession();
		//String test = categories.replace("'", "\\'");
		String sql = "from doituong where tenDoiTuong=:tenDoiTuong";
		DoiTuong dtbyID = (DoiTuong) session.createQuery(sql).setParameter("tenDoiTuong", categories).getSingleResult();	
		return 1;
	}
	
	@Override
	@Transactional
	public List<Loaisp> getLoaiByID(int idDT) {
		Session session = mysessionFactory.getCurrentSession();
		List<Loaisp> loai = session.createQuery("from loaisp where 	idDoiTuong ="+idDT).getResultList();
		return loai;
	}

}
