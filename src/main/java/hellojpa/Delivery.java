package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "DELIVERY_ID")
  private Long id;

  @Column(name = "STREET")
  private String street;


  @Column(name = "ZIPCODE")
  private String zipcode;


  @Column(name = "STATUS")
  private DeliveryStatus status;


  @OneToOne(mappedBy = "delivery")
  private Order order;
}
