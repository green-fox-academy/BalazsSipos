package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Fox;
import org.springframework.stereotype.Service;

public interface SignUpService {
  boolean checkIfFoxExist(String name);
  void addFoxToFoxHashMap(Fox fox);
  String getCurrentFoxName();
  Fox getCurrentFox();
  void setCurrentFox(String foxName);
  void initFox(String foxName);
//  void initEnvironment();
}
