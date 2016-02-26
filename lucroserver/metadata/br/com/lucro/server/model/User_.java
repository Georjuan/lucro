package br.com.lucro.server.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-25T17:35:26.731-0300")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, String> hash;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Company> company;
}
