package br.com.lucro.server.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SoldValueByFlag {
	
	@JsonProperty("debt")
	private Double debt;
	
	@JsonProperty("credit_in_cash")
	private Double creditInCash;
	
	@JsonProperty("credit_financed")
	private Double creditFinanced;
	
	@JsonProperty("card_flag")
	private CardFlag cardFlag;
	
	@JsonIgnore
	private Company company;
	
	@JsonProperty("period_start")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date periodStart;
	
	@JsonProperty("period_end")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="America/Sao_Paulo")
	private Date periodEnd;
	
	//*************************************************************************************//
	
	public SoldValueByFlag() {
		super();
	}
	
	public SoldValueByFlag(Double debt, Double creditInCash, Double creditFinancied, Integer flag) {
		this.debt = debt;
		this.creditInCash = creditInCash;
		this.creditFinanced = creditFinancied;
		this.cardFlag = new CardFlag(flag);
	}
	
	/**
	 * @return the cardFlag
	 */
	public CardFlag getCardFlag() {
		return cardFlag;
	}

	/**
	 * @param cardFlag the cardFlag to set
	 */
	public void setCardFlag(CardFlag cardFlag) {
		this.cardFlag = cardFlag;
	}

	/**
	 * @return the debt
	 */
	public Double getDebt() {
		return debt;
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
	 * @param debt the debt to set
	 */
	public void setDebt(Double debt) {
		this.debt = debt;
	}
	/**
	 * @return the creditInCash
	 */
	public Double getCreditInCash() {
		return creditInCash;
	}
	/**
	 * @param creditInCash the creditInCash to set
	 */
	public void setCreditInCash(Double creditInCash) {
		this.creditInCash = creditInCash;
	}
	/**
	 * @return the creditFinanced
	 */
	public Double getCreditFinanced() {
		return creditFinanced;
	}
	/**
	 * @param creditFinanced the creditFinanced to set
	 */
	public void setCreditFinanced(Double creditFinanced) {
		this.creditFinanced = creditFinanced;
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
