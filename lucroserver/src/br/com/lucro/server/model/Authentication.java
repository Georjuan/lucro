/**
 * 
 */
package br.com.lucro.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Web authentication bean
 * @author Georjuan Taylor
 */
@Entity
public class Authentication {

	public enum EnumAccessType{
		LOGIN,SESSION;
	}
	
	public enum EnumUserType{
		COMPANY,APP,ADMIN,SYSTEM;
	}
	
	/** User name */
	@Id
	private String username;
	
	/** Session hash */
	@Column(updatable=false,insertable=false)
	private String session;
	
	/** User Type */
	@JsonProperty("user_type")
	@Column(name="access",updatable=false,insertable=false)	
	private String userType;
	
	/** Password */
	@Transient
	@JsonIgnore
	private String password;
	
	/** IP */
	@Transient
	@JsonIgnore
	private String ip;
	
	/** Access Type */
	@Transient
	@JsonIgnore
	private EnumAccessType access;
		
	public Authentication(){}
	
	public Authentication(String user, String password, String ip, EnumAccessType access) {
		this.username = user;
		this.password = password;
		this.access = access;
		this.session = "";
		this.ip = ip;
	}
	
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
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

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * @return the userType
	 */
	public EnumUserType getUserType() {
		return EnumUserType.valueOf(this.userType);
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the access
	 */
	public EnumAccessType getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(EnumAccessType access) {
		this.access = access;
	}

}
