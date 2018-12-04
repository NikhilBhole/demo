package com.yash.service;

import com.yash.model.Address;
import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;

public interface EmployeeService {

	public Employee getEmployeeById(int employeeId);
	
	public int addAddress(Address address);
	
	public int addEducation(Education education);
	
	public int addSkill(Skill skill);
	
	public int addExperience(WorkExperience experience);
	
	public int deleteEducation(int educationId);
	
	public int deleteSkill(int skillId);
	
	public int deleteExperience(int experienceId);
	
	public Education getEducationById(int educationId);
	
	public Skill getSkillById(int skillId);
	
	public WorkExperience getExperienceById(int experienceId);
	
	public int updateEducation(Education education);
	
	public int updateSkill(Skill skill);
	
	public int updateExperience(WorkExperience experience);
	
}
