package com.balazssipos.foxclub.models.entities;

import java.util.HashMap;

public class Fox {
  private String name;
  private HashMap<String, Trick> trickHashMap;
  private Nutrition food;
  private Nutrition drink;

  public Fox(String name) {
    this.name = name;
    this.trickHashMap = new HashMap<>();
  }

  public Fox(String name, Nutrition food, Nutrition drink) {
    this(name);
    this.food = food;
    this.drink = drink;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashMap<String, Trick> getTrickHashMap() {
    return trickHashMap;
  }

  public void setTrickHashMap(HashMap<String, Trick> trickHashMap) {
    this.trickHashMap = trickHashMap;
  }

  public Nutrition getFood() {
    return food;
  }

  public void setFood(Nutrition food) {
    this.food = food;
  }

  public Nutrition getDrink() {
    return drink;
  }

  public void setDrink(Nutrition drink) {
    this.drink = drink;
  }

  @Override
  public String toString() {
    return "Fox{" +
            "name='" + name + '\'' +
            ", trickHashMap=" + trickHashMap +
            ", food='" + food + '\'' +
            ", drink='" + drink + '\'' +
            '}';
  }
}
