package com.pratiti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String contactNumber;
	private String email;
	
	@OneToOne
	@JoinColumn(name="collegeId")
	private College collegeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public College getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(College collegeId) {
		this.collegeId = collegeId;
	}
	

}
