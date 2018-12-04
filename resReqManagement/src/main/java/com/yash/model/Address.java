package com.yash.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	
	private int employeeId;	
	
	private String addressLine1;	
	
	private String addressLine2;	
	
	private String country;	
	
	private String state;	
	
	private String city;	
	
	private int pincode;
	
	public Address() {
		System.out.println("address called...");
	}

	public Address(int addressId, int employeeId, String addressLine1, String addressLine2, String country,
			String state, String city, int pincode) {
		super();
		this.addressId = addressId;
		this.employeeId = employeeId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", employeeId=" + employeeId + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	
	
}
