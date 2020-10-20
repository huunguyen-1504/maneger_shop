package com.nguyenchunghuu.DaoImp;

import com.nguyenchunghuu.Entity.User;

public interface UserImp {
	boolean checkLogin(String uname, String psw);
	boolean addUser(User user);
}
