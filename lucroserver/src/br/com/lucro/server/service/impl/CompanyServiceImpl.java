/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucro.server.dao.CompanyDAO;
import br.com.lucro.server.dao.UserDAO;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.CompanyService;
import br.com.lucro.server.util.CnpjUtils;
import br.com.lucro.server.util.MailUtils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @see CompanyService
 * @author taylor
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.CompanyService#saveCompany(br.com.lucro.server.model.Company)
	 */
	@Override
	@Transactional(rollbackFor={WebResponseException.class, Exception.class})
	public Company saveCompany(Company company) throws WebResponseException, Exception {
		
		if(!CnpjUtils.isCnpj(company.getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		if(company.getBusinessName()==null || company.getBusinessName().isEmpty())
			throw new WebResponseException("Razão social inválida", EnumWebResponse.INVALID_PARAM);
		
		if(company.getTradingName()==null || company.getTradingName().isEmpty())
			throw new WebResponseException("Nome da marca/empresa inválido", EnumWebResponse.INVALID_PARAM);
		
		if(company.getPassword()==null || company.getPassword().isEmpty())
			throw new WebResponseException("Senha inválida", EnumWebResponse.INVALID_PARAM);
		
		if(!MailUtils.isValid(company.getUser().getUserName()))
			throw new WebResponseException("Email inválido", EnumWebResponse.INVALID_PARAM);
		
		if(companyDAO.select(company)!=null)
			throw new WebResponseException("CNPJ já cadastrado", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		if(userDAO.select(company.getUser()) !=null)
			throw new WebResponseException("Email já cadastrado", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		return companyDAO.create(company);
	}

}
