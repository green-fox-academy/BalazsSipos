package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Trick;
import com.balazssipos.foxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TrickServiceImpl implements TrickService {
  private TrickRepository trickRepository;

  @Autowired
  public TrickServiceImpl(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  @Override
  public HashMap<String, Trick> getAllTricks() {
    return this.trickRepository.findAll();
  }

  @Override
  public void addNewTrick(Trick newTrick) {
    if(!this.trickRepository.checkIfTrickItemAlreadyExist(newTrick)) {
      this.trickRepository.addTrickItem(newTrick);
    }
  }

//  @Override
//  public void initBasicTricks() {
//    this.trickRepository.createTrickRepositoryMap();
//  }
}
