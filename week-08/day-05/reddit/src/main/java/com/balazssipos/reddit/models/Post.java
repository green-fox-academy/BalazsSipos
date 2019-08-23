package com.balazssipos.reddit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  private String URL;
  private Integer popularity;
  private LocalDateTime creationDate;
//  private User user;

  public Post() {
    this("", "");
  }

  public Post(String title, String URL) {
    this.title = title;
    this.URL = URL;
    this.popularity = 0;
    this.creationDate = LocalDateTime.now();
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public Integer getPopularity() {
    return popularity;
  }

  public void setPopularity(Integer popularity) {
    this.popularity = popularity;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", URL='" + URL + '\'' +
            ", popularity=" + popularity +
            '}';
  }
}
