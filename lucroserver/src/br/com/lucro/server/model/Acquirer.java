package br.com.lucro.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author taylor
 *
 */
@Entity
@Table(name="acquirer")
public class Acquirer {

	public static final int CIELO = 1;
	
	@Id
	@SequenceGenerator(name="ACQUIRER_ID_GENERATOR", sequenceName="ACQUIRER_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACQUIRER_ID_GENERATOR")
	private Integer id;
	
	@Column
	private String name;
	
	public Acquirer() {}
	public Acquirer(Integer id) {this.id = id;}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
