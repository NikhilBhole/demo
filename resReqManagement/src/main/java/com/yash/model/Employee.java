package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private long phoneNumber;
	
	private String userName;
	
	private String password;
	
	private boolean deleted;

	public Employee() {
		System.out.println("employee called...");
	}

	public Employee(int employeeId, String firstName, String lastName, String designation, long phoneNumber,
			String userName, String password, boolean deleted) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.deleted = deleted;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", phoneNumber=" + phoneNumber + ", userName=" + userName
				+ ", password=" + password + ", deleted=" + deleted + "]";
	}
	
	
}
