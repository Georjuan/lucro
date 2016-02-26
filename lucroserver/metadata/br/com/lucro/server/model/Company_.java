package br.com.lucro.server.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-24T16:22:48.605-0300")
@StaticMetamodel(Company.class)
public class Company_ {
	public static volatile SingularAttribute<Company, Integer> id;
	public static volatile SingularAttribute<Company, User> user;
	public static volatile SingularAttribute<Company, String> businessName;
	public static volatile SingularAttribute<Company, String> tradingName;
	public static volatile SingularAttribute<Company, String> cnpj;
}
