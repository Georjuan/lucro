/**
 * 
 */
package br.com.lucro.manager.service;

import br.com.lucro.manager.model.FileHeaderCielo;
import br.com.lucro.manager.model.FileSalesReceiptCielo;

/**
 * @author "Georjuan Taylor"
 *
 */
public interface FileSalesReceiptCieloService {
	
	/**
	 * Read line data, format and save data into data base
	 * @param line
	 * @throws Exception
	 */
	public FileSalesReceiptCielo processReceipt(String line, FileHeaderCielo fileHeaderCielo) throws Exception;

}
