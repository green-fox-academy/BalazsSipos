package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.models.entities.Nutrition;
import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FoxRepositoryImpl implements FoxRepository {
  private HashMap<String, Fox> foxHashMap;
  private String currentFoxName;

  public FoxRepositoryImpl() {
    this.foxHashMap = new HashMap<>();
  }

  @Override
  public HashMap<String, Fox> findAll() {
    return this.foxHashMap;
  }

  @Override
  public Fox findByName(String name) {
    if(this.foxHashMap.containsKey(name)) {
      return this.foxHashMap.get(name);
    }
    return null;

  }

  @Override
  public String getCurrentFoxName() {
    return this.currentFoxName;
  }

  @Override
  public void setCurrentFoxName(String foxName) {
    if(this.currentFoxName != foxName) {
      this.currentFoxName = foxName;
    }
  }

  @Override
  public void addFoxToRepository(Fox newFox) {
    if(this.foxHashMap.get(newFox.getName()) == null) {
      this.foxHashMap.put(newFox.getName(), newFox);
    }
  }

  @Override
  public void changeDrink(String drinkName) {
    this.foxHashMap.get(this.currentFoxName).setDrink(new Nutrition(drinkName));
  }

  @Override
  public void changeFood(String foodName) {
    this.foxHashMap.get(this.currentFoxName).setFood(new Nutrition(foodName));
  }

  @Override
  public void learnTrick(Trick newTrick) {
    this.foxHashMap.get(this.currentFoxName).learnNewTrick(newTrick);
  }

  @Override
  public boolean checkIfTrickIsAlreadyKnown(Trick newTrick) {
    if(this.foxHashMap.get(this.currentFoxName).getTrickHashMap().containsKey(newTrick.getName())) {
      return true;
    }
    return false;
  }
}
