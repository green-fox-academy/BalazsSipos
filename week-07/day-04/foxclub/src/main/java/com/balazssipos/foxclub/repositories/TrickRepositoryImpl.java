package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TrickRepositoryImpl implements TrickRepository {
  private HashMap<String, Trick> trickHashMap;

  @Override
  public HashMap<String, Trick> findAll() {
    return null;
  }

  @Override
  public void createTrickRepositoryMap() {
    this.trickHashMap.put("sit", new Trick(1, "sit"));
    this.trickHashMap.put("eat", new Trick(2, "eat"));
    this.trickHashMap.put("run", new Trick(3, "run"));
  }
}
