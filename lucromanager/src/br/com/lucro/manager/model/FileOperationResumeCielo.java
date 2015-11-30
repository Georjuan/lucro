package br.com.lucro.manager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the file_tivit_cielo_operation_resume database table.
 * 
 */
@Entity
@Table(name="file_tivit_cielo_operation_resume")
@NamedQuery(name="FileOperationResumeCielo.findAll", query="SELECT f FROM FileOperationResumeCielo f")
public class FileOperationResumeCielo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_OPERATION_RESUME_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_OPERATION_RESUME_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_OPERATION_RESUME_ID_GENERATOR")
	private Long id;

	@Column(name="accepted_sales")
	private Integer acceptedSales;

	@Column(name="adjustment_source_id")
	private Integer adjustmentSourceId;

	@Column(name="anticipated_gross_value")
	private Double anticipatedGrossValue;

	@Column(name="bank_account_payment")
	private String bankAccountPayment;

	@Column(name="bank_agency_payment")
	private String bankAgencyPayment;

	@Column(name="bank_payment")
	private String bankPayment;

	@Column(name="card_flag_id")
	private Integer cardFlagId;

	@Column(name="catch_method_id")
	private Integer catchMethodId;

	@Temporal(TemporalType.DATE)
	@Column(name="catch_transaction_date")
	private Date catchTransactionDate;

	@Column(name="complementary_value")
	private Double complementaryValue;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="fee_percent")
	private Double feePercent;

	@Column(name="fee_value")
	private Double feeValue;

	private String filler;

	@Column(name="financial_operation_number")
	private String financialOperationNumber;

	@Column(name="financial_product_identifier")
	private String financialProductIdentifier;

	@Column(name="gross_value")
	private Double grossValue;

	//@Column(name="header_id")
	//private Long headerId;
	@JoinColumn(name="header_id", nullable=false, insertable=true)
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	private FileHeaderCielo header;

	@Column(name="net_value")
	private Double netValue;

	@Column(name="operation_resume_lot_number")
	private String operationResumeLotNumber;

	@Column(name="operation_resume_number", unique=true)
	private String operationResumeNumber;

	private Integer parcel;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_forecast_date")
	private Date paymentForecastDate;

	@Column(name="payment_status_id")
	private Integer paymentStatusId;

	private String plan;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="rejected_sales")
	private Integer rejectedSales;

	@Column(name="rejected_value")
	private Double rejectedValue;

	@Column(name="resale_acceleration_indicator")
	private String resaleAccelerationIndicator;

	@Temporal(TemporalType.DATE)
	@Column(name="sent_bank_date")
	private Date sentBankDate;

	@Column(name="transaction_fee_value")
	private Double transactionFeeValue;

	@Temporal(TemporalType.DATE)
	@Column(name="transfer_date")
	private Date transferDate;

	@Column(name="type_transaction_id")
	private Integer typeTransactionId;

	@Column(name="warranty_fee_value")
	private Double warrantyFeeValue;
	
	@Column(name="terminal_number")
	private String terminalNumber;

	public FileOperationResumeCielo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAcceptedSales() {
		return this.acceptedSales;
	}

	public void setAcceptedSales(Integer acceptedSales) {
		this.acceptedSales = acceptedSales;
	}

	public Integer getAdjustmentSourceId() {
		return this.adjustmentSourceId;
	}

	public void setAdjustmentSourceId(Integer adjustmentSourceId) {
		this.adjustmentSourceId = adjustmentSourceId;
	}

	public Double getAnticipatedGrossValue() {
		return this.anticipatedGrossValue;
	}

	public void setAnticipatedGrossValue(Double anticipatedGrossValue) {
		this.anticipatedGrossValue = anticipatedGrossValue;
	}

	public String getBankAccountPayment() {
		return this.bankAccountPayment;
	}

	public void setBankAccountPayment(String bankAccountPayment) {
		this.bankAccountPayment = bankAccountPayment;
	}

	public String getBankAgencyPayment() {
		return this.bankAgencyPayment;
	}

	public void setBankAgencyPayment(String bankAgencyPayment) {
		this.bankAgencyPayment = bankAgencyPayment;
	}

	public String getBankPayment() {
		return this.bankPayment;
	}

	public void setBankPayment(String bankPayment) {
		this.bankPayment = bankPayment;
	}

	public Integer getCardFlagId() {
		return this.cardFlagId;
	}

	public void setCardFlagId(Integer cardFlagId) {
		this.cardFlagId = cardFlagId;
	}

	public Integer getCatchMethodId() {
		return this.catchMethodId;
	}
	
	/**
	 * @return the terminalNumber
	 */
	public String getTerminalNumber() {
		return terminalNumber;
	}

	/**
	 * @param terminalNumber the terminalNumber to set
	 */
	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public void setCatchMethodId(Integer catchMethodId) {
		this.catchMethodId = catchMethodId;
	}

	public Date getCatchTransactionDate() {
		return this.catchTransactionDate;
	}

	public void setCatchTransactionDate(Date catchTransactionDate) {
		this.catchTransactionDate = catchTransactionDate;
	}

	public Double getComplementaryValue() {
		return this.complementaryValue;
	}

	public void setComplementaryValue(Double complementaryValue) {
		this.complementaryValue = complementaryValue;
	}

	public String getEstablishmentNumber() {
		return this.establishmentNumber;
	}

	public void setEstablishmentNumber(String establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	public Double getFeePercent() {
		return this.feePercent;
	}

	public void setFeePercent(Double feePercent) {
		this.feePercent = feePercent;
	}

	public Double getFeeValue() {
		return this.feeValue;
	}

	public void setFeeValue(Double feeValue) {
		this.feeValue = feeValue;
	}

	public String getFiller() {
		return this.filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getFinancialOperationNumber() {
		return this.financialOperationNumber;
	}

	public void setFinancialOperationNumber(String financialOperationNumber) {
		this.financialOperationNumber = financialOperationNumber;
	}

	public String getFinancialProductIdentifier() {
		return this.financialProductIdentifier;
	}

	public void setFinancialProductIdentifier(String financialProductIdentifier) {
		this.financialProductIdentifier = financialProductIdentifier;
	}

	public Double getGrossValue() {
		return this.grossValue;
	}

	public void setGrossValue(Double grossValue) {
		this.grossValue = grossValue;
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

	public Integer getParcel() {
		return this.parcel;
	}

	public void setParcel(Integer parcel) {
		this.parcel = parcel;
	}

	public Date getPaymentForecastDate() {
		return this.paymentForecastDate;
	}

	public void setPaymentForecastDate(Date paymentForecastDate) {
		this.paymentForecastDate = paymentForecastDate;
	}

	public Integer getPaymentStatusId() {
		return this.paymentStatusId;
	}

	public void setPaymentStatusId(Integer paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getRejectedSales() {
		return this.rejectedSales;
	}

	public void setRejectedSales(Integer rejectedSales) {
		this.rejectedSales = rejectedSales;
	}

	public Double getRejectedValue() {
		return this.rejectedValue;
	}

	public void setRejectedValue(Double rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getResaleAccelerationIndicator() {
		return this.resaleAccelerationIndicator;
	}

	public void setResaleAccelerationIndicator(String resaleAccelerationIndicator) {
		this.resaleAccelerationIndicator = resaleAccelerationIndicator;
	}

	public Date getSentBankDate() {
		return this.sentBankDate;
	}

	public void setSentBankDate(Date sentBankDate) {
		this.sentBankDate = sentBankDate;
	}

	public Double getTransactionFeeValue() {
		return this.transactionFeeValue;
	}

	public void setTransactionFeeValue(Double transactionFeeValue) {
		this.transactionFeeValue = transactionFeeValue;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Integer getTypeTransactionId() {
		return this.typeTransactionId;
	}

	public void setTypeTransactionId(Integer typeTransactionId) {
		this.typeTransactionId = typeTransactionId;
	}

	public Double getWarrantyFeeValue() {
		return this.warrantyFeeValue;
	}

	public void setWarrantyFeeValue(Double warrantyFeeValue) {
		this.warrantyFeeValue = warrantyFeeValue;
	}

}