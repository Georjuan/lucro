package br.com.lucro.manager.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileHeaderCielo_;

/**
 * Persistence for Tivit/Cielo header file 
 * @author "Georjuan Taylor"
 */
public class FileHeaderCieloDAO implements CRUD<FileHeaderCielo> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileHeaderCieloDAO.class);
	
	@Inject
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#create(java.lang.Object)
	 */
	@Override
	public FileHeaderCielo create(FileHeaderCielo fileHeader) throws Exception {
		dao.getEntityManager().persist(fileHeader);
		return fileHeader;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#select(java.lang.Object)
	 */
	@Override
	public FileHeaderCielo select(FileHeaderCielo object) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#update(java.lang.Object)
	 */
	@Override
	public FileHeaderCielo update(FileHeaderCielo fileHeader) throws Exception {
		dao.getEntityManager().merge(fileHeader);
		return fileHeader;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#delete(java.lang.Object)
	 */
	@Override
	public FileHeaderCielo delete(FileHeaderCielo object) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#exists(java.lang.Object)
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
