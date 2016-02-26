/**
 * @author taylor
 */
package br.com.lucro.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author taylor
 *
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@SequenceGenerator(name="USER_ID_GENERATOR", sequenceName="USER_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_GENERATOR")
	private Integer id;
	
	@Column(name="username")
	private String userName;
	
	@JsonIgnore
	@Column(name="hash", insertable=false)
	private String hash;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName="user_id",insertable=false,updatable=false)
	private Company company;	
	
	/**
	 * 
	 */
	public User() {
		
	}
	
	/**
	 * 
	 */
	public User(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public User(String username) {
		this.userName = username;
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
