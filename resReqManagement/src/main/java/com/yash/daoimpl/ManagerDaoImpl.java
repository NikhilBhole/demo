package com.yash.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.ManagerDao;
import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;

@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployee() {
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Employee.class);       
			List<Employee> employeeList=  (List<Employee>)criteria.list();			
	        return employeeList;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Employee getEmployeeById(int employeeId) {
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Employee.class);
	        criteria.add(Restrictions.eq("employeeId", employeeId));
	        Employee employee= (Employee)criteria.uniqueResult();
	        return employee;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<WorkExperience> getExperienceListById(int employeeId) {
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(WorkExperience.class);
	        criteria.add(Restrictions.eq("employeeId", employeeId));
	        List<WorkExperience> experienceList= (List<WorkExperience>) criteria.list();
	        return experienceList;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Skill> getSkillListById(int employeeId) {
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Skill.class);
	        criteria.add(Restrictions.eq("employeeId", employeeId));
	        List<Skill> skillList= (List<Skill>) criteria.list();
	        return skillList;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Education> getEducationListById(int employeeId) {
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Education.class);
	        criteria.add(Restrictions.eq("employeeId", employeeId));
	        List<Education> educationList= (List<Education>) criteria.list();
	        return educationList;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
