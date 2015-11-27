package br.com.lucro.manager.model.tivit.cielo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the file_tivit_cielo_header database table.
 * 
 */
@Entity
@Table(name="file_tivit_cielo_header")
@NamedQuery(name="FileHeader.findAll", query="SELECT f FROM FileHeader f")
public class FileHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_HEADER_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_HEADER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_HEADER_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="file_number", unique=true)
	private String fileNumber;

	@Column(name="layout_version")
	private String layoutVersion;

	@Temporal(TemporalType.DATE)
	@Column(name="process_date")
	private Date processDate;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	@Column(name="type_extract_option_id")
	private Integer typeExtractOptionId;

	@Column(name="van")
	private String van;

	public FileHeader() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEstablishmentNumber() {
		return this.establishmentNumber;
	}

	public void setEstablishmentNumber(String establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	public String getFileNumber() {
		return this.fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getLayoutVersion() {
		return this.layoutVersion;
	}

	public void setLayoutVersion(String layoutVersion) {
		this.layoutVersion = layoutVersion;
	}

	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getTypeExtractOptionId() {
		return this.typeExtractOptionId;
	}

	public void setTypeExtractOptionId(Integer typeExtractOptionId) {
		this.typeExtractOptionId = typeExtractOptionId;
	}

	public String getVan() {
		return this.van;
	}

	public void setVan(String van) {
		this.van = van;
	}

}