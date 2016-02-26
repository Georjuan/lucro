package br.com.lucro.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rel_company_acquirer database table.
 * 
 */
@Embeddable
public class CompanyAcquirerPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="company_id", insertable=true, updatable=false)
	private Integer company;

	@Column(name="acquirer_id", insertable=true, updatable=false)
	private Integer acquirer;

	public CompanyAcquirerPK() {
		
	}
	
	public CompanyAcquirerPK(Integer company, Integer acquirer) {
		this.acquirer = acquirer;
		this.company = company;
	}
	
	/**
	 * @return the company
	 */
	public Integer getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Integer company) {
		this.company = company;
	}

	/**
	 * @return the acquirer
	 */
	public Integer getAcquirer() {
		return acquirer;
	}

	/**
	 * @param acquirer the acquirer to set
	 */
	public void setAcquirer(Integer acquirer) {
		this.acquirer = acquirer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyAcquirerPK)) {
			return false;
		}
		CompanyAcquirerPK castOther = (CompanyAcquirerPK)other;
		return 
			this.company.equals(castOther.company)
			&& this.acquirer.equals(castOther.acquirer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		
		hash = hash * prime + this.company.hashCode();
		hash = hash * prime + this.acquirer.hashCode();
		
		return hash;
	}
}