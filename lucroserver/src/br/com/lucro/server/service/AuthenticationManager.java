/**
 * 
 */
package br.com.lucro.server.service;

import br.com.lucro.server.model.Authentication;

/**
 * Manager authentication process interface
 * @author Georjuan Taylor
 */
public interface AuthenticationManager {
	
	/** Authenticate a web request */
	public boolean webAuthentication(Authentication auth) throws Exception;
	
	/** Authenticate a web request */
	public boolean webAuthentication(String authorization) throws Exception;
	
}
