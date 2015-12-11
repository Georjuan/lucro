package br.com.lucro.manager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the file_tivit_cielo_header database table.
 * 
 * TIPO 0 - Identifica o cabeçalho de cada arquivo por cadeia de extrato eletrônico. 
 */
@Entity
@Table(
		name="file_tivit_cielo_header",
		uniqueConstraints=@UniqueConstraint(columnNames={"file_number","type_extract_option_id"})
	)
@NamedQuery(name="FileHeaderCielo.findAll", query="SELECT f FROM FileHeaderCielo f")
public class FileHeaderCielo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_HEADER_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_HEADER_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_HEADER_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="file_number")
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
	
	@Column(name="mailbox")
	private String mailbox;

	@Column(name="file")
	private String file;
	
	public FileHeaderCielo() {}
	
	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}




	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}




	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
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