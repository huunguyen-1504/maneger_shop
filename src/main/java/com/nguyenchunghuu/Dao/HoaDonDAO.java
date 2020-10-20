package com.nguyenchunghuu.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenchunghuu.DaoImp.HoaDonIMP;
import com.nguyenchunghuu.Entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonIMP{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public int addHD(HoaDon hoaDon) {
		Session session = mysessionFactory.getCurrentSession();
		int id = (int) session.save(hoaDon);
		if(id > 0) {
			return id;
		} else {
			return 0;
		}	
	}
	
}
