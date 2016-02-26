package br.com.lucro.server.model;

import java.io.Serializable;
import javax.persistence.*;


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

	public CompanyAcquirer() {
		
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