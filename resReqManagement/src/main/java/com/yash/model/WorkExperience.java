package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workexperience")
public class WorkExperience implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int workExpId;
	
	private int employeeId;
	
	private String preCompanyName;
	
	private String startDate;
	
	private String endDate;
	
	private String designation;
	
	public WorkExperience() {
		System.out.println("work called...");
	}

	public WorkExperience(int workExpId, int employeeId, String preCompanyName, String startDate, String endDate,
			String designation) {
		super();
		this.workExpId = workExpId;
		this.employeeId = employeeId;
		this.preCompanyName = preCompanyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.designation = designation;
	}

	public int getWorkExpId() {
		return workExpId;
	}

	public void setWorkExpId(int workExpId) {
		this.workExpId = workExpId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPreCompanyName() {
		return preCompanyName;
	}

	public void setPreCompanyName(String preCompanyName) {
		this.preCompanyName = preCompanyName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "WorkExperience [workExpId=" + workExpId + ", employeeId=" + employeeId + ", preCompanyName="
				+ preCompanyName + ", startDate=" + startDate + ", endDate=" + endDate + ", designation=" + designation
				+ "]";
	}
	
	

}
