package br.com.lucro.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.lucro.server.model.Company;

public class CompanyDTO {

	@JsonProperty("id")
	private Integer id;
	
	public CompanyDTO() {
		
	}
	
	public Company toCompany(){
		Company company = new Company();
		company.setId(id);
		return company;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
