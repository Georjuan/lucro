package br.com.lucro.manager.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-22T15:20:09.798-0200")
@StaticMetamodel(FileOperationResumeOutstandingBalanceCielo.class)
public class FileOperationResumeOutstandingBalanceCielo_ {
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Long> id;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> anticipatedValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Integer> cardFlagId;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Date> catchDate;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> cededIndicator;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> cededValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> currency;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> establishmentNumber;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> grossValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, FileHeaderCielo> header;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Integer> negotiatedParcelsSize;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> negotiatedValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> netValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> operationResumeLotNumber;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> operationResumeNumber;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Date> paymentDate;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Date> paymentForecastDate;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Integer> paymentPendingParcelsSize;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Integer> paymentSplitSize;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> pendingPaymentValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> platformType;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Date> referenceDate;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, String> releaseType;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Integer> salesReceiptSize;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Double> toCompensateValue;
	public static volatile SingularAttribute<FileOperationResumeOutstandingBalanceCielo, Date> transferDate;
}
