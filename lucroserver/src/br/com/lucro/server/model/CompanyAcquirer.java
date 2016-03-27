package br.com.lucro.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the rel_company_acquirer database table.
 * 
 */
@Entity
@Table(name="rel_company_acquirer")
public class CompanyAcquirer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyAcquirerPK id;

	private String email;

	private String password;

	private String username;
	
	@Column(name="postal_code")
	private String postalcode;
	
	@Transient
	private Company company;
	
	@Transient
	private String acquirer;
	
	@Column(name="establishment_number")
	private String establishmentNumber;

	public CompanyAcquirer() {
		
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
	 * @return the company
	 */
	public Company getCompany() {
		return company;
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
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}


	/**
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param postalcode the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public CompanyAcquirerPK getId() {
		return this.id;
	}

	public void setId(CompanyAcquirerPK id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}