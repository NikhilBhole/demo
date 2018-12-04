package com.yash.dao;

import java.util.List;

import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;

public interface ManagerDao {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int userId);
	public List<WorkExperience> getExperienceListById(int userId);
	public List<Skill> getSkillListById(int userId);
	public List<Education> getEducationListById(int userId);

}
