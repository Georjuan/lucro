/**
 * @author taylor
 */
package br.com.lucro.server.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.UtilDAO;

/**
 * @author taylor
 *
 */
@Repository
public class UtilDAOImpl implements UtilDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ReportDAOImpl.class);
	
	@Autowired
	private DAOManager dao;	

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.UtilDAO#selectDBTime()
	 */
	@Override
	public Timestamp selectDBTime() throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		//Get query
		Query query = entityManager.createNativeQuery("SELECT CLOCK_TIMESTAMP()");
		
		//Run query
		Timestamp timestamp = (Timestamp) query.getSingleResult();
		
		return timestamp;
	}

}
