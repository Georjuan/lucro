/**
 * @author taylor
 */
package br.com.lucro.server.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author taylor
 *
 */
public class AuthenticationDTO {

	@JsonProperty
	private String username;
	
	@JsonProperty
	private String password;
	
	/**
	 * 
	 */
	public AuthenticationDTO() {
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
