/**
 * 
 */
package br.com.lucro.server.util;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucro.server.model.WebResponseException;
import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * Util functions to work with date/time operations
 * @author Georjuan Taylor
 */
public abstract class DateTimeUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);

	/**
	 * Compare two dates date (without time)
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static boolean equals(Date date1, Date date2) throws ParseException{		
		return new LocalDate(date1).equals(new LocalDate(date2));		
	}
	
	/**
	 * Parse date {@code String} format {@code "dd-MM-yyyy"} to {@code Date} object
	 * @param date - String
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseDateURL(String date, String param) throws WebResponseException{		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
		try{
			LocalDate dateTime = formatter.parseLocalDate(date);		
			return dateTime.toDate();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw new WebResponseException("Conversão de data inválida: " + param, EnumWebResponse.INVALID_PARAM);
		}
	}
	
	/**
	 * Parse date {@code String} format {@code "dd-MM-yyyy HH:mm:ss"} to {@code Date} object
	 * @param datetime - String
	 * @return Date
	 */
	public static Date parseTimeStampURL(String datetime, String param) throws WebResponseException{
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");				
		try{
			DateTime dateTime = formatter.parseDateTime(datetime)
					.toDateTime(DateTimeZone.forTimeZone(DateTimeUtils.getTimeZone()));
			return dateTime.toDate();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw new WebResponseException("Conversão de data inválida: " + param, EnumWebResponse.INVALID_PARAM);
		}
	}
	
	/**
	 * Parse a interval of time {@code String} format {@code "HH:mm:ss"} to corresponding seconds
	 * @param time - String
	 * @return seconds
	 */
	public static int parseIntervalTimeURL(String time, String param) throws WebResponseException{	
		try{
			String values[] = time.split(":");
			
			//Negative value?
			boolean negative = values[0].charAt(0) == '-';
			//Remove signal
			if(negative) values[0] = values[0].substring(1);
			
			return (Integer.parseInt(values[0]) * 60 * 60 + 
					Integer.parseInt(values[1]) * 60 + 
					Integer.parseInt(values[2])) * (negative ? -1 : 1);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw new WebResponseException("Conversão de intervalo inválido: " + param, EnumWebResponse.INVALID_PARAM);
		} 
	}
	
	/**
	 * GEt the configured time zone
	 * @return The configured time zone 
	 */
	public static TimeZone getTimeZone(){
		return TimeZone.getTimeZone(DateTimeUtils.getTimeZoneID());
	}
	
	/**
	 * GEt the configured time zone ID
	 * @return The configured time zone ID
	 */
	public static String getTimeZoneID(){
		return Properties.getProperty("datetime.timezone", "America/Sao_Paulo");
	}
	
	/**
	 * Check if {@code date} is between {@code startDate} and {@code endDate}
	 * @param date - Date
	 * @param startDate - Date
	 * @param endDate - Date
	 * @return <b>true</b> if 'date' is between 'startDate' and 'endDate', <b>false</b> otherwise
	 */
	public static boolean between(Date date, Date startDate, Date endDate) { 
	    Interval interval = new Interval(new DateTime(startDate), new DateTime(endDate));   
	    return interval.contains(new DateTime(date)); 
	}
	
	/**
	 * Cast UTC milliseconds to local Date
	 * @param time
	 * @return
	 */
	public static Date utcMillisToDate(long time){
		//TODO: Change to user java8 DateTime
		DateTime jodaTime = new DateTime(time, DateTimeZone.forTimeZone(getTimeZone()));
		return jodaTime.toDate();
	}

	/**
	 * Cast LocalDate into Date
	 * @param _baseDate
	 * @return
	 */
	public static Date toDate(java.time.LocalDate baseDate){
		return Date.from(baseDate.atStartOfDay().atZone(ZoneId.of(getTimeZoneID())).toInstant());
	}
	
	/**
	 * Get the first day of some week
	 * @param _baseDate
	 * @return
	 */
	public static java.time.LocalDate getFirstDayOfWeek(java.time.LocalDate baseDate){
	    //java.time.LocalDate baseDate = _baseDate.toInstant().atZone(ZoneId.of(getTimeZoneID())).toLocalDate();
	    
	    // Go backward to get Sunday
	    while (baseDate.getDayOfWeek() != DayOfWeek.SUNDAY) baseDate = baseDate.minusDays(1);
	    
	    return baseDate;
	}
}
