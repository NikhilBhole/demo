package com.yash.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.EmployeeDao;
import com.yash.dao.ManagerDao;
import com.yash.model.Address;
import com.yash.model.Education;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ManagerDao managerDao;
	
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

	public int addAddress(Address address) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(address);
			session.beginTransaction();
			session.save(address);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	public int addEducation(Education education) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(education);
			session.beginTransaction();
			session.save(education);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	public int addSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(skill);
			session.beginTransaction();
			session.save(skill);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	public int addExperience(WorkExperience experience) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(experience);
			session.beginTransaction();
			session.save(experience);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteEducation(int educationId) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(educationId);
			session.beginTransaction();
			System.out.println("in deleteEducation : "+getEducationById(educationId));
			session.delete(getEducationById(educationId));
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteSkill(int skillId) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(skillId);
			session.beginTransaction();
			System.out.println("in deleteSkill : "+getSkillById(skillId));
			session.delete(getSkillById(skillId));
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteExperience(int experienceId) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(experienceId);
			session.beginTransaction();
			System.out.println("in deleteExperience : "+getExperienceById(experienceId));
			session.delete(getExperienceById(experienceId));
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Education getEducationById(int educationId) {
		try {
			Session session= sessionFactory.openSession();
			session.beginTransaction();
	        Criteria criteria = session.createCriteria(Education.class);
	        criteria.add(Restrictions.eq("educationDetailId", educationId));
	        Education education= (Education)criteria.uniqueResult();
	        session.getTransaction().commit();
	        return education;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Skill getSkillById(int skillId) {
		try {
			System.out.println("in getSkillById : "+ skillId);
			Session session= sessionFactory.openSession();
			session.beginTransaction();
	        Criteria criteria = session.createCriteria(Skill.class);
	        criteria.add(Restrictions.eq("skillId", skillId));
	        Skill skill= (Skill)criteria.uniqueResult();
	        session.getTransaction().commit();
	        return skill;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public WorkExperience getExperienceById(int experienceId) {
		try {
			Session session= sessionFactory.openSession();
			session.beginTransaction();
	        Criteria criteria = session.createCriteria(WorkExperience.class);
	        criteria.add(Restrictions.eq("workExpId", experienceId));
	        WorkExperience experience= (WorkExperience)criteria.uniqueResult();
	        session.getTransaction().commit();
	        return experience;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public int updateEducation(Education education) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(education);
			session.beginTransaction();
			session.update(education);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateSkill(Skill skill) {
		System.out.println("in employeeDaoImpl : "+skill);
		Session session = sessionFactory.openSession();
		try {
			System.out.println(skill);
			session.beginTransaction();
			session.update(skill);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateExperience(WorkExperience experience) {
		Session session = sessionFactory.openSession();
		try {
			System.out.println(experience);
			session.beginTransaction();
			session.update(experience);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
