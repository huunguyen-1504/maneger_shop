package com.nguyenchunghuu.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenchunghuu.DaoImp.UserImp;
import com.nguyenchunghuu.Entity.User;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao implements UserImp{

	@Autowired
	SessionFactory mysessionFactory;
	
	@Override
	@Transactional
	public boolean checkLogin(String uname, String psw) {
		Session session = mysessionFactory.getCurrentSession();
		try {
			User user = (User) session.createQuery("from users where userName='"+uname+"' and passwords = '"+psw+"'").getSingleResult();
			if (user != null) {
				return true;
			} else {
				return false;
			}	
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		Session session = mysessionFactory.getCurrentSession();
		int idCheck = (int) session.save(user);
		if(idCheck > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
