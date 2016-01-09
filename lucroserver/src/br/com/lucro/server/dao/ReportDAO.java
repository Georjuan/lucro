package br.com.lucro.server.dao;

import java.util.Date;
import java.util.List;

import br.com.lucro.server.model.AverageTicket;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.SoldValueByFlag;
import br.com.lucro.server.model.SoldValueByPaymentMethod;

/**
 * Functions to retrieve report data from data base
 * @author taylor
 *
 */
public interface ReportDAO {
	
	/**
	 * Select how much value was sold by each card flag
	 * @param company
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	List<SoldValueByFlag> selectSoldValueByFlag(Company company, Date startDate, Date endDate) throws Exception;
	
	/**
	 * Select how much value was sold by each payment method
	 * @param company
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	SoldValueByPaymentMethod selectSoldValueByPaymentMethod(Company company, Date startDate, Date endDate) throws Exception;
	
	/**
	 * Select the sold average ticket from last X days/weeks/months
	 * @param company
	 * @param periods
	 * @return
	 */
	List<AverageTicket> selectAverageTicket(Company company, List<Date[]> periods) throws Exception;

}
