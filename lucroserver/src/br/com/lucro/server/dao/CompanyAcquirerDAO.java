/**
 * @author taylor
 */
package br.com.lucro.server.dao;

import java.util.List;

import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.CompanyAcquirer;

/**
 * @author taylor
 *
 */
public interface CompanyAcquirerDAO extends CRUD<CompanyAcquirer> {

	List<CompanyAcquirer> selectByCompany(Company company) throws Exception;
	
}
