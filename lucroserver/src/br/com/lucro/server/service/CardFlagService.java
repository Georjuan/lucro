/**
 * @author taylor
 */
package br.com.lucro.server.service;

import java.util.List;

import br.com.lucro.server.model.CardFlag;

/**
 * @author taylor
 *
 */
public interface CardFlagService {
	
	/**
	 * Get all card flags
	 * @return
	 * @throws Exception
	 */
	List<CardFlag> getAllFlags() throws Exception;

}
