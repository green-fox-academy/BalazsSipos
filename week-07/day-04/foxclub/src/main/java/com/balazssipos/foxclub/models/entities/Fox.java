package com.balazssipos.foxclub.models.entities;

import java.util.HashMap;

public class Fox {
  private String name;
  private HashMap<String, Trick> trickHashMap;
  private String food;
  private String drink;

  public Fox(String name) {
    this.name = name;
    this.trickHashMap = new HashMap<>();
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

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
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
