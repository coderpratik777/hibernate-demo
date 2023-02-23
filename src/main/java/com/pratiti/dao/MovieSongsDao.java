package com.pratiti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Movie;
import com.pratiti.entity.Song;

public class MovieSongsDao {
	
	public void save(Object obj) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);//persist will generate insert query
			
			em.getTransaction().commit();
		}
		finally {
			
			emf.close();
		}
	}
	public Object fetchData(Class className,int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
		    Object obj= em.find(className, id);
			return obj;
		} finally {
			emf.close();
		}

	}
	
	//same method using the generics 
	public <E>E fetchDataVersion(Class<E> className,int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
		    return em.find(className, id);
		} finally {
			emf.close();
		}

	}
	
	public List<Song> fetchSongsSungBy(String artist){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em = emf.createEntityManager();
		
		try {

			String query = "select s from Song s join  where s.artist=:art";
			Query q = em.createQuery(query);
			q.setParameter("art", artist);
			List<Song> list = q.getResultList();
			return list;

		} finally {
			emf.close();
		}
		
	}
	
	
	public List<Object[]> fetchAlbumsByArtist(String artist){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em = emf.createEntityManager();
		
		try {

			String query = "select m,s.title from Movie m join m.songs s where s.artist=:art";
			Query q = em.createQuery(query);
			q.setParameter("art", artist);
			List<Object[]> list = q.getResultList();
			return list;

		} finally {
			emf.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
