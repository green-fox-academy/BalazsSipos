package com.balazssipos.foxclub.services;

import com.balazssipos.foxclub.models.entities.Nutrition;
import com.balazssipos.foxclub.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class NutritionServiceImpl implements NutritionService {
  private NutritionRepository nutritionRepository;

  @Autowired
  public NutritionServiceImpl(NutritionRepository nutritionRepository) {
    this.nutritionRepository = nutritionRepository;
  }

  @Override
  public HashMap<String, Nutrition> getAllDrinks() {
    return this.nutritionRepository.findAllDrinks();
  }

  @Override
  public HashMap<String, Nutrition> getAllFoods() {
    return this.nutritionRepository.findAllFoods();
  }

  @Override
  public void addNewNDrink(Nutrition newDrinkItem) {
    this.nutritionRepository.addDrinkItem(newDrinkItem);
  }

  @Override
  public void addNewNFood(Nutrition newFoodItem) {
    this.nutritionRepository.addFoodItem(newFoodItem);
  }

  @Override
  public Nutrition getFirstFood() {
    return this.nutritionRepository.getFirstFood();
  }

  @Override
  public Nutrition getFirstDrink() {
    return this.nutritionRepository.getFirstDrink();
  }
}
