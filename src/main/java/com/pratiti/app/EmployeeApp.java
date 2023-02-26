package com.pratiti.app;

import com.pratiti.dao.EmployeeDao;
import com.pratiti.entity.Employee;

public class EmployeeApp {
	
	public static void main(String[] args) {
		
		EmployeeDao empDao=new EmployeeDao();
		
		Employee emp=new Employee();
		emp.setFirstName("Sarthak");
		emp.setLastName("Pawar");
		emp.setSalary(40000);
		
		empDao.add(emp);
		
		Employee emp1=empDao.find(1);
		System.out.println(emp1.getFullName());
		
		
	}

}
