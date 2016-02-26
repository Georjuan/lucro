/**
 * @author taylor
 */
package br.com.lucro.server.service;

import br.com.lucro.server.model.CompanyAcquirer;
import br.com.lucro.server.model.WebResponseException;

/**
 * @author taylor
 *
 */
public interface CompanyAcquirerService {

	/**
	 * Create a new acquirer
	 * @param companyAcquirer
	 * @return
	 * @throws WebResponseException
	 * @throws Exception
	 */
	CompanyAcquirer saveAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception;
	
	/**
	 * Remove an acquirer
	 * @param companyAcquirer
	 * @return
	 * @throws WebResponseException
	 * @throws Exception
	 */
	CompanyAcquirer deleteAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception;
	
	/**
	 * Update an acquirer data
	 * @param companyAcquirer
	 * @return
	 * @throws WebResponseException
	 * @throws Exception
	 */
	CompanyAcquirer updateAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception;
	
}
