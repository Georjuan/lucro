/**
 * 
 */
package br.com.lucro.manager.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.dao.FileSalesReceiptCieloDAO;
import br.com.lucro.manager.model.FileSalesReceiptCielo;
import br.com.lucro.manager.model.FileSalesReceiptCielo_;

/**
 * @author "Georjuan Taylor"
 *
 */
public class FileSalesReceiptCieloDAOImpl implements FileSalesReceiptCieloDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileSalesReceiptCieloDAOImpl.class);
	
	@Inject
	private DAOManager dao;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#create(java.lang.salesReceipt)
	 */
	@Override
	public FileSalesReceiptCielo create(FileSalesReceiptCielo salesReceipt) throws Exception {
		dao.getEntityManager().persist(salesReceipt);
		return salesReceipt;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#select(java.lang.salesReceipt)
	 */
	@Override
	public FileSalesReceiptCielo select(FileSalesReceiptCielo salesReceipt) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileSalesReceiptCielo> query = criteria.createQuery(FileSalesReceiptCielo.class);
		
		Root<FileSalesReceiptCielo> root = query.from(FileSalesReceiptCielo.class);
		
		query.where(
			criteria.equal(root.get(FileSalesReceiptCielo_.transactionNumber), salesReceipt.getTransactionNumber())
		);
		
		List<FileSalesReceiptCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0 ? headers.get(0) : null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#update(java.lang.salesReceipt)
	 */
	@Override
	public FileSalesReceiptCielo update(FileSalesReceiptCielo salesReceipt)
			throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#delete(java.lang.salesReceipt)
	 */
	@Override
	public FileSalesReceiptCielo delete(FileSalesReceiptCielo salesReceipt)
			throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#exists(java.lang.salesReceipt)
	 */
	@Override
	public boolean exists(FileSalesReceiptCielo salesReceipt) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileSalesReceiptCielo> query = criteria.createQuery(FileSalesReceiptCielo.class);
		
		Root<FileSalesReceiptCielo> root = query.from(FileSalesReceiptCielo.class);
		
		query.where(
			criteria.equal(root.get(FileSalesReceiptCielo_.transactionNumber), salesReceipt.getTransactionNumber())
		);
		
		List<FileSalesReceiptCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#selectAll()
	 */
	@Override
	public List<FileSalesReceiptCielo> selectAll() throws Exception {
		return null;
	}

}
