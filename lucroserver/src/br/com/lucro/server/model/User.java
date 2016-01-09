/**
 * @author taylor
 */
package br.com.lucro.server.model;

/**
 * @author taylor
 *
 */
public class User {

	/** User name */
	private String userName;
	/** Hash */
	private String hash;
	
	/**
	 * 
	 */
	public User() {
		
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	

}
