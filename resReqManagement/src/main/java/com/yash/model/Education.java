package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="education")
public class Education implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int educationDetailId;	
	
	private int employeeId;	
	
	private String qualification;	
	
	private String startDate;	
	
	private String endDate;	
	
	private String collegeName;	
	
	private int percentage;
	
	private String city;
	
	public Education() {
		System.out.println("education called...");
	}

	public Education(int educationDetailId, int employeeId, String qualification, String startDate, String endDate,
			String collegeName, int percentage, String city) {
		super();
		this.educationDetailId = educationDetailId;
		this.employeeId = employeeId;
		this.qualification = qualification;
		this.startDate = startDate;
		this.endDate = endDate;
		this.collegeName = collegeName;
		this.percentage = percentage;
		this.city = city;
	}

	public int getEducationDetailId() {
		return educationDetailId;
	}

	public void setEducationDetailId(int educationDetailId) {
		this.educationDetailId = educationDetailId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Education [educationDetailId=" + educationDetailId + ", employeeId=" + employeeId + ", qualification="
				+ qualification + ", startDate=" + startDate + ", endDate=" + endDate + ", collegeName=" + collegeName
				+ ", percentage=" + percentage + ", city=" + city + "]";
	}
	
	
}
