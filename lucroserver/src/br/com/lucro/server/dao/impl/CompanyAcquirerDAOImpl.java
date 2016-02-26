/**
 * @author taylor
 */
package br.com.lucro.server.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.CompanyAcquirerDAO;
import br.com.lucro.server.model.CompanyAcquirer;

/**
 * @author taylor
 *
 */
@Repository
public class CompanyAcquirerDAOImpl implements CompanyAcquirerDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CompanyAcquirerDAOImpl.class);
	
	@Autowired
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#create(java.lang.Object)
	 */
	@Override
	public CompanyAcquirer create(CompanyAcquirer acquirer) throws Exception {
		dao.beginTransaction();
		dao.getEntityManager().persist(acquirer);
		dao.commitTransaction();
		return acquirer;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#select(java.lang.Object)
	 */
	@Override
	public CompanyAcquirer select(CompanyAcquirer acquirer) throws Exception {	
		CompanyAcquirer companyAcquirer = dao.getEntityManager().find(CompanyAcquirer.class, acquirer.getId());		
		return companyAcquirer;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#update(java.lang.Object)
	 */
	@Override
	public CompanyAcquirer update(CompanyAcquirer acquirer) throws Exception {
		dao.beginTransaction();		
		CompanyAcquirer mergedAcquirer = dao.getEntityManager().merge(acquirer);		
		dao.commitTransaction();		
		return mergedAcquirer;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#delete(java.lang.Object)
	 */
	@Override
	public CompanyAcquirer delete(CompanyAcquirer acquirer) throws Exception {
		dao.beginTransaction();
		
		acquirer = select(acquirer);
		
		dao.getEntityManager().remove(acquirer);
		
		dao.commitTransaction();
		return acquirer;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#exists(java.lang.Object)
	 */
	@Override
	public boolean exists(CompanyAcquirer object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#selectAll()
	 */
	@Override
	public List<CompanyAcquirer> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
