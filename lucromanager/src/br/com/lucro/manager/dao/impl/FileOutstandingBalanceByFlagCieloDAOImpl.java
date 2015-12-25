package br.com.lucro.manager.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.dao.FileOutstandingBalanceByFlagCieloDAO;
import br.com.lucro.manager.model.FileOutstandingBalanceByFlagCielo;
import br.com.lucro.manager.model.FileOutstandingBalanceByFlagCielo_;

/**
 * @author Georjuan Taylor
 *
 */
public class FileOutstandingBalanceByFlagCieloDAOImpl implements FileOutstandingBalanceByFlagCieloDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FileOutstandingBalanceByFlagCieloDAOImpl.class);
	
	@Inject
	private DAOManager dao;
	
	@Override
	public FileOutstandingBalanceByFlagCielo create(FileOutstandingBalanceByFlagCielo outstandingBalance) throws Exception {
		dao.getEntityManager().persist(outstandingBalance);
		return outstandingBalance;
	}

	@Override
	public FileOutstandingBalanceByFlagCielo select(FileOutstandingBalanceByFlagCielo outstandingBalance) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileOutstandingBalanceByFlagCielo> query = criteria.createQuery(FileOutstandingBalanceByFlagCielo.class);
		
		Root<FileOutstandingBalanceByFlagCielo> root = query.from(FileOutstandingBalanceByFlagCielo.class);
		
		query.where(
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.referenceDate), outstandingBalance.getReferenceDate()),
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.platformType), outstandingBalance.getPlatformType()),
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.cardFlagId), outstandingBalance.getCardFlagId())
		);
		
		List<FileOutstandingBalanceByFlagCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0 ? headers.get(0) : null;
	}

	@Override
	public FileOutstandingBalanceByFlagCielo update(FileOutstandingBalanceByFlagCielo object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileOutstandingBalanceByFlagCielo delete(FileOutstandingBalanceByFlagCielo object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(FileOutstandingBalanceByFlagCielo outstandingBalance) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileOutstandingBalanceByFlagCielo> query = criteria.createQuery(FileOutstandingBalanceByFlagCielo.class);
		
		Root<FileOutstandingBalanceByFlagCielo> root = query.from(FileOutstandingBalanceByFlagCielo.class);
		
		query.where(
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.referenceDate), outstandingBalance.getReferenceDate()),
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.platformType), outstandingBalance.getPlatformType()),
			criteria.equal(root.get(FileOutstandingBalanceByFlagCielo_.cardFlagId), outstandingBalance.getCardFlagId())
		);
		
		List<FileOutstandingBalanceByFlagCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0;
	}

	@Override
	public List<FileOutstandingBalanceByFlagCielo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
