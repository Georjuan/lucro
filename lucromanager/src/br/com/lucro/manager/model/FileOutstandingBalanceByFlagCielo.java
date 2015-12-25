package br.com.lucro.manager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * The persistent class for the file_tivit_cielo_outstanding_balance_by_flag database table.
 * 
 */
@Entity
@Table(
		name="file_tivit_cielo_outstanding_balance_by_flag",
		uniqueConstraints=@UniqueConstraint(columnNames={"reference_date", "platform_type", "card_flag_id"})
	)
@NamedQuery(name="FileOutstandingBalanceByFlagCielo.findAll", query="SELECT f FROM FileOutstandingBalanceByFlagCielo f")
public class FileOutstandingBalanceByFlagCielo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_OUTSTANDING_BALANCE_BY_FLAG_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_OUTSTANDING_BALANCE_BY_FLAG_ID_SEQ", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_OUTSTANDING_BALANCE_BY_FLAG_ID_GENERATOR")
	private Long id;

	@Column(name="anticipated_value")
	private Double anticipatedValue;

	@Column(name="branches_size")
	private Integer branchesSize;

	@Column(name="card_flag_id")
	private Integer cardFlagId;

	@Column(name="ceded_value")
	private Double cededValue;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="gross_value")
	private Double grossValue;

	@ManyToOne
	@JoinColumn(name="header_id", nullable=false, insertable=true)
	private FileHeaderCielo header;

	@Column(name="net_value")
	private Double netValue;

	@Column(name="platform_type")
	private String platformType;

	@Temporal(TemporalType.DATE)
	@Column(name="reference_date")
	private Date referenceDate;

	@Column(name="to_compensate_value")
	private Double toCompensateValue;

	public FileOutstandingBalanceByFlagCielo() {
	
	}
	
	/**
	 * @return the header
	 */
	public FileHeaderCielo getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(FileHeaderCielo header) {
		this.header = header;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAnticipatedValue() {
		return this.anticipatedValue;
	}

	public void setAnticipatedValue(Double anticipatedValue) {
		this.anticipatedValue = anticipatedValue;
	}

	public Integer getBranchesSize() {
		return this.branchesSize;
	}

	public void setBranchesSize(Integer branchesSize) {
		this.branchesSize = branchesSize;
	}

	public Integer getCardFlagId() {
		return this.cardFlagId;
	}

	public void setCardFlagId(Integer cardFlagId) {
		this.cardFlagId = cardFlagId;
	}

	public Double getCededValue() {
		return this.cededValue;
	}

	public void setCededValue(Double cededValue) {
		this.cededValue = cededValue;
	}

	public String getEstablishmentNumber() {
		return this.establishmentNumber;
	}

	public void setEstablishmentNumber(String establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	public Double getGrossValue() {
		return this.grossValue;
	}

	public void setGrossValue(Double grossValue) {
		this.grossValue = grossValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getPlatformType() {
		return this.platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public Date getReferenceDate() {
		return this.referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public Double getToCompensateValue() {
		return this.toCompensateValue;
	}

	public void setToCompensateValue(Double toCompensateValue) {
		this.toCompensateValue = toCompensateValue;
	}

}