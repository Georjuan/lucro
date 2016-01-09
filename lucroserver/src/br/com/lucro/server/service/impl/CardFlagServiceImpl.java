/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.CardFlagDAO;
import br.com.lucro.server.model.CardFlag;
import br.com.lucro.server.service.CardFlagService;

/**
 * @author taylor
 *
 */
@Service
public class CardFlagServiceImpl implements CardFlagService {

	@Autowired
	private CardFlagDAO cardFlagDAO;	

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.CardFlagService#getAllFlags()
	 */
	@Override
	public List<CardFlag> getAllFlags() throws Exception {
		return cardFlagDAO.selectAll();
	}

}
