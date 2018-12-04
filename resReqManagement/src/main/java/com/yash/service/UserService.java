package com.yash.service;

import com.yash.model.Employee;

public interface UserService {
	
	public Employee userLogin(String userName, String password);
	public int userRegistration(Employee employee);

}
