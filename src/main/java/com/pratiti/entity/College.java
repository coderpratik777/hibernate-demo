package com.pratiti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_college")
public class College {
	
	@Id
	@GeneratedValue
	private int collegId;
	
	private String collegeName;
	private String city;
	public int getCollegId() {
		return collegId;
	}
	public void setCollegId(int collegId) {
		this.collegId = collegId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
