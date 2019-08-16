package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
  private FoxRepository foxRepository;
  private TrickService trickService;
  private NutritionService nutritionService;

  @Autowired
  public SignUpServiceImpl(FoxRepository foxRepository, TrickService trickService, NutritionService nutritionService) {
    this.foxRepository = foxRepository;
    this.trickService = trickService;
    this.nutritionService = nutritionService;
  }

  @Override
  public boolean checkIfFoxExist(String name) {
//    System.out.println("name:" + this.foxRepository.findAll().toString());
    if(this.foxRepository.findAll().containsKey(name)) {
      return true;
    } else {
      System.out.println("aaa" + name);
      return false;
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
  public void initFox(String foxName) {
    Fox fox;
    if(this.checkIfFoxExist(foxName)) {
      fox = this.foxRepository.findAll().get(foxName);
    } else {
      System.out.println("bbb" + foxName);
      fox = new Fox(foxName, this.nutritionService.getFirstFood(), this.nutritionService.getFirstDrink());
    }
    System.out.println("fox:" + fox.toString());

    this.foxRepository.addFoxToRepository(fox);

    this.foxRepository.setCurrentFoxName(foxName);
  }

//  @Override
//  public void initEnvironment() {
//    this.trickService.initBasicTricks();
//  }
}
