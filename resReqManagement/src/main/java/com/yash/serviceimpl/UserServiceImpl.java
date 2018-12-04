package com.yash.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.UserDao;
import com.yash.model.Employee;
import com.yash.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public Employee userLogin(String userName, String password) {
		
		return userDao.userLogin(userName, password);
	}

	public int userRegistration(Employee employee) {
		
		return userDao.userRegistration(employee);
	}

}
