package br.com.lucro.manager.dao;

import java.io.Serializable;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DAOManager implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private static EntityManager entityManager = null;
	private static EntityManagerFactory entityManagerFactory = null; 
	
	private static final Logger logger = LoggerFactory.getLogger(DAOManager.class);
	
	private static void createManager(){		
		try{
			entityManagerFactory = Persistence.createEntityManagerFactory("lucromanager");		
			entityManager = entityManagerFactory.createEntityManager();
		}catch(Exception e){			
			entityManager = null;
			logger.error(e.getMessage(), e);
		}
	}
	
	public EntityManager getEntityManager(){
		if(entityManager == null) createManager();
		return entityManager;
	}
	
	public void beginTransaction(){
		getEntityManager().getTransaction().begin();
	}
	
	public void commitTransaction(){
		getEntityManager().getTransaction().commit();
	}
	
	public void rollbackTransaction(){
		getEntityManager().getTransaction().rollback();
	}
	
	public void close(){
		getEntityManager().close();
		entityManagerFactory.close();
	}
}
