package com.yash.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.ManagerDao;
import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;
import com.yash.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	public List<Employee> getAllEmployee() {
		return managerDao.getAllEmployee();
	}

	public Employee getEmployeeById(int userId) {		
		return managerDao.getEmployeeById(userId);
	}

	public List<WorkExperience> getExperienceListById(int userId) {
		return managerDao.getExperienceListById(userId);
	}

	public List<Skill> getSkillListById(int userId) {
		return managerDao.getSkillListById(userId);
	}

	public List<Education> getEducationListById(int userId) {
		return managerDao.getEducationListById(userId);
	}
}
