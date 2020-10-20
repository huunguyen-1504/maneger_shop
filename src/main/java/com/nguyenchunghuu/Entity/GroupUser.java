package com.nguyenchunghuu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="groupuser")
public class GroupUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idGroup;
	String tenGroup;
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public String getTenGroup() {
		return tenGroup;
	}
	public void setTenGroup(String tenGroup) {
		this.tenGroup = tenGroup;
	}
	
	
}
