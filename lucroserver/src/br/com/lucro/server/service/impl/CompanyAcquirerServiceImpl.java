/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.CompanyAcquirerDAO;
import br.com.lucro.server.dao.CompanyDAO;
import br.com.lucro.server.model.CompanyAcquirer;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.CompanyAcquirerService;
import br.com.lucro.server.util.CnpjUtils;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author taylor
 *
 */
@Service
public class CompanyAcquirerServiceImpl implements CompanyAcquirerService {

	@Autowired
	private CompanyAcquirerDAO acquirerDAO;
	
	@Autowired
	private CompanyDAO companyDAO;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.AcquirerService#saveAcquirer(br.com.lucro.server.model.CompanyAcquirer)
	 */
	@Override
	public CompanyAcquirer saveAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception {
		
		if(!CnpjUtils.isCnpj(companyAcquirer.getCompany().getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		if(companyAcquirer.getId().getAcquirer()==null)
			throw new WebResponseException("Adquirente inválida", EnumWebResponse.INVALID_PARAM);
		
		companyAcquirer.setCompany(
					companyDAO.select(companyAcquirer.getCompany())
				);
		
		if(companyAcquirer.getCompany()==null)
			throw new WebResponseException("Empresa não cadastrada", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		companyAcquirer.getId().setCompany(companyAcquirer.getCompany().getId());
		
		if(acquirerDAO.select(companyAcquirer)!=null)
			throw new WebResponseException("Adquirente já cadastrada para essa empresa", EnumWebResponse.DUPLICATED_DATA);
		
		return acquirerDAO.create(companyAcquirer);
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.AcquirerService#deleteAcquirer(br.com.lucro.server.model.CompanyAcquirer)
	 */
	@Override
	public CompanyAcquirer deleteAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception {

		if(!CnpjUtils.isCnpj(companyAcquirer.getCompany().getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		if(companyAcquirer.getId().getAcquirer()==null)
			throw new WebResponseException("Adquirente inválida", EnumWebResponse.INVALID_PARAM);
		
		companyAcquirer.setCompany(
					companyDAO.select(companyAcquirer.getCompany())
				);
		
		if(companyAcquirer.getCompany()==null)
			throw new WebResponseException("Empresa não cadastrada", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		companyAcquirer.getId().setCompany(companyAcquirer.getCompany().getId());
		
		if(acquirerDAO.select(companyAcquirer)==null)
			throw new WebResponseException("Adquirente não cadastrada para essa empresa", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		return acquirerDAO.delete(companyAcquirer);
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.AcquirerService#updateAcquirer(br.com.lucro.server.model.CompanyAcquirer)
	 */
	@Override
	public CompanyAcquirer updateAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception {
		
		if(!CnpjUtils.isCnpj(companyAcquirer.getCompany().getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		if(companyAcquirer.getId().getAcquirer()==null)
			throw new WebResponseException("Adquirente inválida", EnumWebResponse.INVALID_PARAM);
		
		companyAcquirer.setCompany(
					companyDAO.select(companyAcquirer.getCompany())
				);
		
		if(companyAcquirer.getCompany()==null)
			throw new WebResponseException("Empresa não cadastrada", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		companyAcquirer.getId().setCompany(companyAcquirer.getCompany().getId());
		
		if(acquirerDAO.select(companyAcquirer)==null)
			throw new WebResponseException("Adquirente não cadastrada para essa empresa", EnumWebResponse.DATA_INTEGRITY_ERROR);
		
		return acquirerDAO.update(companyAcquirer);
	}

}
