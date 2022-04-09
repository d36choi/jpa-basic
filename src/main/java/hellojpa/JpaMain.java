package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    final EntityManager em = emf.createEntityManager();

    final EntityTransaction tx = em.getTransaction();

//    transaction start
    tx.begin();
    try {

      Order order = new Order();
      final OrderItem orderItem = new OrderItem();
      order.addOrderItem(orderItem);
      em.persist(orderItem);
      em.persist(order);
      tx.commit();

    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();

    }
//    transaction end
    emf.close();

    return;
  }

}
