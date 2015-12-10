/**
 * 
 */
package br.com.lucro.manager.service;

/**
 * @author "Georjuan Taylor"
 *
 * Process files received from Tivit/Cielo
 * <br/> Read the files content
 * <br/> Format data
 * <br/> Save data into database
 * 
 */
public interface FileCieloService {
	
	/**
	 * @param path - Path to directory where are the Cielo files
	 * @throws Exception
	 */
	void setPath(String path) throws Exception;
	
	/**
	 * Read files and save in database
	 * @throws Exception
	 */
	void processFiles() throws Exception;
	
}
