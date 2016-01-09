package br.com.lucro.server.dao.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.lucro.server.util.Properties;

@Component
public class DAOManager implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private static EntityManager entityManager = null;
	private static EntityManagerFactory entityManagerFactory = null; 
	
	private static final Logger logger = Logger.getLogger(DAOManager.class);
	
	@PostConstruct
	private void init(){
		logger.info("DAOManager created!");
	}
	
	@Bean
	public EntityManager getEntityManager(){
		if(entityManager == null) createManager();
		return entityManager;
	}
	
	private static void createManager(){		
		try{
			entityManagerFactory = Persistence.createEntityManagerFactory(Properties.getProperty(Properties.JPA_ENTITY_NAME, "lucroserver"));		
			entityManager = entityManagerFactory.createEntityManager();
		}catch(Exception e){			
			entityManager = null;
			logger.error(e.getMessage(), e);
		}
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
		//Close connection
		getEntityManager().close();
		entityManagerFactory.close();
		//Delete object connection
		entityManager = null;
		entityManagerFactory = null;
	}
}
