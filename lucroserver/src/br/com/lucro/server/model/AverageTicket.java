package br.com.lucro.server.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageTicket {
	
	public enum ENUM_AVERAGE_PERIOD{
		DAY, WEEK, MONTH
	}
	
	@JsonProperty("sold_value")
	private Double soldValue;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("average_value")
	private Double averageValue;
	
	@JsonIgnore
	private Company company;
	
	@JsonProperty("period_start")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date periodStart;
	
	@JsonProperty("period_end")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date periodEnd;
	
	//*************************************************************************************//
	
	public AverageTicket() {
		this.soldValue = 0.0;
		this.quantity = 0;
		this.averageValue = 0.0;
	}

	public AverageTicket(Double soldValue, Integer quantity, Double averageValue) {
		this.soldValue = soldValue;
		this.quantity = quantity;
		this.averageValue = averageValue;
	}

	/**
	 * @return the soldValue
	 */
	public Double getSoldValue() {
		return soldValue;
	}

	/**
	 * @param soldValue the soldValue to set
	 */
	public void setSoldValue(Double soldValue) {
		this.soldValue = soldValue;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the averageValue
	 */
	public Double getAverageValue() {
		return averageValue;
	}

	/**
	 * @param averageValue the averageValue to set
	 */
	public void setAverageValue(Double averageValue) {
		this.averageValue = averageValue;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the periodStart
	 */
	public Date getPeriodStart() {
		return periodStart;
	}

	/**
	 * @param periodStart the periodStart to set
	 */
	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	/**
	 * @return the periodEnd
	 */
	public Date getPeriodEnd() {
		return periodEnd;
	}

	/**
	 * @param periodEnd the periodEnd to set
	 */
	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
	

}
