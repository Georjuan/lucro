package br.com.lucro.manager.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.dao.FileOperationResumeOutstandingBalanceCieloDAO;
import br.com.lucro.manager.model.FileOperationResumeOutstandingBalanceCielo;
import br.com.lucro.manager.model.FileOperationResumeOutstandingBalanceCielo_;

public class FileOperationResumeOutstandingBalanceCieloDAOImpl
		implements FileOperationResumeOutstandingBalanceCieloDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FileOperationResumeOutstandingBalanceCieloDAOImpl.class);
	
	@Inject
	private DAOManager dao;
	
	public FileOperationResumeOutstandingBalanceCieloDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FileOperationResumeOutstandingBalanceCielo create(FileOperationResumeOutstandingBalanceCielo outstandingBalance) throws Exception {
		dao.getEntityManager().persist(outstandingBalance);
		return outstandingBalance;
	}

	@Override
	public FileOperationResumeOutstandingBalanceCielo select(FileOperationResumeOutstandingBalanceCielo outstandingBalance) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileOperationResumeOutstandingBalanceCielo> query = criteria.createQuery(FileOperationResumeOutstandingBalanceCielo.class);
		
		Root<FileOperationResumeOutstandingBalanceCielo> root = query.from(FileOperationResumeOutstandingBalanceCielo.class);
		
		query.where(
			criteria.equal(root.get(FileOperationResumeOutstandingBalanceCielo_.operationResumeLotNumber), outstandingBalance.getOperationResumeLotNumber()),
			criteria.equal(root.get(FileOperationResumeOutstandingBalanceCielo_.operationResumeNumber), outstandingBalance.getOperationResumeNumber())
		);
		
		List<FileOperationResumeOutstandingBalanceCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0 ? headers.get(0) : null;
	}

	@Override
	public FileOperationResumeOutstandingBalanceCielo update(FileOperationResumeOutstandingBalanceCielo outstandingBalance)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileOperationResumeOutstandingBalanceCielo delete(FileOperationResumeOutstandingBalanceCielo outstandingBalance)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(FileOperationResumeOutstandingBalanceCielo outstandingBalance) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileOperationResumeOutstandingBalanceCielo> query = criteria.createQuery(FileOperationResumeOutstandingBalanceCielo.class);
		
		Root<FileOperationResumeOutstandingBalanceCielo> root = query.from(FileOperationResumeOutstandingBalanceCielo.class);
		
		query.where(
			criteria.equal(root.get(FileOperationResumeOutstandingBalanceCielo_.operationResumeLotNumber), outstandingBalance.getOperationResumeLotNumber()),
			criteria.equal(root.get(FileOperationResumeOutstandingBalanceCielo_.operationResumeNumber), outstandingBalance.getOperationResumeNumber())
		);
		
		List<FileOperationResumeOutstandingBalanceCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0;
	}

	@Override
	public List<FileOperationResumeOutstandingBalanceCielo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
