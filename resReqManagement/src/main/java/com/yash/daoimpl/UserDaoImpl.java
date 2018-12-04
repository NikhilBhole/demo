package com.yash.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.UserDao;
import com.yash.model.Employee;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Employee userLogin(String userName, String password) {
		
		try {
			Session session= sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Employee.class);
	        criteria.add(Restrictions.eq("userName", userName));
	        criteria.add(Restrictions.eq("password", password));
	        Employee employee= (Employee)criteria.uniqueResult();
	        testSessionFactory();
	        return employee;
	        
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public int userRegistration(Employee employee) {
		employee.setDeleted(false);
		Session session = sessionFactory.openSession();
		try {
			System.out.println(employee);
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}		
	}
	
	public void testSessionFactory() {
		List<String> fieldNames = null;
		Session session = sessionFactory.openSession();
		String sql = "desc "+"employee";
		try {
			fieldNames = session.createSQLQuery(sql).list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		for (String fieldName : fieldNames) {
			System.out.println(fieldName);
		}
	}
	
}
