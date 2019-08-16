package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Trick;

import java.util.HashMap;

public interface TrickService {
  HashMap<String, Trick> getAllTricks();
  void addNewTrick(Trick newTrick);
//  void initBasicTricks();
}
