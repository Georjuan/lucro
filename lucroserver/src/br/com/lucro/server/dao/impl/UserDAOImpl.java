/**
 * @author taylor
 */
package br.com.lucro.server.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.UserDAO;
import br.com.lucro.server.model.User;

/**
 * @author taylor
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CompanyDAOImpl.class);
	
	@Autowired
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#create(java.lang.Object)
	 */
	@Override
	public User create(User object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#select(java.lang.Object)
	 */
	@Override
	public User select(User user) throws Exception {
		Query query = dao.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userName = :username", User.class);
		
		query.setParameter("username", user.getUserName());
		
		try{			
			user = (User) query.getSingleResult();
			return user;
		}catch(NoResultException e){
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#update(java.lang.Object)
	 */
	@Override
	public User update(User object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#delete(java.lang.Object)
	 */
	@Override
	public User delete(User object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#exists(java.lang.Object)
	 */
	@Override
	public boolean exists(User object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#selectAll()
	 */
	@Override
	public List<User> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
