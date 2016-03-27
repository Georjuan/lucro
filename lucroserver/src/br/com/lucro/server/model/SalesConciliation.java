/**
 * @author taylor
 */
package br.com.lucro.server.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author taylor
 *
 */
public class SalesConciliation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private String establishmentNumber;
	
	@JsonProperty("operation_resume_number")
	private String operationResumeNumber;
	
	@JsonProperty("flag_id")
	private Integer flagId;
	
	@JsonProperty("parcel")
	private Integer parcel;
	
	@JsonProperty("value")
	private Double value;
	
	@JsonProperty("payment_forecast_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date paymentForecastDate;
	
	@JsonProperty("sent_bank_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date sentBankDate;
	
	/**
	 * 
	 */
	public SalesConciliation() {
		
	}
	
	public SalesConciliation(String establishmentNumber, String operationResumeNumber, Integer flagId, Integer parcel,
			Double value, Date paymentForecastDate, Date sentBankDate) {
		this.establishmentNumber = establishmentNumber;
		this.operationResumeNumber = operationResumeNumber;
		this.flagId = flagId;
		this.parcel = parcel;
		this.value = value;
		this.paymentForecastDate = paymentForecastDate;
		this.sentBankDate = sentBankDate;
	}

	/**
	 * @return the operationResumeNumber
	 */
	public String getOperationResumeNumber() {
		return operationResumeNumber;
	}

	/**
	 * @param operationResumeNumber the operationResumeNumber to set
	 */
	public void setOperationResumeNumber(String operationResumeNumber) {
		this.operationResumeNumber = operationResumeNumber;
	}

	/**
	 * @return the parcel
	 */
	public Integer getParcel() {
		return parcel;
	}

	/**
	 * @param parcel the parcel to set
	 */
	public void setParcel(Integer parcel) {
		this.parcel = parcel;
	}

	/**
	 * @return the establishmentNumber
	 */
	public String getEstablishmentNumber() {
		return establishmentNumber;
	}

	/**
	 * @param establishmentNumber the establishmentNumber to set
	 */
	public void setEstablishmentNumber(String establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	/**
	 * @return the flagId
	 */
	public Integer getFlagId() {
		return flagId;
	}

	/**
	 * @param flagId the flagId to set
	 */
	public void setFlagId(Integer flagId) {
		this.flagId = flagId;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the paymentForecastDate
	 */
	public Date getPaymentForecastDate() {
		return paymentForecastDate;
	}

	/**
	 * @param paymentForecastDate the paymentForecastDate to set
	 */
	public void setPaymentForecastDate(Date paymentForecastDate) {
		this.paymentForecastDate = paymentForecastDate;
	}

	/**
	 * @return the sentBankDate
	 */
	public Date getSentBankDate() {
		return sentBankDate;
	}

	/**
	 * @param sentBankDate the sentBankDate to set
	 */
	public void setSentBankDate(Date sentBankDate) {
		this.sentBankDate = sentBankDate;
	}
	
}
