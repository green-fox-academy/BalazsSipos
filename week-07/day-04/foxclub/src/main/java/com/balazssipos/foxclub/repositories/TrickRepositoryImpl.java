package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TrickRepositoryImpl implements TrickRepository {
  private HashMap<String, Trick> trickHashMap;

  public TrickRepositoryImpl() {
    this.trickHashMap = new HashMap<>();
    this.trickHashMap.put("sit", new Trick("sit"));
    this.trickHashMap.put("eat", new Trick("eat"));
    this.trickHashMap.put("drink", new Trick("drink"));
  }

  @Override
  public HashMap<String, Trick> findAll() {
    return this.trickHashMap;
  }

  @Override
  public void addTrickItem(Trick trickItem) {
    if(!checkIfTrickItemAlreadyExist(trickItem)) {
      this.trickHashMap.put(trickItem.getName(), trickItem);
    }
  }

  @Override
  public boolean checkIfTrickItemAlreadyExist(Trick trickItem) {
    if(this.trickHashMap.containsKey(trickItem.getName())) {
      return true;
    }
    return false;
  }

//  @Override
//  public void createTrickRepositoryMap() {
//
//  }
}
