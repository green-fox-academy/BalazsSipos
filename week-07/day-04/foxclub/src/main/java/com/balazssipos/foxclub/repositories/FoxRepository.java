package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Component
public interface FoxRepository {
  HashMap<String, Fox> findAll();
  Fox findByName(String name);
  String getCurrentFoxName();
  void setCurrentFoxName(String foxName);
  void addFoxToRepository(Fox newFox);
  void changeDrink(String drinkName);
  void changeFood(String foodName);
  void learnTrick(Trick newTrick);
  boolean checkIfTrickIsAlreadyKnown(Trick newTrick);
}
