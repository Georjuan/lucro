/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.UserDAO;
import br.com.lucro.server.model.User;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.UserService;
import br.com.lucro.server.util.MailUtils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author taylor
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.UserService#getUser(br.com.lucro.server.model.User)
	 */
	@Override
	public User getUser(User user) throws WebResponseException, Exception {
		
		if(!MailUtils.isValid(user.getUserName()))
			throw new WebResponseException("Email inválido", EnumWebResponse.INVALID_PARAM);
		
		return userDAO.select(user);
	}

}
