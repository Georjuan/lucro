package br.com.lucro.server.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-03-02T09:40:07.690-0300")
@StaticMetamodel(CompanyAcquirer.class)
public class CompanyAcquirer_ {
	public static volatile SingularAttribute<CompanyAcquirer, CompanyAcquirerPK> id;
	public static volatile SingularAttribute<CompanyAcquirer, String> email;
	public static volatile SingularAttribute<CompanyAcquirer, String> password;
	public static volatile SingularAttribute<CompanyAcquirer, String> username;
	public static volatile SingularAttribute<CompanyAcquirer, String> postalcode;
	public static volatile SingularAttribute<CompanyAcquirer, String> establishmentNumber;
}
