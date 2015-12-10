package br.com.lucro.manager.model;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-02T16:46:24.682-0200")
@StaticMetamodel(FileSalesReceiptCielo.class)
public class FileSalesReceiptCielo_ {
	public static volatile SingularAttribute<FileSalesReceiptCielo, Long> id;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> authorizationCode;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> cardNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Integer> cardNumbersSize;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Integer> cardOriginId;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Double> complementaryValue;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> establishmentNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> identifierDepartureTaxInputValue;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Double> installmentsValue;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> invoiceNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Double> nextInstallmentValue;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> nsu;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> operationResumeLotNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Integer> paymentSplit;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Integer> paymentSplitSize;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Double> paymentValue;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Integer> rejectionReasonId;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> requestCode;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Date> saleAdjustDate;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> terminalNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> tid;
	public static volatile SingularAttribute<FileSalesReceiptCielo, String> transactionNumber;
	public static volatile SingularAttribute<FileSalesReceiptCielo, Time> transactionTime;
	public static volatile SingularAttribute<FileSalesReceiptCielo, FileHeaderCielo> header;
}
