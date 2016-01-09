/**
 * @author taylor
 */
package br.com.lucro.server.dao;

import br.com.lucro.server.model.Authentication;

/**
 * @author taylor
 *
 */
public interface AuthenticationManagerDAO {
	
	/**
	 * Login user
	 * @param auth
	 * @return
	 * @throws Exception
	 */
	Authentication selectUserByLogin(Authentication auth) throws Exception;
	
	/**
	 * Session authentication
	 * @param auth
	 * @return
	 * @throws Exception
	 */
	Authentication selectUserBySession(Authentication auth) throws Exception;

}
