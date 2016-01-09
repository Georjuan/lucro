package br.com.lucro.server.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lucro.server.dao.CardFlagDAO;
import br.com.lucro.server.dao.ReportDAO;
import br.com.lucro.server.model.AverageTicket;
import br.com.lucro.server.model.CardFlag;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.SoldValueByFlag;
import br.com.lucro.server.model.SoldValueByPaymentMethod;

@Repository
public class ReportDAOImpl implements ReportDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ReportDAOImpl.class);
	
	@Autowired
	private DAOManager dao;	
	
	@Autowired
	private CardFlagDAO cardFlagDAO;
	
	public ReportDAOImpl() {}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.ReportDAO#selectSoldValueByFlag(br.com.lucro.server.model.Company, java.util.Date, java.util.Date)
	 */
	@Override
	public List<SoldValueByFlag> selectSoldValueByFlag(Company company, Date startDate, Date endDate) throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		List<SoldValueByFlag> report = new ArrayList<>();
		
		//Get query
		Query query = entityManager.createNamedQuery("SoldValueByFlagSQL", SoldValueByFlag.class);
		
		//Append parameters
		query.setParameter("start_date", startDate);
		query.setParameter("end_date", endDate);
		query.setParameter("company_id", company.getId());
		
		//Run query
		List<?> values = query.getResultList();
		
		//Get results		
		for(Object item : values){			
			SoldValueByFlag reportItem = (SoldValueByFlag) item;
			
			CardFlag cardFlag = cardFlagDAO.select(reportItem.getCardFlag());
			
			reportItem.setCompany(company);
			reportItem.setPeriodStart(startDate);
			reportItem.setPeriodEnd(endDate);
			reportItem.setCardFlag(cardFlag);
			
			report.add(reportItem);
		}
		
		return report;
	}

	
	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.ReportDAO#selectSoldValueByPaymentMethod(br.com.lucro.server.model.Company, java.util.Date, java.util.Date)
	 */
	@Override
	public SoldValueByPaymentMethod selectSoldValueByPaymentMethod(Company company, Date startDate, Date endDate) throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		//Get query
		Query query = entityManager.createNamedQuery("SoldValueByPaymentMethodSQL", SoldValueByPaymentMethod.class);
		
		//Append parameters
		query.setParameter("start_date", startDate);
		query.setParameter("end_date", endDate);
		query.setParameter("company_id", company.getId());
		
		//Run query
		List<?> values = query.getResultList();
		
		//Get result
		SoldValueByPaymentMethod report = (SoldValueByPaymentMethod) (values.size() > 0 ? values.get(0) : null); 
		
		//Append complementary data
		if(report!=null){
			report.setCompany(company);
			report.setPeriodStart(startDate);
			report.setPeriodEnd(endDate);
		}
		
		return report;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.dao.ReportDAO#selectAverageTicket(br.com.lucro.server.model.Company, br.com.lucro.server.model.AverageTicket.ENUM_AVERAGE_PERIOD, java.lang.Integer)
	 */
	@Override
	public List<AverageTicket> selectAverageTicket(Company company, List<Date[]> periods) throws Exception {
		EntityManager entityManager = dao.getEntityManager();
		
		List<AverageTicket> report = new ArrayList<>();
		
		for(Date[] period : periods){
		
			//Get query
			Query query = entityManager.createNamedQuery("AverageTicketSQL", AverageTicket.class);
			
			//Append parameters
			query.setParameter("start_date", period[0]);
			query.setParameter("end_date", period[1]);
			query.setParameter("company_id", company.getId());
			
			//Run query
			List<?> values = query.getResultList();
			
			//If there is no result in period, create an empty value
			if(values.isEmpty()){
				
				AverageTicket ticket = new AverageTicket();
				
				ticket.setQuantity(0);
				ticket.setSoldValue(0.0);
				ticket.setAverageValue(0.0);
				ticket.setCompany(company);
				ticket.setPeriodStart(period[0]);
				ticket.setPeriodEnd(period[1]);
				
				report.add(ticket);
				
			}else{
			
				for(Object averageTicket : values){
					AverageTicket ticket = (AverageTicket)averageTicket;
					
					ticket.setCompany(company);
					ticket.setPeriodStart(period[0]);
					ticket.setPeriodEnd(period[1]);
					
					report.add(ticket);
				}
				
			}
		
		}			
		
		return report;
	}

}
