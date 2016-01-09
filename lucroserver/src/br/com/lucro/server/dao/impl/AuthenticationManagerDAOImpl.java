/**
 * @author taylor
 */
package br.com.lucro.server.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.AuthenticationManagerDAO;
import br.com.lucro.server.model.Authentication;

/**
 * @author taylor
 *
 */
@Repository
public class AuthenticationManagerDAOImpl implements AuthenticationManagerDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AuthenticationManagerDAOImpl.class);
	
	@Autowired
	private DAOManager dao;	
	
	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.AuthenticationManagerDAO#selectUserByLogin(br.com.lucro.server.model.Authentication)
	 */
	@Override
	public Authentication selectUserByLogin(Authentication auth) throws Exception {
		//TODO: Disable log for username and password login
		
		EntityManager entityManager = dao.getEntityManager();
		
		//Get query
		Query query = entityManager.createNativeQuery("SELECT username\\:\\:TEXT, session\\:\\:TEXT, access\\:\\:TEXT "
														+ "FROM security_user_login(:username, :password);", Authentication.class);
		
		query.setParameter("username", auth.getUsername());
		query.setParameter("password", auth.getPassword());
		
		Authentication authentication = null;
		try{			
			authentication = (Authentication) query.getSingleResult();
			
			//Get query select session hash
			query = entityManager.createNativeQuery("SELECT hash\\:\\:TEXT AS session FROM \"user\" WHERE username = :username");
			
			//Set user filter
			query.setParameter("username", auth.getUsername());
			
			//Get session hash
			Object session = query.getSingleResult();
			
			//Set session hash
			authentication.setSession(session.toString());
			
		}catch(NoResultException e){}
		
		return authentication;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.AuthenticationManagerDAO#selectUserBySession(br.com.lucro.server.model.Authentication)
	 */
	@Override
	public Authentication selectUserBySession(Authentication auth) throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		//Get query
		Query query = entityManager.createNativeQuery("SELECT 1\\:\\:INTEGER FROM \"user\" "
														+ "WHERE username = :username \\:\\:CHARACTER VARYING "
														+ "AND hash = :session \\:\\:CHARACTER VARYING");
		
		//Set parameters
		query.setParameter("username", auth.getUsername());
		query.setParameter("session", auth.getPassword());
		
		//Run query
		try{			
			auth = query.getSingleResult() != null ? auth : null;
		}catch(NoResultException e){
			auth = null;
		}
		
		return auth;
	}	

}
