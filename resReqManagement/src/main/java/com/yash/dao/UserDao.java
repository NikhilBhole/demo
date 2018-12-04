package com.yash.dao;

import com.yash.model.Employee;

public interface UserDao {
	
	public Employee userLogin(String userName, String password);
	public int userRegistration(Employee employee);

}
