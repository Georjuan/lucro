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
 * The persistent class for the file_tivit_cielo_operation_resume_outstanding_balance database table.
 * 
 */
@Entity
@Table(
		name="file_tivit_cielo_operation_resume_outstanding_balance",
		uniqueConstraints=@UniqueConstraint(columnNames={"operation_resume_lot_number", "operation_resume_number"})
	)
@NamedQuery(name="FileOperationResumeOutstandingBalanceCielo.findAll", query="SELECT f FROM FileOperationResumeOutstandingBalanceCielo f")
public class FileOperationResumeOutstandingBalanceCielo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_OPERATION_RESUME_OUTSTANDING_BALANCE_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_OPERATION_RESUME_OUTSTANDING_BALANCE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_OPERATION_RESUME_OUTSTANDING_BALANCE_ID_GENERATOR")
	private Long id;

	@Column(name="anticipated_value")
	private Double anticipatedValue;

	@Column(name="card_flag_id")
	private Integer cardFlagId;

	@Temporal(TemporalType.DATE)
	@Column(name="catch_date")
	private Date catchDate;

	@Column(name="ceded_indicator")
	private String cededIndicator;

	@Column(name="ceded_value")
	private Double cededValue;

	private String currency;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="gross_value")
	private Double grossValue;

	@ManyToOne
	@JoinColumn(name="header_id", nullable=false, insertable=true)
	private FileHeaderCielo header;

	@Column(name="negotiated_parcels_size")
	private Integer negotiatedParcelsSize;

	@Column(name="negotiated_value")
	private Double negotiatedValue;

	@Column(name="net_value")
	private Double netValue;

	@Column(name="operation_resume_lot_number")
	private String operationResumeLotNumber;

	@Column(name="operation_resume_number")
	private String operationResumeNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_date")
	private Date paymentDate;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_forecast_date")
	private Date paymentForecastDate;

	@Column(name="payment_pending_parcels_size")
	private Integer paymentPendingParcelsSize;

	@Column(name="payment_split_size")
	private Integer paymentSplitSize;

	@Column(name="pending_payment_value")
	private Double pendingPaymentValue;

	@Column(name="platform_type")
	private String platformType;

	@Temporal(TemporalType.DATE)
	@Column(name="reference_date")
	private Date referenceDate;

	@Column(name="release_type")
	private String releaseType;

	@Column(name="sales_receipt_size")
	private Integer salesReceiptSize;

	@Column(name="to_compensate_value")
	private Double toCompensateValue;

	@Temporal(TemporalType.DATE)
	@Column(name="transfer_date")
	private Date transferDate;

	public FileOperationResumeOutstandingBalanceCielo() {
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

	public Integer getCardFlagId() {
		return this.cardFlagId;
	}

	public void setCardFlagId(Integer cardFlagId) {
		this.cardFlagId = cardFlagId;
	}

	public Date getCatchDate() {
		return this.catchDate;
	}

	public void setCatchDate(Date catchDate) {
		this.catchDate = catchDate;
	}

	public String getCededIndicator() {
		return this.cededIndicator;
	}

	public void setCededIndicator(String cededIndicator) {
		this.cededIndicator = cededIndicator;
	}

	public Double getCededValue() {
		return this.cededValue;
	}

	public void setCededValue(Double cededValue) {
		this.cededValue = cededValue;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public Integer getNegotiatedParcelsSize() {
		return this.negotiatedParcelsSize;
	}

	public void setNegotiatedParcelsSize(Integer negotiatedParcelsSize) {
		this.negotiatedParcelsSize = negotiatedParcelsSize;
	}

	public Double getNegotiatedValue() {
		return this.negotiatedValue;
	}

	public void setNegotiatedValue(Double negotiatedValue) {
		this.negotiatedValue = negotiatedValue;
	}

	public Double getNetValue() {
		return this.netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getOperationResumeLotNumber() {
		return this.operationResumeLotNumber;
	}

	public void setOperationResumeLotNumber(String operationResumeLotNumber) {
		this.operationResumeLotNumber = operationResumeLotNumber;
	}

	public String getOperationResumeNumber() {
		return this.operationResumeNumber;
	}

	public void setOperationResumeNumber(String operationResumeNumber) {
		this.operationResumeNumber = operationResumeNumber;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getPaymentForecastDate() {
		return this.paymentForecastDate;
	}

	public void setPaymentForecastDate(Date paymentForecastDate) {
		this.paymentForecastDate = paymentForecastDate;
	}

	public Integer getPaymentPendingParcelsSize() {
		return this.paymentPendingParcelsSize;
	}

	public void setPaymentPendingParcelsSize(Integer paymentPendingParcelsSize) {
		this.paymentPendingParcelsSize = paymentPendingParcelsSize;
	}

	public Integer getPaymentSplitSize() {
		return this.paymentSplitSize;
	}

	public void setPaymentSplitSize(Integer paymentSplitSize) {
		this.paymentSplitSize = paymentSplitSize;
	}

	public Double getPendingPaymentValue() {
		return this.pendingPaymentValue;
	}

	public void setPendingPaymentValue(Double pendingPaymentValue) {
		this.pendingPaymentValue = pendingPaymentValue;
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

	public String getReleaseType() {
		return this.releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public Integer getSalesReceiptSize() {
		return this.salesReceiptSize;
	}

	public void setSalesReceiptSize(Integer salesReceiptSize) {
		this.salesReceiptSize = salesReceiptSize;
	}

	public Double getToCompensateValue() {
		return this.toCompensateValue;
	}

	public void setToCompensateValue(Double toCompensateValue) {
		this.toCompensateValue = toCompensateValue;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

}