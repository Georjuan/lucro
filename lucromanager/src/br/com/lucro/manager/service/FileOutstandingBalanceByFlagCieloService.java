package br.com.lucro.manager.service;

import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileOutstandingBalanceByFlagCielo;

public interface FileOutstandingBalanceByFlagCieloService {

	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @return
	 * @throws Exception
	 */
	public FileOutstandingBalanceByFlagCielo processOperation(String line, FileHeaderCielo fileHeaderCielo) throws Exception;
	
}
