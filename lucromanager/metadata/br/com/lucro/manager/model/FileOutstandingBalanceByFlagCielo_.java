package br.com.lucro.manager.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-25T10:35:41.373-0200")
@StaticMetamodel(FileOutstandingBalanceByFlagCielo.class)
public class FileOutstandingBalanceByFlagCielo_ {
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Long> id;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Double> anticipatedValue;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Integer> branchesSize;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Integer> cardFlagId;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Double> cededValue;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, String> establishmentNumber;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Double> grossValue;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, FileHeaderCielo> header;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Double> netValue;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, String> platformType;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Date> referenceDate;
	public static volatile SingularAttribute<FileOutstandingBalanceByFlagCielo, Double> toCompensateValue;
}
