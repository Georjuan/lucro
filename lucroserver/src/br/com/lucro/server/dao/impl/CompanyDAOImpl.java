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

import br.com.lucro.server.dao.CompanyDAO;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.User;

/**
 * @author taylor
 *
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CompanyDAOImpl.class);
	
	@Autowired
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#create(java.lang.Object)
	 */
	@Override
	public Company create(Company company) throws Exception {
		//FIXME: arrumar essa bagunça
		
		//Start transaction
		dao.beginTransaction();
		
		//Save user and company
		dao.getEntityManager().persist(company);
		
		//Commit
		dao.commitTransaction();
		
		//Start transaction
		dao.beginTransaction();
				
		//Set password hash
		User user = company.getUser();
		
		Query query = dao.getEntityManager().createNativeQuery("UPDATE \"user\" SET password = CRYPT(:password, gen_salt('bf', 8)) WHERE id = :id");
		
		query.setParameter("password", user.getPassword());
		query.setParameter("id", user.getId());
		
		query.executeUpdate();
		
		//Commit
		dao.commitTransaction();
		
		return company;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#select(java.lang.Object)
	 */
	@Override
	public Company select(Company company) throws Exception {		
		Query query = dao.getEntityManager().createQuery("SELECT u FROM Company u WHERE u.cnpj = :cnpj", Company.class);
		
		query.setParameter("cnpj", company.getCnpj());
		
		try{			
			company = (Company) query.getSingleResult();
			return company;
		}catch(NoResultException e){
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#update(java.lang.Object)
	 */
	@Override
	public Company update(Company object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#delete(java.lang.Object)
	 */
	@Override
	public Company delete(Company object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#exists(java.lang.Object)
	 */
	@Override
	public boolean exists(Company object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.CRUD#selectAll()
	 */
	@Override
	public List<Company> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
