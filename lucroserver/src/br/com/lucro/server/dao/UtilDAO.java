/**
 * @author taylor
 */
package br.com.lucro.server.dao;

import java.sql.Timestamp;

/**
 * @author taylor
 *
 */
public interface UtilDAO {
	
	/**
	 * Obtain the actual time in data base
	 * @return
	 * @throws Exception
	 */
	Timestamp selectDBTime() throws Exception;

}
