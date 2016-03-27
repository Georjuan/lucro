package br.com.lucro.server.service;

import java.util.Date;
import java.util.List;

import br.com.lucro.server.model.AverageTicket;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.SalesConciliation;
import br.com.lucro.server.model.SoldValueByFlag;
import br.com.lucro.server.model.SoldValueByPaymentMethod;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.model.AverageTicket.ENUM_AVERAGE_PERIOD;

public interface ReportService {
	
	/**
	 * Get the conciliation report between sales and payments
	 * @param company
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	List<SalesConciliation> getSalesConciliation(Company company, Date startDate, Date endDate) throws Exception;
	
	/**
	 * Get how much value was sold by each card flag
	 * @param company
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	List<SoldValueByFlag> getSoldValueByFlag(Company company, Date startDate, Date endDate) throws Exception;
	
	/**
	 * Get the data of sold value by payment method: debt, create in cash, credit financed, etc.
	 * @param company
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws WebResponseException
	 * @throws Exception
	 */
	public SoldValueByPaymentMethod getSoldValueByPaymentMethod(Company company, Date startDate, Date endDate) throws WebResponseException, Exception;
	
	/**
	 * Get the sold average ticket from last X days/weeks/months
	 * @param company
	 * @param period
	 * @param quantity
	 * @return
	 * @throws Exception
	 */
	List<AverageTicket> getAverageTicket(Company company, ENUM_AVERAGE_PERIOD period, Integer quantity) throws Exception;
	
}
