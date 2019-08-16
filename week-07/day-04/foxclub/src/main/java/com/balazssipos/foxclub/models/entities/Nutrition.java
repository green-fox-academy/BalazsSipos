package com.balazssipos.foxclub.models.entities;

public class Nutrition {
  private String name;

  public String getName() {
    return name;
  }

  public Nutrition(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Nutrition{" +
            "name='" + name + '\'' +
            '}';
  }
}
