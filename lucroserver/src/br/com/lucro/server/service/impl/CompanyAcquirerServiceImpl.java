/**
 * @author taylor
 */
package br.com.lucro.server.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.CompanyAcquirerDAO;
import br.com.lucro.server.dao.CompanyDAO;
import br.com.lucro.server.dao.impl.CompanyAcquirerDAOImpl;
import br.com.lucro.server.model.Company;
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

	private static final Logger logger = Logger.getLogger(CompanyAcquirerDAOImpl.class);
	
	@Autowired
	private CompanyAcquirerDAO acquirerDAO;
	
	@Autowired
	private CompanyDAO companyDAO;

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.CompanyAcquirerService#getAcquirers(br.com.lucro.server.model.Company)
	 */
	@Override
	public List<CompanyAcquirer> getAcquirers(Company company) throws WebResponseException, Exception {
		
		if(!CnpjUtils.isCnpj(company.getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		company = companyDAO.select(company);
	
		if(company==null)
			throw new WebResponseException("Empresa não cadastrada", EnumWebResponse.DATA_INTEGRITY_ERROR);
	
		return acquirerDAO.selectByCompany(company);
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.AcquirerService#saveAcquirer(br.com.lucro.server.model.CompanyAcquirer)
	 */
	@Override
	public CompanyAcquirer saveAcquirer(CompanyAcquirer companyAcquirer) throws WebResponseException, Exception {
		
		if(!CnpjUtils.isCnpj(companyAcquirer.getCompany().getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
		
		if(companyAcquirer.getId().getAcquirer()==null)
			throw new WebResponseException("Adquirente inválida", EnumWebResponse.INVALID_PARAM);
		
		if(companyAcquirer.getEstablishmentNumber()==null || companyAcquirer.getEstablishmentNumber().isEmpty())
			throw new WebResponseException("Número do estabelecimento inválido", EnumWebResponse.INVALID_PARAM);
		
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
logger.info("1");
		if(!CnpjUtils.isCnpj(companyAcquirer.getCompany().getCnpj()))
			throw new WebResponseException("CNPJ inválido", EnumWebResponse.INVALID_PARAM);
logger.info("2");
		if(companyAcquirer.getId().getAcquirer()==null)
			throw new WebResponseException("Adquirente inválida", EnumWebResponse.INVALID_PARAM);
logger.info("3");
		companyAcquirer.setCompany(
					companyDAO.select(companyAcquirer.getCompany())
				);
logger.info("4");
		if(companyAcquirer.getCompany()==null)
			throw new WebResponseException("Empresa não cadastrada", EnumWebResponse.DATA_INTEGRITY_ERROR);
logger.info("5");
		companyAcquirer.getId().setCompany(companyAcquirer.getCompany().getId());
logger.info("6");
		if(acquirerDAO.select(companyAcquirer)==null)
			throw new WebResponseException("Adquirente não cadastrada para essa empresa", EnumWebResponse.DATA_INTEGRITY_ERROR);
logger.info("7");
		return acquirerDAO.update(companyAcquirer);
	}

}
