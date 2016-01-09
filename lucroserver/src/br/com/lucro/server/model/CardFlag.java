package br.com.lucro.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the param_card_flag database table.
 * 
 */
@Entity
@Table(name="param_card_flag")
@NamedQuery(name="CardFlag.findAll", query="SELECT c FROM CardFlag c")
public class CardFlag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAM_CARD_FLAG_ID_GENERATOR", sequenceName="PARAM_CARD_FLAG_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAM_CARD_FLAG_ID_GENERATOR")
	private Integer id;

	private String name;

	public CardFlag() {
		
	}
	
	public CardFlag(Integer id) {
		this.id = id;
	}

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