package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Date> dateTimeModified;
	public static volatile SingularAttribute<Employee, String> names;
	public static volatile SingularAttribute<Employee, String> address;
	public static volatile SingularAttribute<Employee, String> documentType;
	public static volatile SingularAttribute<Employee, String> city;
	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> documentNumber;
	public static volatile SingularAttribute<Employee, Department> departmentId;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Date> dateTimeCreate;
	public static volatile SingularAttribute<Employee, String> surnames;
	public static volatile SingularAttribute<Employee, String> email;

}

