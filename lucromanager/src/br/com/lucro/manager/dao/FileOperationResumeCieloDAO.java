/**
 * 
 */
package br.com.lucro.manager.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.manager.model.FileOperationResumeCielo;
import br.com.lucro.manager.model.FileOperationResumeCielo_;

/**
 * @author "Georjuan Taylor"
 *
 */
public class FileOperationResumeCieloDAO implements CRUD<FileOperationResumeCielo> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileOperationResumeCieloDAO.class);
	
	@Inject
	private DAOManager dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#create(java.lang.Object)
	 */
	@Override
	public FileOperationResumeCielo create(FileOperationResumeCielo operationResume) throws Exception {
		dao.getEntityManager().persist(operationResume);
		return operationResume;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#select(java.lang.Object)
	 */
	@Override
	public FileOperationResumeCielo select(FileOperationResumeCielo object)
			throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#update(java.lang.Object)
	 */
	@Override
	public FileOperationResumeCielo update(FileOperationResumeCielo object)
			throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#delete(java.lang.Object)
	 */
	@Override
	public FileOperationResumeCielo delete(FileOperationResumeCielo object)
			throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#exists(java.lang.Object)
	 */
	@Override
	public boolean exists(FileOperationResumeCielo operationResume) throws Exception {
		CriteriaBuilder criteria = dao.getEntityManager().getCriteriaBuilder();		
		CriteriaQuery<FileOperationResumeCielo> query = criteria.createQuery(FileOperationResumeCielo.class);
		
		Root<FileOperationResumeCielo> root = query.from(FileOperationResumeCielo.class);
		
		query.where(
			criteria.equal(root.get(FileOperationResumeCielo_.financialOperationNumber), operationResume.getOperationResumeNumber())
		);
		
		List<FileOperationResumeCielo> headers = dao.getEntityManager().createQuery(query).getResultList();
		
		return headers.size() > 0;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.manager.dao.CRUD#selectAll()
	 */
	@Override
	public List<FileOperationResumeCielo> selectAll() throws Exception {
		return null;
	}

}
