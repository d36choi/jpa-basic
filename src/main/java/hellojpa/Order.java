package hellojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems = new ArrayList<>();

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }
}