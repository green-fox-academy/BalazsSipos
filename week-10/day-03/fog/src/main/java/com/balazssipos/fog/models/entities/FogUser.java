package com.balazssipos.fog.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
public class FogUser {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "fogUser")
  private List<FoodCategory> foodCategories;

  public FogUser() {
  }

  public FogUser(String name) {
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

  public void addFoodCategory(FoodCategory foodCategory) {
    this.foodCategories.add(foodCategory);
    foodCategory.setFogUser(this);
  }
}
