package com.nguyenchunghuu.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenchunghuu.DaoImp.SaPhamImp;
import com.nguyenchunghuu.Entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SaPhamImp{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public List<SanPham> getListSP(int spStart) {
		Session session = mysessionFactory.getCurrentSession();
		if(spStart < 0) {
			List<SanPham> sanPhams = session.createQuery("from sanpham sp where sp.status = 1 ORDER BY sp.idSP DESC").getResultList();
			return sanPhams;
		}
		else {
			List<SanPham> sanPhams = session.createQuery("from sanpham sp where sp.status = 1 ORDER BY sp.idSP DESC").setFirstResult(spStart).setMaxResults(6).getResultList();
			return sanPhams;
		}
	}

	@Override
	@Transactional
	public SanPham getListSPByID(int idSP) {
		Session session = mysessionFactory.getCurrentSession();
		SanPham sanPhams = (SanPham) session.createQuery("from sanpham where idSP ="+idSP).getSingleResult();
		return sanPhams;
	}

	@Override
	@Transactional
	public boolean DelSPByID(int idSP) {
		Session session = mysessionFactory.getCurrentSession();
		//SanPham sp = new SanPham();
		String sql = "update sanpham sp set sp.status = 0 where idSP = "+idSP;
		int update = session.createQuery(sql).executeUpdate();
		//System.out.println(update);
		return false;
	}

	@Override
	@Transactional
	public boolean Addproduct(SanPham sanpham) {
		Session session = mysessionFactory.getCurrentSession();
		int idSP = (int) session.save(sanpham);
		//System.out.println(idSP);
		return false;
	}

	@Override
	@Transactional
	public boolean UpdatePr(SanPham sanpham) {
		Session session = mysessionFactory.getCurrentSession();
		session.update(sanpham);
		return true;
	}

	@Override
	@Transactional
	public Long getSoLuongSP(int idSP) {
		Session session = mysessionFactory.getCurrentSession();
		String sql = "SELECT sum(sp.soLuong) FROM chitietsp sp where idSP = "+idSP;
		Long soLuong = (Long) session.createQuery(sql).getSingleResult();
		return soLuong;
	}

	@Override
	@Transactional
	public List<SanPham> getListSPDel(int spStart) {
		Session session = mysessionFactory.getCurrentSession();
		List<SanPham> sanPhams = session.createQuery("from sanpham sp where sp.status = 0 ORDER BY sp.idSP DESC").getResultList();
		return sanPhams;
	}

	
}
