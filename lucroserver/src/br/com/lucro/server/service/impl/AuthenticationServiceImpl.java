/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.AuthenticationManagerDAO;
import br.com.lucro.server.model.Authentication;
import br.com.lucro.server.model.Authentication.EnumAccessType;
import br.com.lucro.server.service.AuthenticationService;

/**
 * @author taylor
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManagerDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.AuthenticationManager#webAuthentication(br.com.lucro.server.model.Authentication)
	 */
	@Override
	public Authentication auth(Authentication auth) throws Exception {
		Authentication authentication = null;
		
		if(auth.getAccess().equals(EnumAccessType.LOGIN)){
			
			authentication = dao.selectUserByLogin(auth);
			
		}else if(auth.getAccess().equals(EnumAccessType.SESSION)){
			
			authentication = dao.selectUserBySession(auth);
			
		}
		
		return authentication;
	}

}
