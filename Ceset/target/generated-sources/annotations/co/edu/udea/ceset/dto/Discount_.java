package co.edu.udea.ceset.dto;

import co.edu.udea.ceset.dto.Academicactivity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-26T14:58:38")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, Integer> idDiscount;
    public static volatile SingularAttribute<Discount, Double> total;
    public static volatile SingularAttribute<Discount, Integer> quantity;
    public static volatile SingularAttribute<Discount, String> description;
    public static volatile SingularAttribute<Discount, Academicactivity> idAcad;
    public static volatile SingularAttribute<Discount, Double> valuedis;

}