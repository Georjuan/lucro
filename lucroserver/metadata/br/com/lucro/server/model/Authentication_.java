package br.com.lucro.server.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-21T14:35:53.321-0200")
@StaticMetamodel(Authentication.class)
public class Authentication_ {
	public static volatile SingularAttribute<Authentication, String> username;
	public static volatile SingularAttribute<Authentication, String> session;
	public static volatile SingularAttribute<Authentication, String> userType;
}
