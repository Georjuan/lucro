/**
 * @author taylor
 */
package br.com.lucro.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.lucro.server.model.Acquirer;
import br.com.lucro.server.model.Company;
import br.com.lucro.server.model.CompanyAcquirer;
import br.com.lucro.server.model.CompanyAcquirerPK;

/**
 * @author taylor
 *
 */
public class AcquirerDTO {

	@JsonProperty
	private String acquirer;
	
	@JsonProperty(required=false)
	private String email;
	
	@JsonProperty(required=false)
	private String username;
	
	@JsonProperty(required=false)
	private String password;
	
	@JsonProperty(required=false)
	private String postalcode;

	@JsonProperty
	private String cnpj;
	
	public AcquirerDTO() {
	
	}
	
	public CompanyAcquirer toAcquirer(){
		CompanyAcquirer companyAcquirer = new CompanyAcquirer();
		
		CompanyAcquirerPK acquirerPK = new CompanyAcquirerPK();
		acquirerPK.setAcquirer(getAcquirer(this.acquirer));
		
		companyAcquirer.setId(acquirerPK);
		companyAcquirer.setEmail(this.email);
		companyAcquirer.setPassword(this.password);
		companyAcquirer.setPostalcode(this.postalcode);
		companyAcquirer.setUsername(this.username);
		companyAcquirer.setCompany(new Company(this.cnpj));
		
		return companyAcquirer;
	}
	
	public static Integer getAcquirer(String acquirer){
		if(acquirer!=null && acquirer.equals("CIELO")){
			return Acquirer.CIELO;
		}else{
			return null;
		}
	}

	/**
	 * @return the acquirer
	 */
	public String getAcquirer() {
		return acquirer;
	}

	/**
	 * @param acquirer the acquirer to set
	 */
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
