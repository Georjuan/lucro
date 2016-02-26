/**
 * 
 */
package br.com.lucro.server.service;

import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.WebResponseException;

/**
 * Manager company process
 * @author Georjuan Taylor
 */
public interface CompanyService {
	
	/** Create a new company enrollment */
	public Company saveCompany(Company company) throws WebResponseException, Exception;
	
}
