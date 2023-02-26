package com.pratiti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_generator")
	@SequenceGenerator(name="seq_generator",sequenceName = "employee_seq",allocationSize = 1)
	private int id;
	
	@Column(name="First_name")
	private String firstName;
	
	@Column(name = "Last_name")
	private String lastName;
	
	private double salary;
	
	
	//transient annotation is used to specify the field to not persisted
	//it is only use in this class for our purpose
	@Transient
	private String fullName;
	 
	
	//getter and setters

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	//transient field specify the function to intialize it
	
	public String getFullName() {
		this.fullName=setFullName();
		return this.fullName;
	}
	
	public String setFullName() {
		return this.firstName+" "+this.lastName;
	}
	
}
