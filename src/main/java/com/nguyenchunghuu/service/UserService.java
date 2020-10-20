package com.nguyenchunghuu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchunghuu.Dao.UserDao;
import com.nguyenchunghuu.DaoImp.UserImp;
import com.nguyenchunghuu.Entity.User;

@Service
public class UserService implements UserImp{
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean checkLogin(String uname, String psw) {
		boolean check = userDao.checkLogin(uname, psw);
		return check;
	}

	@Override
	public boolean addUser(User user) {
		boolean check = userDao.addUser(user);
		return check;
	}
}
