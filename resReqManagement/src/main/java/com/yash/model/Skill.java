package com.yash.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skillId", nullable=false)
	private int skillId;
	
	private int employeeId;
	
	private String skillName;
	
	public Skill() {
		System.out.println("skill called...");
	}

	public Skill(int skillId, int employeeId, String skillName) {
		super();
		this.skillId = skillId;
		this.employeeId = employeeId;
		this.skillName = skillName;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", employeeId=" + employeeId + ", skillName=" + skillName + "]";
	}
	
	
}
