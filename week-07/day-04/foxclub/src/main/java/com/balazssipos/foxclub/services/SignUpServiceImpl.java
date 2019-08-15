package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
  private FoxRepository foxRepository;
  private TrickService trickService;

  @Autowired
  public SignUpServiceImpl(FoxRepository foxRepository, TrickService trickService) {
    this.foxRepository = foxRepository;
    this.trickService = trickService;
  }

  @Override
  public Fox checkIfFoxExist(String name) {
    System.out.println("name:" + this.foxRepository.findAll().toString());
    if(this.foxRepository.findAll().containsKey(name)) {
      return this.foxRepository.findAll().get(name);
    } else {
      System.out.println(name);
      return new Fox(name);
    }
  }

  @Override
  public void addFoxToFoxHashMap(Fox fox) {
    this.foxRepository.addFoxToRepository(fox);
  }

  @Override
  public String getCurrentFoxName() {
    return this.foxRepository.getCurrentFoxName();
  }

  @Override
  public Fox getCurrentFox() {
    return this.foxRepository.findByName(this.foxRepository.getCurrentFoxName());
  }

  @Override
  public void setCurrentFox(String foxName) {
    this.foxRepository.setCurrentFoxName(foxName);
  }

  @Override
  public void initBasicTricks() {
    this.trickService.initBasicTricks();
  }
}
