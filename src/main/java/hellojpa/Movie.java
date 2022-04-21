package hellojpa;

import javax.persistence.Entity;

@Entity
public class Movie extends Item{
  private String director;


  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }
}
