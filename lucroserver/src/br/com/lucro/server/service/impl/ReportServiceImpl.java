package br.com.lucro.server.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucro.server.dao.ReportDAO;
import br.com.lucro.server.model.AverageTicket;
import br.com.lucro.server.model.AverageTicket.ENUM_AVERAGE_PERIOD;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.SoldValueByFlag;
import br.com.lucro.server.model.SoldValueByPaymentMethod;
import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.service.ReportService;
import br.com.lucro.server.util.DateTimeUtils;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDAO reportDAO;
	
	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.ReportService#getSoldValueByFlag(br.com.lucro.server.model.Company, java.util.Date, java.util.Date)
	 */
	@Override
	public List<SoldValueByFlag> getSoldValueByFlag(Company company, Date startDate, Date endDate) throws Exception {
		//Get data
		List<SoldValueByFlag> report = reportDAO.selectSoldValueByFlag(company, startDate, endDate);		
		return report;
	}

	@Override
	public SoldValueByPaymentMethod getSoldValueByPaymentMethod(Company company, Date startDate, Date endDate) throws WebResponseException, Exception {
		//Get data
		SoldValueByPaymentMethod report = reportDAO.selectSoldValueByPaymentMethod(company, startDate, endDate);		
		return report;
	}

	/* (non-Javadoc)
	 * @see br.com.lucro.server.service.ReportService#getAverageTicket(br.com.lucro.server.model.Company, br.com.lucro.server.model.AverageTicket.ENUM_AVERAGE_PERIOD, java.lang.Integer)
	 */
	@Override
	public List<AverageTicket> getAverageTicket(Company company, ENUM_AVERAGE_PERIOD period, Integer quantity) throws Exception {
		
		//Create period list
		List<Date[]> periods = new ArrayList<>();
		
		if(period.equals(ENUM_AVERAGE_PERIOD.DAY)){ //Step Days
			
			//Today minus 1 day (start by yesterday and step back)
			Calendar startDate = Calendar.getInstance(DateTimeUtils.getTimeZone());
			startDate.add(Calendar.DATE, -1);
			
			//Date in step
			Calendar dateStep = (Calendar) startDate.clone();
			
			//Days last 'quantity' days 
			while(quantity-- > 0){
				periods.add(new Date[]{dateStep.getTime(), dateStep.getTime()});
				dateStep.add(Calendar.DATE, -1);
			}
		
		}if(period.equals(ENUM_AVERAGE_PERIOD.WEEK)){ //Step Weeks
			
			LocalDate today = LocalDate.now(ZoneId.of(DateTimeUtils.getTimeZoneID()));
			LocalDate startDate = today.minusDays(1);

			//Date in step (last day of the current month in step)
			LocalDate dateStep = startDate;
			
			//Days last 'quantity' days 
			while(quantity-- > 0){
				
				//Calculate last day
				LocalDate lastDayWeek = dateStep;
				
				//Calculate first day
				LocalDate firstDayWeek = DateTimeUtils.getFirstDayOfWeek(dateStep);
				
				//Append month
				periods.add(new Date[]{DateTimeUtils.toDate(firstDayWeek), DateTimeUtils.toDate(lastDayWeek)});
				
				//Set next last day
				dateStep = firstDayWeek.minusDays(1);
				
			}			
			
		}if(period.equals(ENUM_AVERAGE_PERIOD.MONTH)){ //Step Months
			
			//Today minus 1 day (start by yesterday and step back)
			Calendar startDate = Calendar.getInstance(DateTimeUtils.getTimeZone());
			startDate.add(Calendar.DATE, -1);
			
			//Date in step (last day of the current month in step)
			Calendar dateStep = (Calendar) startDate.clone();
			
			//Days last 'quantity' days 
			while(quantity-- > 0){
				
				//Calculate last day
				Calendar lastDayMonth = (Calendar) dateStep.clone();
				
				//Calculate first day
				Calendar firstDayMonth = (Calendar) lastDayMonth.clone();
				firstDayMonth.set(Calendar.DATE, 1);
				
				//Append month
				periods.add(new Date[]{firstDayMonth.getTime(), lastDayMonth.getTime()});
				
				//Set next last day
				dateStep = (Calendar) firstDayMonth.clone();
				dateStep.add(Calendar.DATE, -1);
				
			}
			
		}
		
		return reportDAO.selectAverageTicket(company, periods);
	}

}
