package com.nguyenchunghuu.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.nguyenchunghuu.DaoImp.ChiTietHDImp;
import com.nguyenchunghuu.Entity.ChiTietHD;
import com.nguyenchunghuu.Entity.ChiTietHDID;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHDDao implements ChiTietHDImp{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public boolean addCTHD(ChiTietHD cthd) {
		Session session = mysessionFactory.getCurrentSession();
		ChiTietHDID id = (ChiTietHDID) session.save(cthd);
		if(id == null) {
			return false;
		} else {
			return true;
		}
	
	}
	
}
