/**
 * 
 */
package br.com.lucro.server.service;

import br.com.lucro.server.model.Authentication;

/**
 * Manager authentication process interface
 * @author Georjuan Taylor
 */
public interface AuthenticationService {
	
	/** Authenticate a web request */
	public Authentication auth(Authentication auth) throws Exception;
	
}
