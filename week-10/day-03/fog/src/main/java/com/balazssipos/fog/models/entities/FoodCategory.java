package com.balazssipos.fog.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FoodCategory {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @ManyToOne
  private FogUser fogUser;

  public FoodCategory() {
  }

  public FoodCategory(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FogUser getFogUser() {
    return fogUser;
  }

  public void setFogUser(FogUser fogUser) {
    this.fogUser = fogUser;
  }
}
