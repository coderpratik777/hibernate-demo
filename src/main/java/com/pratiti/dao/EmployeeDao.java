package com.pratiti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Employee;

public class EmployeeDao {
	
	public void add(Employee employee) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(employee);// persist will generate insert query

			em.getTransaction().commit();
		} finally {

			emf.close();
		}
	}
	
	public Employee find(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
			Employee employee = em.find(Employee.class, id);
			return employee;
		} finally {
			emf.close();
		}
		
	}

}
