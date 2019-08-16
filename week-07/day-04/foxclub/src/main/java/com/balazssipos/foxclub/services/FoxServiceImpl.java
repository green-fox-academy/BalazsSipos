package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Fox;
import com.balazssipos.foxclub.models.entities.Nutrition;
import com.balazssipos.foxclub.models.entities.Trick;
import com.balazssipos.foxclub.repositories.FoxRepository;
import com.balazssipos.foxclub.repositories.NutritionRepository;
import com.balazssipos.foxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxServiceImpl implements FoxService {
  private FoxRepository foxRepository;
  private TrickService trickService;
  private NutritionService nutritionService;
  private NutritionRepository nutritionRepository;

  @Autowired
  public FoxServiceImpl(FoxRepository foxRepository, TrickService trickService, NutritionService nutritionService,
                        NutritionRepository nutritionRepository) {
    this.foxRepository = foxRepository;
    this.trickService = trickService;
    this.nutritionService = nutritionService;
    this.nutritionRepository = nutritionRepository;
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

  @Override
  public void changeDrinkOnFox(String drinkName) {
    boolean validDrink = this.nutritionRepository.checkIfDrinkItemAlreadyExist(new Nutrition(drinkName));
    if(validDrink) {
      this.foxRepository.changeDrink(drinkName);
    }
  }

  @Override
  public void changeFoodOnFox(String foodName) {
    boolean validFood = this.nutritionRepository.checkIfFoodItemAlreadyExist(new Nutrition(foodName));
    if(validFood) {
      this.foxRepository.changeFood(foodName);
    }
  }

  @Override
  public void learnTrickItem(Trick trickItem) {
    this.foxRepository.learnTrick(trickItem);
  }



//  @Override
//  public void initEnvironment() {
//    this.trickService.initBasicTricks();
//  }
}
