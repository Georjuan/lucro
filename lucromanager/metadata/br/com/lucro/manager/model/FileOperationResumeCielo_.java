package br.com.lucro.manager.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-11-30T19:40:21.539-0200")
@StaticMetamodel(FileOperationResumeCielo.class)
public class FileOperationResumeCielo_ {
	public static volatile SingularAttribute<FileOperationResumeCielo, Long> id;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> acceptedSales;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> adjustmentSourceId;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> anticipatedGrossValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> bankAccountPayment;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> bankAgencyPayment;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> bankPayment;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> cardFlagId;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> catchMethodId;
	public static volatile SingularAttribute<FileOperationResumeCielo, Date> catchTransactionDate;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> complementaryValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> establishmentNumber;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> feePercent;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> feeValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> filler;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> financialOperationNumber;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> financialProductIdentifier;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> grossValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, FileHeaderCielo> header;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> netValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> operationResumeLotNumber;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> operationResumeNumber;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> parcel;
	public static volatile SingularAttribute<FileOperationResumeCielo, Date> paymentForecastDate;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> paymentStatusId;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> plan;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> productId;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> rejectedSales;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> rejectedValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> resaleAccelerationIndicator;
	public static volatile SingularAttribute<FileOperationResumeCielo, Date> sentBankDate;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> transactionFeeValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, Date> transferDate;
	public static volatile SingularAttribute<FileOperationResumeCielo, Integer> typeTransactionId;
	public static volatile SingularAttribute<FileOperationResumeCielo, Double> warrantyFeeValue;
	public static volatile SingularAttribute<FileOperationResumeCielo, String> terminalNumber;
}
