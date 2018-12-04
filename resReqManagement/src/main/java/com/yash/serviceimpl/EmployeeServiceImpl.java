package com.yash.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.EmployeeDao;
import com.yash.model.Address;
import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;
import com.yash.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public int addAddress(Address address) {
		return employeeDao.addAddress(address);
	}

	public int addEducation(Education education) {
		return employeeDao.addEducation(education);
	}

	public int addSkill(Skill skill) {
		return employeeDao.addSkill(skill);
	}

	public int addExperience(WorkExperience experience) {
		return employeeDao.addExperience(experience);
	}

	public int deleteEducation(int educationId) {
		return employeeDao.deleteEducation(educationId);
	}

	public int deleteSkill(int skillId) {
		return employeeDao.deleteSkill(skillId);
	}

	public int deleteExperience(int experienceId) {
		return employeeDao.deleteExperience(experienceId);
	}

	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	public Education getEducationById(int educationId) {
		return employeeDao.getEducationById(educationId);
	}

	public Skill getSkillById(int skillId) {
		return employeeDao.getSkillById(skillId);
	}

	public WorkExperience getExperienceById(int experienceId) {
		return employeeDao.getExperienceById(experienceId);
	}

	public int updateEducation(Education education) {
		return employeeDao.updateEducation(education);
	}

	public int updateSkill(Skill skill) {
		return employeeDao.updateSkill(skill);
	}

	public int updateExperience(WorkExperience experience) {
		return employeeDao.updateExperience(experience);
	}

}
