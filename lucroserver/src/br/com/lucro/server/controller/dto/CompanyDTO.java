package br.com.lucro.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.User;

public class CompanyDTO{

	@JsonProperty("business_name")
	private String businessName;
	
	@JsonProperty("trading_name")
	private String tradingName;
	
	@JsonProperty
	private String cnpj;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String password;
	
	public CompanyDTO() {
		
	}
	
	public Company toCompany(){
		Company company = new Company();
		
		User user = new User();
		user.setUserName(email);
		user.setPassword(password);
		
		company.setBusinessName(businessName);
		company.setTradingName(tradingName);
		company.setPassword(password);
		company.setUser(user);
		company.setCnpj(cnpj);
		
		return company;
	}

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @return the tradingName
	 */
	public String getTradingName() {
		return tradingName;
	}

	/**
	 * @param tradingName the tradingName to set
	 */
	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
