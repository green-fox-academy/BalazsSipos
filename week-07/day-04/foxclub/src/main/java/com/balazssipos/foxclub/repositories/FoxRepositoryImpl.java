package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Fox;
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
    this.currentFoxName = foxName;
  }

  @Override
  public void addFoxToRepository(Fox newFox) {
    this.foxHashMap.put(newFox.getName(), newFox);
  }
}
