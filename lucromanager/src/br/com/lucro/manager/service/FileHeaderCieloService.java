/**
 * 
 */
package br.com.lucro.manager.service;

import br.com.lucro.manager.model.FileHeaderCielo;

/**
 * @author "Georjuan Taylor"
 *
 */
public interface FileHeaderCieloService {
	
	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @throws Exception
	 */
	public FileHeaderCielo processHeader(String line) throws Exception;

}
