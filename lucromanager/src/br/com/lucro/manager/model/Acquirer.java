package br.com.lucro.manager.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the acquirer database table.
 */
@Entity
@Table(name="acquirer")
@NamedQuery(name="Acquirer.findAll", query="SELECT a FROM Acquirer a")
public class Acquirer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "acquirer_id_seq", sequenceName="acquirer_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acquirer_id_seq")
	private Integer id;
	
	@Column(name="name")
	private String name;

	public Acquirer() {}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}