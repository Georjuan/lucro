package br.com.lucro.manager.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import br.com.lucro.manager.dao.DAOManager;
import br.com.lucro.manager.dao.FileHeaderCieloDAO;
import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileHeaderCielo_;

/**
 * Persistence for Tivit/Cielo header file 
 * @author "Georjuan Taylor"
 */
public class FileHeaderCieloDAOImpl implements FileHeaderCieloDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FileHeaderCieloDAOImpl.class);
	
	@Inject
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#create(java.lang.fileHeader)
	 */
	@Override
	public FileHeaderCielo create(FileHeaderCielo fileHeader) throws Exception {
		dao.getEntityManager().persist(fileHeader);
		return fileHeader;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#select(java.lang.fileHeader)
	 */
	@Override
	public FileHeaderCielo select(FileHeaderCielo fileHeader) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileHeaderCielo> query = criteria.createQuery(FileHeaderCielo.class);
		
		Root<FileHeaderCielo> root = query.from(FileHeaderCielo.class);
		
		query.where(
			criteria.equal(root.get(FileHeaderCielo_.fileNumber), fileHeader.getFileNumber())
		);
		
		List<FileHeaderCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0 ? headers.get(0) : null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#update(java.lang.fileHeader)
	 */
	@Override
	public FileHeaderCielo update(FileHeaderCielo fileHeader) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#delete(java.lang.fileHeader)
	 */
	@Override
	public FileHeaderCielo delete(FileHeaderCielo fileHeader) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#exists(java.lang.fileHeader)
	 */
	@Override
	public boolean exists(FileHeaderCielo fileHeader) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileHeaderCielo> query = criteria.createQuery(FileHeaderCielo.class);
		
		Root<FileHeaderCielo> root = query.from(FileHeaderCielo.class);
		
		query.where(
			criteria.equal(root.get(FileHeaderCielo_.fileNumber), fileHeader.getFileNumber())
		);
		
		List<FileHeaderCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#selectAll()
	 */
	@Override
	public List<FileHeaderCielo> selectAll() throws Exception {
		return null;
	}	
	
	
}
