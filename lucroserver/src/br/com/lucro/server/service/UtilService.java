/**
 * @author taylor
 */
package br.com.lucro.server.service;

import java.sql.Timestamp;

/**
 * @author taylor
 *
 */
public interface UtilService {
	
	/**
	 * Obtain the actual time in data base
	 * @return
	 * @throws Exception
	 */
	Timestamp getDBTime() throws Exception;

}
