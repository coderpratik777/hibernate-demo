package com.pratiti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pratiti.entity.Product;

//Data Access Object
//classs which contains db communication code are commonly reffered to as dao

public class ProductDao {
	
	public void add(Product product) {
		EntityManagerFactory emf=null;
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
			em.persist(product);//persist will generate insert query
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	
	public Product fetch(int id ) {
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			em=emf.createEntityManager();
			Product product=em.find(Product.class, id);
			return  product;
		}
		finally {
			emf.close();
		}
		
	}
	
	public List<Product> fetchAll(){
		EntityManagerFactory emf=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			Query q=em.createQuery("select p from Product p");//the query given is hql/jpql
			
			return q.getResultList();
		}
		finally {
			emf.close();
		}
	}
	
	public List<Product> fetchByPrice(double price){
		EntityManagerFactory emf=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			Query q=em.createQuery("select p from Product p where p.price>=:pr");//the query given is hql/jpql
			q.setParameter("pr", price);
			
			return q.getResultList();
		}
		finally {
			emf.close();
		}
	}
	
	public List<Product> fetchByName(String name){
		EntityManagerFactory emf=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			Query q=em.createQuery("select p from Product p where p.name like :nm");//the query given is hql/jpql
			q.setParameter("nm","%"+name+"%");
			
			return q.getResultList();
		}
		finally {
			emf.close();
		}
	}
	
	public void update(Product product) {
		EntityManagerFactory emf=null;
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(product);//merge will generate update query
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	public void deleteById(int id) {
		EntityManagerFactory emf=null;
		try {
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
			Product p=em.find(Product.class,id);
			if(p!=null)
				em.remove(p);
			
			
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	
	

}
