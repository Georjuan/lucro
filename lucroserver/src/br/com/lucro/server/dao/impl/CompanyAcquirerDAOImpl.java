/**
 * @author taylor
 */
package br.com.lucro.server.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.CompanyAcquirerDAO;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.CompanyAcquirer;

/**
 * @author taylor
 *
 */
@Repository
public class CompanyAcquirerDAOImpl implements CompanyAcquirerDAO {

	private static final Logger logger = Logger.getLogger(CompanyAcquirerDAOImpl.class);
	
	@Autowired
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CompanyAcquirerDAO#selectByCompany(br.com.lucro.server.model.Company)
	 */
	@Override
	public List<CompanyAcquirer> selectByCompany(Company company) throws Exception {		
		EntityManager entityManager = dao.getEntityManager();
		
		Query query = entityManager.createNativeQuery("SELECT * FROM rel_company_acquirer WHERE company_id = :company", CompanyAcquirer.class);
		
		query.setParameter("company", company.getId());
		
		List<?> result = query.getResultList();
		
		List<CompanyAcquirer> acquirers = result.stream().map(item -> (CompanyAcquirer)item).collect(Collectors.toList()); 
		
		return acquirers;
	}

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
logger.info("Z");
		dao.beginTransaction();
logger.info("X");
		CompanyAcquirer mergedAcquirer = dao.getEntityManager().merge(acquirer);
logger.info("Y");
		dao.commitTransaction();
logger.info("P");
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
