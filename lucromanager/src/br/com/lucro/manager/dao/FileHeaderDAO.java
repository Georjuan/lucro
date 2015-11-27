package br.com.lucro.manager.dao;

import javax.inject.Inject;

import br.com.lucro.manager.model.tivit.cielo.FileHeader;

public class FileHeaderDAO {

	@Inject
	private Dao dao;
	
	/**
	 * Save file header into data base
	 * @param fileHeader
	 * @throws Exception
	 */
	public void insert(FileHeader fileHeader) throws Exception{
		dao.getEntityManager().persist(fileHeader);
	}
	
}
