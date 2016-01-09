/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.UtilDAO;
import br.com.lucro.server.service.UtilService;

/**
 * @author taylor
 *
 */
@Service
public class UtilServiceImpl implements UtilService {

	@Autowired
	private UtilDAO dao;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.UtilService#getDBTime()
	 */
	@Override
	public Timestamp getDBTime() throws Exception {
		return dao.selectDBTime();
	}

}
