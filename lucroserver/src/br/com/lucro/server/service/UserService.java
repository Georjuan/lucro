/**
 * @author taylor
 */
package br.com.lucro.server.service;

import br.com.lucro.server.model.User;
import br.com.lucro.server.model.WebResponseException;

/**
 * @author taylor
 *
 */
public interface UserService {

	/**
	 * Select an user by his username
	 * @param user
	 * @return
	 * @throws WebResponseException
	 * @throws Exception
	 */
	User getUser(User user) throws WebResponseException, Exception;
	
}
