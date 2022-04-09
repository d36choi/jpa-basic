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

      Team team = new Team();
      team.setName("TEAM A");
      em.persist(team);
//
      final Member member = new Member();
      member.setUsername("ch");
      member.setTeam(team);
      em.persist(member);

      em.flush();
      em.clear();

      final Member member1 = em.find(Member.class, member.getId());
      final List<Member> members = member1.getTeam().getMembers();

      for (Member m : members) {
        System.out.println("m = " + m);
      }

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
