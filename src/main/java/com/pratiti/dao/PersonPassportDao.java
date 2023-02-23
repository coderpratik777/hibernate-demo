package com.pratiti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Passport;
import com.pratiti.entity.Person;

public class PersonPassportDao {
	
	public void add(Person person) {
		EntityManagerFactory emf=null;
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
			em.persist(person);//persist will generate insert query
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	public void add(Passport passport) {
		EntityManagerFactory emf=null;
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
			em.persist(passport);//persist will generate insert query
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	public Person fetchPerson(int id ) {
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			em=emf.createEntityManager();
			Person person=em.find(Person.class, id);
			return  person;
		}
		finally {
			emf.close();
		}
		
	}
}
