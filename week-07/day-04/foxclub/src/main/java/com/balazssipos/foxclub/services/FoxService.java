package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Service;

public interface FoxService {
  boolean checkIfFoxExist(String name);
  void addFoxToFoxHashMap(Fox fox);
  String getCurrentFoxName();
  Fox getCurrentFox();
  void setCurrentFox(String foxName);
  void initFox(String foxName);
  void changeDrinkOnFox(String drinkName);
  void changeFoodOnFox(String foodName);
  void learnTrickItem(Trick trickItem);
}
