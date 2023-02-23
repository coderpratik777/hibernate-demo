package com.pratiti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pratiti.entity.Address;
import com.pratiti.entity.Customer;
import com.pratiti.entity.Product;

public class CustomerAddressDao {

	public void add(Customer customer) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(customer);// persist will generate insert query

			em.getTransaction().commit();
		} finally {

			emf.close();
		}
	}

	public void add(Address address) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(address);// persist will generate insert query

			em.getTransaction().commit();
		} finally {

			emf.close();
		}
	}

	public Customer fetchCustomer(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
			Customer customer = em.find(Customer.class, id);
			return customer;
		} finally {
			emf.close();
		}

	}

	public Address fetchAddress(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
			Address address = em.find(Address.class, id);
			return address;
		} finally {
			emf.close();
		}

	}

	public void update(Customer customer) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.merge(customer);// merge will generate update query

			em.getTransaction().commit();
		} finally {

			emf.close();
		}
	}

	public List<Customer> fetchCustomerByCity(String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em = emf.createEntityManager();

		try {

			String query = "select c from Customer c join c.address a where a.city=:ct";
			Query q = em.createQuery(query);
			q.setParameter("ct", city);
			List<Customer> list = q.getResultList();
			return list;

		} finally {
			emf.close();
		}

	}

	public List<Object[]> fetchCustomerInfo(String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em = emf.createEntityManager();

		try {

			String query = "select c.name, c.dateOfBirth,a.city from Customer c join c.address a where a.city=:ct";
			Query q = em.createQuery(query);
			q.setParameter("ct", city);
			List<Object[]> list = q.getResultList();
			return list;

		} finally {
			emf.close();
		}

	}
	

}
