/**
 * 
 */
package br.com.lucro.server.model;


/**
 * Web authentication bean
 * @author Georjuan Taylor
 */
public class Authentication {

	/** User name */
	private String user;
	/** Password */
	private String password;
		
	public Authentication(){}
	
	public Authentication(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/**
	 * @return The {@link #user}
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * @param user - Set the {@link #user} value.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return The {@link #password}
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password - Set the {@link #password} value.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
