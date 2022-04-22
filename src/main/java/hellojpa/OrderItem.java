package hellojpa;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

//  @Column(name = "ORDER_ID")
//  private Long orderId;
//  필요없어짐 아래의 조인덕분

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "ORDER_ID")
  private Order order;

//  @Column(name = "ITEM_ID")
//  private Long itemId;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  @Column(name = "COUNT")
  private Long count;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}
