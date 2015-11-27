package br.com.lucro.manager.dao;

import java.io.Serializable;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class Dao implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private static EntityManager entityManager = null;
	
	private static final Logger logger = LoggerFactory.getLogger(Dao.class);
	
	private static void createManager(){		
		try{
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lucromanager");		
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
	
}
