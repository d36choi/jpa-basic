package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOCKER")
public class Locker {

  @Id @GeneratedValue
  @Column(name = "LOCKER_ID")
  private Long id;

  @Column(name = "LOCKER_SIZE")
  private Long size;


  @OneToOne(mappedBy = "locker")
  private Member member;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }
}
