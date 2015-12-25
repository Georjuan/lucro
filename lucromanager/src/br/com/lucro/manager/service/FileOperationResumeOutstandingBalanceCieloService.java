package br.com.lucro.manager.service;

import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeOutstandingBalanceCielo;

/**
 * 
 * @author Georjuan Taylor
 *
 */
public interface FileOperationResumeOutstandingBalanceCieloService {
	
	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @return
	 * @throws Exception
	 */
	public FileOperationResumeOutstandingBalanceCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception;

}
