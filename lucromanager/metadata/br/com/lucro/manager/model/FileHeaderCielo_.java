package br.com.lucro.manager.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-02T18:42:55.386-0200")
@StaticMetamodel(FileHeaderCielo.class)
public class FileHeaderCielo_ {
	public static volatile SingularAttribute<FileHeaderCielo, Long> id;
	public static volatile SingularAttribute<FileHeaderCielo, Date> endDate;
	public static volatile SingularAttribute<FileHeaderCielo, String> establishmentNumber;
	public static volatile SingularAttribute<FileHeaderCielo, String> fileNumber;
	public static volatile SingularAttribute<FileHeaderCielo, String> layoutVersion;
	public static volatile SingularAttribute<FileHeaderCielo, Date> processDate;
	public static volatile SingularAttribute<FileHeaderCielo, Date> startDate;
	public static volatile SingularAttribute<FileHeaderCielo, Integer> typeExtractOptionId;
	public static volatile SingularAttribute<FileHeaderCielo, String> van;
	public static volatile SingularAttribute<FileHeaderCielo, String> mailbox;
	public static volatile SingularAttribute<FileHeaderCielo, String> file;
}
