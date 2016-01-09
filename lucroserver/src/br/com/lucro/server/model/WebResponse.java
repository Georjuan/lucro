/**
 * 
 */
package br.com.lucro.server.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucro.server.util.enums.EnumWebResponse;

/**
 * @author Georjuan Taylor
 *
 */
public class WebResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Web response code status */
	private EnumWebResponse status;
	
	/** Web response message status */
	private String message;
	
	/** Date/Time operation in DB */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss Z", timezone="America/Sao_Paulo")
	private Date datetime;
	
	/** Web response map */
	private Map<String, Object> response;
	
	public WebResponse() {this.datetime = Calendar.getInstance().getTime();}

	/**
	 * @return The {@link #response}
	 */
	public Map<String, Object> getResponse() {
		return this.response;
	}

	/**
	 * @param response - Set the {@link #response} value.
	 */
	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	/**
	 * @return The {@link #status}
	 */
	public EnumWebResponse getStatus() {
		return this.status;
	}

	/**
	 * @param status - Set the {@link #status} value.
	 */
	public void setStatus(EnumWebResponse status) {
		this.status = status;
	}

	/**
	 * @return The {@link #message}
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message - Set the {@link #message} value.
	 */
	public void setMessage(String message) {
		this.message = message != null ? message : "NullPointerException";		
		//Treats SQL errors
		if(this.message.contains("nested exception is org.postgresql.util.PSQLException:")){
			this.message = this.message.substring(this.message.indexOf("nested exception is org.postgresql.util.PSQLException:"))
					.replace("nested exception is org.postgresql.util.PSQLException:", "").trim();
			if(this.message.indexOf("ERROR:") == 0) this.message = this.message.substring(7);
		}
		this.message = this.message.trim();
	}
	
	/**
	 * @param message - Set the {@link #message} value.
	 */
	public void setMessage(String message, Exception e) {
		setMessage(message + " - " + e.getMessage());
	}

	/**
	 * @return The {@link #datetime}
	 */
	public Date getDatetime() {
		return this.datetime;
	}

	/**
	 * @param datetime - Set the {@link #datetime} value.
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}