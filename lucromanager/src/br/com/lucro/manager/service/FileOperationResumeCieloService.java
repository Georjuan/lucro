/**
 * 
 */
package br.com.lucro.manager.service;

import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOperationResumeCielo;

/**
 * @author "Georjuan Taylor"
 *
 */
public interface FileOperationResumeCieloService {

	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @return
	 * @throws Exception
	 */
	public FileOperationResumeCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception;
	
}
