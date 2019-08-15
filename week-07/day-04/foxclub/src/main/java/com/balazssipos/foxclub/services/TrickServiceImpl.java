package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Trick;
import com.balazssipos.foxclub.repositories.TrickRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TrickServiceImpl implements TrickService {
  private TrickRepository trickRepository;

  public TrickServiceImpl(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  @Override
  public HashMap<String, Trick> getAllTricks() {
    return this.trickRepository.findAll();
  }

  @Override
  public void initBasicTricks() {
    this.trickRepository.createTrickRepositoryMap();
  }
}
