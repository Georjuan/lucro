package br.com.lucro.manager.model;

import java.io.Serializable;
import java.sql.Time;
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

/**
 * The persistent class for the file_tivit_cielo_sales_receipt database table.
 *
 * TIPO 2 - DETALHE DO COMPROVANTE DE VENDA (CV)
 * Detalhe das vendas ou ajustes agrupados em um RO, disponível no arquivo de venda ou de pagamento. Conforme
 * as regras de segurança, todos os registros que possuírem número de cartão apresentarão o número truncado.
 */
@Entity
@Table(name="file_tivit_cielo_sales_receipt")
@NamedQuery(name="FileSalesReceiptCielo.findAll", query="SELECT f FROM FileSalesReceiptCielo f")
public class FileSalesReceiptCielo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILE_TIVIT_CIELO_SALES_RECEIPT_ID_GENERATOR", sequenceName="FILE_TIVIT_CIELO_SALES_RECEIPT_ID_SEQ", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILE_TIVIT_CIELO_SALES_RECEIPT_ID_GENERATOR")
	private Long id;

	@Column(name="authorization_code")
	private String authorizationCode;

	@Column(name="card_number")
	private String cardNumber;

	@Column(name="card_numbers_size")
	private Integer cardNumbersSize;

	@Column(name="card_origin_id")
	private Integer cardOriginId;

	@Column(name="complementary_value")
	private Double complementaryValue;

	@Column(name="establishment_number")
	private String establishmentNumber;

	@Column(name="identifier_departure_tax_input_value")
	private String identifierDepartureTaxInputValue;

	@Column(name="installments_value")
	private Double installmentsValue;

	@Column(name="invoice_number")
	private String invoiceNumber;

	@Column(name="next_installment_value")
	private Double nextInstallmentValue;

	private String nsu;

	@Column(name="operation_resume_lot_number")
	private String operationResumeLotNumber;

	@Column(name="payment_split")
	private Integer paymentSplit;

	@Column(name="payment_split_size")
	private Integer paymentSplitSize;

	@Column(name="payment_value")
	private Double paymentValue;

	@Column(name="rejection_reason_id")
	private Integer rejectionReasonId;

	@Column(name="request_code")
	private String requestCode;

	@Temporal(TemporalType.DATE)
	@Column(name="sale_adjust_date")
	private Date saleAdjustDate;

	@Column(name="terminal_number")
	private String terminalNumber;

	private String tid;

	@Column(name="transaction_number", nullable=false, unique=true)
	private String transactionNumber;

	@Column(name="transaction_time")
	private Time transactionTime;
	
	@ManyToOne
	@JoinColumn(name="header_id", nullable=false, insertable=true)
	private FileHeaderCielo header;

	public FileSalesReceiptCielo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorizationCode() {
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardNumbersSize() {
		return this.cardNumbersSize;
	}

	public void setCardNumbersSize(Integer cardNumbersSize) {
		this.cardNumbersSize = cardNumbersSize;
	}

	public Integer getCardOriginId() {
		return this.cardOriginId;
	}

	public void setCardOriginId(Integer cardOriginId) {
		this.cardOriginId = cardOriginId;
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

	public String getIdentifierDepartureTaxInputValue() {
		return this.identifierDepartureTaxInputValue;
	}

	public void setIdentifierDepartureTaxInputValue(String identifierDepartureTaxInputValue) {
		this.identifierDepartureTaxInputValue = identifierDepartureTaxInputValue;
	}

	public Double getInstallmentsValue() {
		return this.installmentsValue;
	}

	public void setInstallmentsValue(Double installmentsValue) {
		this.installmentsValue = installmentsValue;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Double getNextInstallmentValue() {
		return this.nextInstallmentValue;
	}

	public void setNextInstallmentValue(Double nextInstallmentValue) {
		this.nextInstallmentValue = nextInstallmentValue;
	}

	public String getNsu() {
		return this.nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public String getOperationResumeLotNumber() {
		return this.operationResumeLotNumber;
	}

	public void setOperationResumeLotNumber(String operationResumeLotNumber) {
		this.operationResumeLotNumber = operationResumeLotNumber;
	}

	public Integer getPaymentSplit() {
		return this.paymentSplit;
	}

	public void setPaymentSplit(Integer paymentSplit) {
		this.paymentSplit = paymentSplit;
	}

	public Integer getPaymentSplitSize() {
		return this.paymentSplitSize;
	}

	public void setPaymentSplitSize(Integer paymentSplitSize) {
		this.paymentSplitSize = paymentSplitSize;
	}

	public Double getPaymentValue() {
		return this.paymentValue;
	}

	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}

	public Integer getRejectionReasonId() {
		return this.rejectionReasonId;
	}

	public void setRejectionReasonId(Integer rejectionReasonId) {
		this.rejectionReasonId = rejectionReasonId;
	}

	public String getRequestCode() {
		return this.requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public Date getSaleAdjustDate() {
		return this.saleAdjustDate;
	}

	public void setSaleAdjustDate(Date saleAdjustDate) {
		this.saleAdjustDate = saleAdjustDate;
	}

	public String getTerminalNumber() {
		return this.terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Time getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Time transactionTime) {
		this.transactionTime = transactionTime;
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

}